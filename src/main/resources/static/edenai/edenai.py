import json
import requests
from dotenv import load_dotenv
import os
import shutil

"""
edenai.py sends a request to openai to generate an image using EdenAI API, and downloads these images to images/ directory.
An image is generated using a prompt: Sequence of 3 words.

To use: 
1. User must have an account with EdenAI
2. Include a local .env file in the same directory as edenai.py
3. Include SECRET_KEY= <user_api_key>

Ex: SECRET_KEY=kba234unbm
Where "kba234unbm" is the user's api key
"""

# Read .env and get key
load_dotenv()
KEY = "Bearer " + os.getenv('SECRET_KEY','Default:No Key Found')

# Headers for authentication
headers = {"Authorization": KEY}
# URL to send request to
url = "https://api.edenai.run/v2/image/generation"




def send_request(prompt:str) -> requests.Response:
    """ Send a request to generate an image that includes elements from the prompt.
        A prompt must have 3 words and be seperated by a comma with no spaces. A word
        in the prompt may include spaces. 

        Example:  
        Valid prompts: 
        Angry,Running,Lightning
        Coffee,George Washington,New York

        Bad prompts:
        News, Zoo (Cannot have space after a comma and must have 3 words), 
        Mug-Apple-Cable (Words must be seperated with a ',' )
    """

    payload = {
    "providers": "openai",
    "text": "A realistic product photo that incorporates these 3 elements: " + prompt,
    "resolution": "1024x1024",
    "fallback_providers": ""
    }
    response = requests.post(url,json=payload,headers=headers)

    return response


def download_image(url,prompt:str):
    """ Tokenize prompts to create .png file name and add it to images directory. 
        If images/ directory already exists, ignore exception. Else, creates it.
        Image file names are named by the words in the prompt, seperated by '-' followed by .png file extension.

        Example:
        Prompt:    Foo,Bar,Soap
        File name: Foo-Bar-Soap.png
    """
    
    filename = 'images/' + '-'.join(prompt.split(',')) + ".png"
    parent = os.path.join(os.getcwd(),os.pardir)
    images_filepath = os.path.join(parent,filename)

    os.makedirs(os.path.dirname(images_filepath),exist_ok=True)
    download_response = requests.get(url, stream=True)

    # Evaluate HTTP response status code.
    if download_response.status_code == 200:

        download_response.raw.decode_content = True
        with open(images_filepath,'wb') as f:
            shutil.copyfileobj(download_response.raw,f)
        
        print("Downloaded image: " + filename)
    
    else:
        print("Prompt: <" + prompt + "> could not be downloaded.")
        print("Attempted to download url: " + url)


def handle_response(response:requests.Response,prompt:str):
    match response.status_code:
        case 200:
            result = json.loads(response.text)
            try:
                image_url = result['openai']['items'][0]['image_resource_url']
                print("URL --> ",image_url) 
                download_image(image_url,prompt)
            except:
                with open("error_report.txt","a") as f:
                    f.write(prompt + "\n")
        case 400:
            print("Bad Request, check input")
        case 403:
            print("Forbidden Access, check authorization")
        case 415:
            print("Unsupported Media-Type, check encoding for request")
        case 429:
            print("Too many requests, check request rate")
        case 500:
            print("Internal Error, edenai's fault.")


def generate(prompt:str):
    response = send_request(prompt)
    handle_response(response,prompt)



####### Sample flow #############
# def main():
#     prompt = "canoe,mockingbird,sunset"

#     generate(prompt)

# main()
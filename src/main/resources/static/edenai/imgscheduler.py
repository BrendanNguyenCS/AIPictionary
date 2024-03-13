import time
import schedule
import datetime
import edenai


prompts = []
with open("prompts.txt","r") as f:
    line = f.readline().strip("\n")
    while line:
        prompts.append(line)
        line = f.readline().strip("\n")




def task():
    if(len(prompts) > 0):
        prompt = prompts.pop()
        edenai.generate(prompt)
        timestamp = datetime.datetime.now()
        print(f"[{prompt}] ==> {timestamp}")
    else:
        print("Prompts empty")
    


schedule.every().minute.at(":01").do(task)
schedule.every().minute.at(":02").do(task)
schedule.every().minute.at(":03").do(task)
schedule.every().minute.at(":04").do(task)
schedule.every().minute.at(":05").do(task)
while (len(prompts) != 0):
    schedule.run_pending()
    time.sleep(1)
    

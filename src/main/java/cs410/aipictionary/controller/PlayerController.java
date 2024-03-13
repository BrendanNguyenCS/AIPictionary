package cs410.aipictionary.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PlayerController {

    @GetMapping("/player")
    public String getPlayer() {
        return "player";
    }
}

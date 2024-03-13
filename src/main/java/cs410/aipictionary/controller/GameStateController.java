package cs410.aipictionary.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GameStateController {

    @GetMapping("/gamestate")
    public String getGameState() {
        return "gamestate";
    }
}

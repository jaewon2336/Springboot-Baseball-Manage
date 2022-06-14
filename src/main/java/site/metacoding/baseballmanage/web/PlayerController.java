package site.metacoding.baseballmanage.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PlayerController {

    @GetMapping("/player/list")
    public String plyerList() {
        return "/player/playerList";
    }

    @GetMapping("/player/position/list")
    public String plyerByPositionList() {
        return "/player/playerByPositionList";
    }

    @GetMapping("/player/save-form")
    public String saveForm() {
        return "/player/playerSaveForm";
    }
}

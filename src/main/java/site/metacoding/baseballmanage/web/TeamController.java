package site.metacoding.baseballmanage.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TeamController {

    @GetMapping("/team/list")
    public String teamList() {
        return "/team/teamList";
    }

    @GetMapping("/team/save-form")
    public String saveForm() {
        return "/team/teamSaveForm";
    }
}

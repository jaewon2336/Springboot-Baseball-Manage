package site.metacoding.baseballmanage.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StadiumController {

    @GetMapping({ "/", "/stadium/list" })
    public String main() {
        return "/stadium/stadiumList";
    }

    @GetMapping("/stadium/save-form")
    public String saveForm() {
        return "/stadium/stadiumSaveForm";
    }
}

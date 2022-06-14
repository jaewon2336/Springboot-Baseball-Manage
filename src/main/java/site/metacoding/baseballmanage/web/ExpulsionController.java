package site.metacoding.baseballmanage.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExpulsionController {

    @GetMapping("/expulsion/list")
    public String expulsionList() {
        return "/expulsion/expulsionList";
    }

    @GetMapping("/expulsion/save-form")
    public String saveForm() {
        return "/expulsion/expulsionSaveForm";
    }
}

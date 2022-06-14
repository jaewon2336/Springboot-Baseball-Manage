package site.metacoding.baseballmanage.web;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;
import site.metacoding.baseballmanage.domain.stadium.Stadium;
import site.metacoding.baseballmanage.service.StadiumService;

@RequiredArgsConstructor
@Controller
public class StadiumController {

    private final StadiumService stadiumService;

    @GetMapping({ "/", "/stadium/list" })
    public String main(Model model) {
        List<Stadium> stadiums = stadiumService.stadiumFindAll();
        model.addAttribute("stadiums", stadiums);
        return "/stadium/stadiumList";
    }

    @GetMapping("/stadium/save-form")
    public String saveForm() {
        System.out.println("1");
        return "/stadium/stadiumSaveForm";
    }

    @PostMapping("/stadium")
    public String save(String name) {
        stadiumService.stadiumSave(name);
        return "redirect:/stadium/list";
    }

    @DeleteMapping("/stadium")
    public ResponseEntity<?> delete(Integer id) {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

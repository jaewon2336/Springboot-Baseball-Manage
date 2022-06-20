package site.metacoding.baseballmanage.web;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;
import site.metacoding.baseballmanage.service.StadiumService;
import site.metacoding.baseballmanage.web.dto.StadiumRespDto;

@RequiredArgsConstructor
@Controller
public class StadiumController {

    private final StadiumService stadiumService;

    @GetMapping({ "/", "/stadium" })
    public String main() {
        return "/stadium/stadiumList";
    }

    @GetMapping("/stadium/save-form")
    public String saveForm() {
        return "/stadium/stadiumSaveForm";
    }

    @GetMapping("/api/stadium")
    public ResponseEntity<?> findAll() {
        List<StadiumRespDto> stadiums = stadiumService.findAllDtos();
        return new ResponseEntity<>(stadiums, HttpStatus.OK);
    }

    @PostMapping("/stadium")
    public String save(String name) {
        stadiumService.save(name);
        return "redirect:/stadium";
    }

    @DeleteMapping("/api/stadium/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        stadiumService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

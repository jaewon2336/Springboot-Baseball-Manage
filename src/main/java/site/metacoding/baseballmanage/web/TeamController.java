package site.metacoding.baseballmanage.web;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import lombok.RequiredArgsConstructor;
import site.metacoding.baseballmanage.domain.stadium.Stadium;
import site.metacoding.baseballmanage.service.StadiumService;
import site.metacoding.baseballmanage.service.TeamService;
import site.metacoding.baseballmanage.web.dto.TeamRespDto;
import site.metacoding.baseballmanage.web.dto.TeamSaveRepDto;

@RequiredArgsConstructor
@Controller
public class TeamController {

    private final TeamService teamService;
    private final StadiumService stadiumService;

    @GetMapping("/team")
    public String teamList() {
        return "/team/teamList";
    }

    @GetMapping("/team/save-form")
    public String saveForm(Model model) {
        List<Stadium> stadiums = stadiumService.findAll();
        model.addAttribute("stadiums", stadiums);
        return "/team/teamSaveForm";
    }

    @PostMapping("/team")
    public ResponseEntity<?> save(@RequestBody TeamSaveRepDto teamSaveRepDto) {
        teamService.save(teamSaveRepDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/api/team")
    public ResponseEntity<?> findAll() {
        List<TeamRespDto> teams = teamService.findAllDtos();
        return new ResponseEntity<>(teams, HttpStatus.OK);
    }

    @DeleteMapping("/api/team/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        teamService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

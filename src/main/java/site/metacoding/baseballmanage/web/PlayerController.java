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
import site.metacoding.baseballmanage.domain.team.Team;
import site.metacoding.baseballmanage.service.PlayerService;
import site.metacoding.baseballmanage.service.TeamService;
import site.metacoding.baseballmanage.web.dto.PlayerRespDto;
import site.metacoding.baseballmanage.web.dto.PlayerSaveReqDto;

@RequiredArgsConstructor
@Controller
public class PlayerController {

    private final PlayerService playerService;
    private final TeamService teamService;

    @GetMapping("/player/list")
    public String plyerList() {
        return "/player/playerList";
    }

    @GetMapping("/player/position/list")
    public String plyerByPositionList() {
        return "/player/playerByPositionList";
    }

    @GetMapping("/player/save-form")
    public String saveForm(Model model) {
        List<Team> teams = teamService.findAll();
        model.addAttribute("teams", teams);
        return "/player/playerSaveForm";
    }

    @GetMapping("/api/player")
    public ResponseEntity<?> findAll() {
        List<PlayerRespDto> players = playerService.findAllDtos();
        return new ResponseEntity<>(players, HttpStatus.OK);
    }

    @PostMapping("/player")
    public ResponseEntity<?> save(@RequestBody PlayerSaveReqDto playerSaveRepDto) {
        playerService.save(playerSaveRepDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/api/player/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        playerService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

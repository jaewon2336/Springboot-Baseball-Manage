package site.metacoding.baseballmanage.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.qlrm.mapper.JpaResultMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import site.metacoding.baseballmanage.domain.player.Player;
import site.metacoding.baseballmanage.domain.player.PlayerRepository;
import site.metacoding.baseballmanage.domain.team.Team;
import site.metacoding.baseballmanage.domain.team.TeamRepository;
import site.metacoding.baseballmanage.web.dto.PlayerRespDto;
import site.metacoding.baseballmanage.web.dto.PlayerSaveReqDto;

@RequiredArgsConstructor
@Service
public class PlayerService {

    private final PlayerRepository playerRepository;
    private final TeamRepository teamRepository;

    private final EntityManager em;

    public List<PlayerRespDto> findAllDtos() {
        String sql = "select rownum no, a.* from (select p.id, t.name team, p.position, p.name, to_char(p.createDate, 'YYYY-MM-DD') createDate from player p inner join team t on p.teamid = t.id order by p.name)a";
        Query query = em.createNativeQuery(sql);

        JpaResultMapper mapper = new JpaResultMapper();
        List<PlayerRespDto> teams = mapper.list(query, PlayerRespDto.class);

        return teams;
    }

    @Transactional
    public void save(PlayerSaveReqDto playerSaveReqDto) {

        Team team = teamRepository.findById(playerSaveReqDto.getTeamId()).get();

        Player player = Player.builder()
                .team(team)
                .position(playerSaveReqDto.getPosition())
                .name(playerSaveReqDto.getName())
                .build();

        playerRepository.save(player);
    }

    @Transactional
    public void deleteById(Integer id) {
        playerRepository.deleteById(id);
    }
}

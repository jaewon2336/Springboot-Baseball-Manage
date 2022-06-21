package site.metacoding.baseballmanage.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.qlrm.mapper.JpaResultMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import site.metacoding.baseballmanage.domain.stadium.Stadium;
import site.metacoding.baseballmanage.domain.stadium.StadiumRepository;
import site.metacoding.baseballmanage.domain.team.Team;
import site.metacoding.baseballmanage.domain.team.TeamRepository;
import site.metacoding.baseballmanage.handler.ex.CustomException;
import site.metacoding.baseballmanage.web.dto.TeamRespDto;
import site.metacoding.baseballmanage.web.dto.TeamSaveRepDto;

@RequiredArgsConstructor
@Service
public class TeamService {

    private final TeamRepository teamRepository;
    private final StadiumRepository stadiumRepository;

    private final EntityManager em;

    @Transactional
    public void save(TeamSaveRepDto teamSaveRepDto) {
        Integer stadiumId = teamSaveRepDto.getStadiumId();
        String name = teamSaveRepDto.getName();

        // DB에서 SELECT 한 목록 중에 선택한거니까 Optional로 받지 않는다.
        Stadium stadiumEntity = stadiumRepository.findById(teamSaveRepDto.getStadiumId()).get();

        // 만약 해당 stadium에 매핑된 team이 있는지 확인
        Optional<Team> teamOp = teamRepository.findByStadiumId(stadiumId);

        if (teamOp.isPresent()) {
            // 해당 야구장에는 이미 팀이 존재합니다.
            throw new CustomException("해당 야구장에는 이미 팀이 존재합니다.");
        }

        Team team = Team.builder()
                .stadium(stadiumEntity)
                .name(name)
                .build();

        teamRepository.save(team);
    }

    public List<TeamRespDto> findAllDtos() {
        // no
        String sql = "SELECT rownum no, a.* FROM (SELECT t.id, s.name stadium, t.name, to_char(t.createDate, 'YYYY-MM-DD') createDate FROM team t inner join stadium s on t.stadiumid = s.id ORDER BY t.name)a";
        Query query = em.createNativeQuery(sql);

        JpaResultMapper mapper = new JpaResultMapper();
        List<TeamRespDto> teams = mapper.list(query, TeamRespDto.class);

        return teams;
    }

    public List<Team> findAll() {
        return teamRepository.findAll();
    }

    @Transactional
    public void deleteById(Integer id) {
        teamRepository.deleteById(id);
    }

}

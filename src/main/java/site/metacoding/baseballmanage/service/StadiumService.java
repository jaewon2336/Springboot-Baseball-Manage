package site.metacoding.baseballmanage.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.qlrm.mapper.JpaResultMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import site.metacoding.baseballmanage.domain.stadium.Stadium;
import site.metacoding.baseballmanage.domain.stadium.StadiumRepository;
import site.metacoding.baseballmanage.web.dto.StadiumRespDto;

@RequiredArgsConstructor
@Service
public class StadiumService {

    private final StadiumRepository stadiumRepository;
    private final EntityManager em;

    @Transactional
    public void save(String name) {
        Stadium stadium = Stadium.builder().name(name).build();
        stadiumRepository.save(stadium);
    }

    public List<StadiumRespDto> findAllDtos() {

        // no
        String sql = "SELECT id, rownum no, name, to_char(createDate, 'YYYY-MM-DD') createDate FROM (SELECT * FROM stadium ORDER BY name)";
        Query query = em.createNativeQuery(sql);

        JpaResultMapper mapper = new JpaResultMapper();
        List<StadiumRespDto> stadiums = mapper.list(query, StadiumRespDto.class);

        return stadiums;
    }

    public List<Stadium> findAll() {
        return stadiumRepository.findAll();
    }

    @Transactional
    public void deleteById(Integer id) {
        stadiumRepository.deleteById(id);
    }
}

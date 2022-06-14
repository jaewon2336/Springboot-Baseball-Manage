package site.metacoding.baseballmanage.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.qlrm.mapper.JpaResultMapper;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import site.metacoding.baseballmanage.domain.stadium.Stadium;
import site.metacoding.baseballmanage.domain.stadium.StadiumRepository;
import site.metacoding.baseballmanage.web.dto.StadiumRespDto;

@RequiredArgsConstructor
@Service
public class StadiumService {

    private final StadiumRepository stadiumRepository;
    private final EntityManager em;

    public void stadiumSave(String name) {
        Stadium stadium = new Stadium();
        stadium.setName(name);
        stadiumRepository.save(stadium);
    }

    public List<StadiumRespDto> stadiumFindAll() {

        String sql = "SELECT rownum no, name, createDate FROM (SELECT * FROM stadium ORDER BY name)";
        Query query = em.createNativeQuery(sql);

        JpaResultMapper mapper = new JpaResultMapper();
        List<StadiumRespDto> stadiums = mapper.list(query, StadiumRespDto.class);

        return stadiums;
    }
}

package site.metacoding.baseballmanage.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import site.metacoding.baseballmanage.domain.stadium.Stadium;
import site.metacoding.baseballmanage.domain.stadium.StadiumRepository;

@RequiredArgsConstructor
@Service
public class StadiumService {

    private final StadiumRepository stadiumRepository;

    public void stadiumSave(String name) {
        Stadium stadium = Stadium.builder().name(name).build();
        stadiumRepository.save(stadium);
    }

    public List<Stadium> stadiumFindAll() {
        return stadiumRepository.findAll();
    }
}

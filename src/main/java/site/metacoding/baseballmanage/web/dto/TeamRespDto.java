package site.metacoding.baseballmanage.web.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import site.metacoding.baseballmanage.domain.stadium.Stadium;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TeamRespDto {
    private BigDecimal id;
    private BigDecimal no;
    private BigDecimal stadiumId;
    private String name;
    private String createDate;

    // private StadiumDto stadiumDto;

    public class StadiumDto {
        private BigDecimal id;
        private String name;
    }
}

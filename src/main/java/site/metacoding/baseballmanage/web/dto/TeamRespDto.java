package site.metacoding.baseballmanage.web.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class TeamRespDto {
    private BigDecimal no;
    private BigDecimal id;
    private String stadium;
    private String name;
    private String createDate;
}

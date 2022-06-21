package site.metacoding.baseballmanage.web.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PlayerRespDto {
    private BigDecimal no;
    private BigDecimal id;
    private String team;
    private String position;
    private String name;
    private String createDate;

}
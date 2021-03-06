package site.metacoding.baseballmanage.web.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class StadiumRespDto {
    private BigDecimal id;
    private BigDecimal no;
    private String name;
    private String createDate;
}

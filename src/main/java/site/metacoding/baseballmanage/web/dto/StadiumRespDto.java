package site.metacoding.baseballmanage.web.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StadiumRespDto {
    private BigDecimal id;
    private BigDecimal no;
    private String name;
    private String createDate;
}

package site.metacoding.baseballmanage.web.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class PlayerSaveReqDto {
    private Integer teamId;
    private String position;
    private String name;
}

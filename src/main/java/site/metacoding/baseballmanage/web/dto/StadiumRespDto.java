package site.metacoding.baseballmanage.web.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StadiumRespDto {
    private BigDecimal no;
    private String name;
    private Timestamp createDate;

    public LocalDateTime getFormatCreateDate() {

        String timestampAsString = createDate.toString();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        return LocalDateTime.from(formatter.parse(timestampAsString));
    }
}

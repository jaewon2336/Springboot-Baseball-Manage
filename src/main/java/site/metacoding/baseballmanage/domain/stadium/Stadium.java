package site.metacoding.baseballmanage.domain.stadium;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import site.metacoding.baseballmanage.domain.team.Team;

@NoArgsConstructor
@Data
@EntityListeners(AuditingEntityListener.class)
@Entity
public class Stadium {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STADIUM_SEQUENCE_GENERATOR")
    @SequenceGenerator(name = "STADIUM_SEQUENCE_GENERATOR", sequenceName = "STADIUM_SEQUENCE", initialValue = 1, allocationSize = 1)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String name;

    @JsonIgnoreProperties({ "stadium" })
    @OneToOne(mappedBy = "stadium")
    private Team team;

    @CreatedDate
    private LocalDateTime createDate;
    @LastModifiedDate
    private LocalDateTime updateDate;

    @Transient
    private String no;

    @Builder
    public Stadium(Integer id, String name, LocalDateTime createDate,
            LocalDateTime updateDate) {
        this.id = id;
        this.name = name;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public String getFormatCreateDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return createDate.format(formatter);
    }

}

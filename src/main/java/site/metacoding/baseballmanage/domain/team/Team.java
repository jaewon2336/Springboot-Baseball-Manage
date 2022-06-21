package site.metacoding.baseballmanage.domain.team;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import site.metacoding.baseballmanage.domain.stadium.Stadium;

@NoArgsConstructor
@Data
@EntityListeners(AuditingEntityListener.class)
@Entity
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TEAM_SEQUENCE_GENERATOR")
    @SequenceGenerator(name = "TEAM_SEQUENCE_GENERATOR", sequenceName = "TEAM_SEQUENCE", initialValue = 1, allocationSize = 1)
    private Integer id;

    @JoinColumn(name = "stadiumId")
    @OneToOne
    private Stadium stadium;

    @Column(nullable = false, unique = true)
    private String name;

    @CreatedDate
    private LocalDateTime createDate;
    @LastModifiedDate
    private LocalDateTime updateDate;

    @Builder
    public Team(Integer id, Stadium stadium, String name, LocalDateTime createDate, LocalDateTime updateDate) {
        this.id = id;
        this.stadium = stadium;
        this.name = name;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public String getFormatCreateDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return createDate.format(formatter);
    }
}

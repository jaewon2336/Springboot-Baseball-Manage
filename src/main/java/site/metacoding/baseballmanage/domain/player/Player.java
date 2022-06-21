package site.metacoding.baseballmanage.domain.player;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import site.metacoding.baseballmanage.domain.team.Team;

@NoArgsConstructor
@Data
@EntityListeners(AuditingEntityListener.class)
@Entity
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PLAYER_SEQUENCE_GENERATOR")
    @SequenceGenerator(name = "PLAYER_SEQUENCE_GENERATOR", sequenceName = "PLAYER_SEQUENCE", initialValue = 1, allocationSize = 1)
    private Integer id;

    @JoinColumn(name = "teamId")
    @ManyToOne
    private Team team;

    @Column(nullable = false)
    private String position;

    @Column(nullable = false)
    private String name;

    @CreatedDate
    private LocalDateTime createDate;
    @LastModifiedDate
    private LocalDateTime updateDate;

    @Builder
    public Player(Integer id, Team team, String position, String name, LocalDateTime createDate,
            LocalDateTime updateDate) {
        this.id = id;
        this.team = team;
        this.position = position;
        this.name = name;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public String getFormatCreateDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return createDate.format(formatter);
    }
}

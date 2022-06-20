package site.metacoding.baseballmanage.domain.team;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TeamRepository extends JpaRepository<Team, Integer> {

    @Query(value = "SELECT * FROM team WHERE stadiumId = :stadiumId", nativeQuery = true)
    Optional<Team> findByStadiumId(@Param("stadiumId") Integer stadiumId);
}

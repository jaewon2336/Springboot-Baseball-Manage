package site.metacoding.baseballmanage.domain.stadium;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StadiumRepository extends JpaRepository<Stadium, Integer> {

    @Query(value = "SELECT * FROM stadium WHERE name = :name", nativeQuery = true)
    Optional<Stadium> findByName(@Param("name") String name);
}

package fr.epsi.b3devc1.bestioles.repository;

import fr.epsi.b3devc1.bestioles.model.Animal;
import fr.epsi.b3devc1.bestioles.model.Species;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {

    List<Animal> findAllBySpecies(Species species);

    List<Animal> findAllByColorIn(List<String> colors);

    @Query("SELECT a FROM Animal a WHERE a.sex = :sex")
    Integer countBySex(@Param("sex") String sex);

    @Query("SELECT COUNT(p) > 0 FROM Person p JOIN p.animals a WHERE a.id = :animalId")
    boolean existsByPerson(@Param("animalId") Long animalId);
}

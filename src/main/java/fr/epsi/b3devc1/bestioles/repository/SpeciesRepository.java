package fr.epsi.b3devc1.bestioles.repository;

import fr.epsi.b3devc1.bestioles.model.Species;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpeciesRepository extends JpaRepository<Species, Long> {

    Species findFirstByCommonName(String commonName);

    List<Species> findAllByLatinNameContainingIgnoreCase(String latinName);

    @Query("SELECT s FROM Species s ORDER BY s.commonName ASC")
    List<Species> findAllByOrderByCommonNameAsc();

    @Query("SELECT s FROM Species s WHERE s.commonName LIKE :commonName")
    List<Species> findAllByCommonNameLike(@Param("commonName") String commonName);

}

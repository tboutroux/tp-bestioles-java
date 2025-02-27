package fr.epsi.b3devc1.bestioles.repository;

import fr.epsi.b3devc1.bestioles.model.Species;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpeciesRepository extends JpaRepository<Species, Long> {

    Species findFirstByCommonName(String commonName);

    List<Species> findAllByLatinNameContainingIgnoreCase(String latinName);

}

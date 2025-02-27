package fr.epsi.b3devc1.bestioles.repository;

import fr.epsi.b3devc1.bestioles.model.Animal;
import fr.epsi.b3devc1.bestioles.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    List<Person> findByLastnameOrFirstname(String lastname, String firstname);

    List<Person> findAllByAgeGreaterThanEqual(int age);

    @Query("SELECT p FROM Person p WHERE p.age BETWEEN :ageBefore AND :ageAfter")
    List<Person> findAllByAgeBetween(@Param("ageBefore") Integer ageBefore, @Param("ageAfter") Integer ageAfter);

    @Query("SELECT p FROM Person p JOIN p.animals a WHERE a IN :animals")
    List<Person> findAllByAnimals(@Param("animals") List<Animal> animals);

}

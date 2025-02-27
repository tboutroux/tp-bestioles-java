package fr.epsi.b3devc1.bestioles;

import fr.epsi.b3devc1.bestioles.model.Animal;
import fr.epsi.b3devc1.bestioles.model.Person;
import fr.epsi.b3devc1.bestioles.model.Species;
import fr.epsi.b3devc1.bestioles.repository.AnimalRepository;
import fr.epsi.b3devc1.bestioles.repository.PersonRepository;
import fr.epsi.b3devc1.bestioles.repository.SpeciesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@SpringBootApplication
public class BestiolesApplication implements CommandLineRunner {

    @Autowired
    private SpeciesRepository speciesRepository;

    public static void main(String[] args) {
        SpringApplication.run(BestiolesApplication.class, args);
    }

    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private PersonRepository personRepository;

    @Override
    public void run(String... args) throws Exception {

//        System.out.println(animalRepository.findAll());
//
//        // Création de plusieurs items
//        Person personne1 = new Person(45, "Jean", "Dupont", "jdupont", "****", true);
//        Person personne2 = new Person(33, "Marie", "Durand", "mdurand", "****", true);
//
//        List<Animal> animals = animalRepository.findAll();
//
//        personne2.setAnimals(Set.of(animals.get(0), animals.get(1)));
//
//        personRepository.save(personne1);
//        personRepository.save(personne2);
//
//        // Rechercher une entité par son identifiant
//        Person personne = personRepository.findById(1L).get();
//        System.out.println(personne);
//
//        // Supprimer une entité avec delete, et afficher la longueur de la liste de toutes les entités pour vérifier qu’elle a bien été supprimée
//        personRepository.delete(personne);
//        System.out.println(personRepository.findAll().size());

        // TP4
        Species specieResult = speciesRepository.findFirstByCommonName("Chien");
        System.out.println(specieResult);

        List<String> colors = List.of("Noir", "Blanc");
        List<Animal> animals = animalRepository.findAllByColorIn(colors);
        System.out.println(animals);

        List<Person> result = personRepository.findByLastnameOrFirstname("Vintroi", "Jean");
        System.out.println(result);

        // TP5


    }

}

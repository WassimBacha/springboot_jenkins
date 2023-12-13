package tn.itbs.gestiontache.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.itbs.gestiontache.entities.Projet;

public interface ProjetRepo extends JpaRepository<Projet, Integer> {
}

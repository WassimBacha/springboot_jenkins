package tn.itbs.gestiontache.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.itbs.gestiontache.entities.Tache;

public interface TacheRepo extends JpaRepository<Tache, Integer> {
}

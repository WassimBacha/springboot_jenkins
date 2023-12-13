package tn.itbs.gestiontache.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.itbs.gestiontache.entities.Utulisateur;

public interface UtulisateurRepo extends JpaRepository<Utulisateur, Integer> {
}

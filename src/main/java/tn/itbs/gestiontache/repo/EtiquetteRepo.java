package tn.itbs.gestiontache.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.itbs.gestiontache.entities.Etiquette;

public interface EtiquetteRepo extends JpaRepository<Etiquette, Integer> {
}

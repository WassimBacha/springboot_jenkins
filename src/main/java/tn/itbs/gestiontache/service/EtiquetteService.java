package tn.itbs.gestiontache.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import tn.itbs.gestiontache.entities.Etiquette;
import tn.itbs.gestiontache.repo.EtiquetteRepo;

import java.util.List;
import java.util.Optional;

@Service
public class EtiquetteService {

    @Autowired
    private EtiquetteRepo etiquetteRepo;

    public ResponseEntity<Object> addEtiquette(Etiquette etiquette) {
        etiquetteRepo.findById(etiquette.getId())
                .ifPresentOrElse(p -> {
                            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Etiquette existe deja");
                        },
                        () -> {
                            etiquetteRepo.save(etiquette);
                        });

        return ResponseEntity.ok().body("ajout avec succe");
    }

    public ResponseEntity<Object> updateEtiquette(int id, Etiquette etiquette) {
        etiquetteRepo.findById(id)
                .ifPresentOrElse(
                        p -> {
                            etiquette.setId(id);
                            etiquetteRepo.save(etiquette);

                        },
                        () -> {
                            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Etiquette n'existe pas");

                        });

        return ResponseEntity.ok().body("Etiquette modifié avec succe");
    }

    public ResponseEntity<Object> deleteEtiquette(int id) {
        etiquetteRepo.findById(id)
                .ifPresentOrElse(
                        p -> {
                            etiquetteRepo.deleteById(id);
                        },
                        () -> {
                            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Etiquette n'existe pas");
                        });

        return ResponseEntity.ok().body("Etiquette supprimé avec succe");
    }

    public Optional<Etiquette> getEtiquetteById(int id) {
        return etiquetteRepo.findById(id);
    }

    public List<Etiquette> getAllEtiquetts() {
        return (List<Etiquette>) etiquetteRepo.findAll();
    }




}

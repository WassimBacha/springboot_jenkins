package tn.itbs.gestiontache.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import tn.itbs.gestiontache.entities.Projet;
import tn.itbs.gestiontache.repo.ProjetRepo;

import java.util.List;
import java.util.Optional;

@Service
public class ProjetService {

    @Autowired
    private ProjetRepo projetRepo;

    public ResponseEntity<Object> addProject(Projet projet) {
        projetRepo.findById(projet.getId())
                .ifPresentOrElse(p -> {
                            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Projet existe deja");
                        },
                        () -> {
                            projetRepo.save(projet);
                        });

        return ResponseEntity.ok().body("ajout avec succe");
    }
    public Optional<Projet> getProjectById(int id) {
        return projetRepo.findById(id);
    }

    public List<Projet> getAllProjects() {
        return (List<Projet>) projetRepo.findAll();
    }

    public ResponseEntity<Object> updateProject(int id, Projet project) {
        projetRepo.findById(id)
                .ifPresentOrElse(
                        p -> {
                            project.setId(id);
                            projetRepo.save(project);
                        },
                        () -> {
                            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Projet n'existe pas");
                        });

        return ResponseEntity.ok().body("projet modifié avec succe");
    }
    public ResponseEntity<Object> deleteProject(int id) {
        projetRepo.findById(id)
                .ifPresentOrElse(
                        p -> {
                            projetRepo.deleteById(id);
                        },
                        () -> {
                            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "projet n'existe pas");
                        });

        return ResponseEntity.ok().body("projet supprimé avec succe");
    }

}

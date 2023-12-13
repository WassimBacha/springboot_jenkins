package tn.itbs.gestiontache.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import tn.itbs.gestiontache.entities.Projet;
import tn.itbs.gestiontache.entities.Tache;
import tn.itbs.gestiontache.repo.TacheRepo;

import java.util.List;
import java.util.Optional;

@Service
public class TacheService {

    @Autowired
    private TacheRepo tacheRepo;

    public ResponseEntity<Object> addTache(Tache tache) {
        tacheRepo.findById(tache.getId())
                .ifPresentOrElse(p -> {
                            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tache existe deja");
                        },
                        () -> {
                            tacheRepo.save(tache);
                        });

        return ResponseEntity.ok().body("ajout avec succe");
    }
    public Optional<Tache> getTacheById(int id){
        return tacheRepo.findById(id);
    }

    public List<Tache> getAllTaches(){
        return (List<Tache>) tacheRepo.findAll();
    }

    public ResponseEntity<Object> updateTache(int id, Tache tache){
        tacheRepo.findById(id)
                .ifPresentOrElse(
                        p -> {
                            tache.setId(id);
                            tacheRepo.save(tache);

                        },
                        () -> {
                            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tache n'existe pas");
                        });

        return ResponseEntity.ok().body("tache Modifier avec succe");

    }
    public ResponseEntity<Object> deletetache(int id) {
        tacheRepo.findById(id)
                .ifPresentOrElse(
                        p -> {
                            tacheRepo.deleteById(id);
                        },
                        () -> {
                            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "tache n'existe pas");
                        });

        return ResponseEntity.ok().body("tache supprimé avec succe");
    }

    @Transactional
    public ResponseEntity<String> updateStatus(int id ,Tache tache ){
        tacheRepo.findById(id).ifPresentOrElse(
                x-> {

                    x.setStatut(tache.getStatut());

                },
                ()-> {throw  new ResponseStatusException(HttpStatus.NOT_FOUND , "tache n'existe pas");}
        );
        return ResponseEntity.ok("Status Modifier avec succe");
    }

    public Projet findProjectByTaskId(int taskId) {
        // First, you need to find the task by its ID
        Optional<Tache> task = tacheRepo.findById(taskId);

        if (task.isPresent()) {
            // If the task is found, retrieve the associated project
            return task.get().getProjet();
        } else {
            return null; // Or handle the case when the task is not found
        }
    }




}

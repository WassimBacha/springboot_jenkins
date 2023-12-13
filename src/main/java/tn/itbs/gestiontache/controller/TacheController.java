package tn.itbs.gestiontache.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import tn.itbs.gestiontache.entities.Tache;
import tn.itbs.gestiontache.service.TacheService;

import java.util.List;
import java.util.Optional;

@RequestMapping("/taches")


@RestController
public class TacheController {

    @Autowired
    private TacheService tacheService;

    @PostMapping("/addtache")
    public ResponseEntity<Object> addTache(@RequestBody Tache tache) {
        return tacheService.addTache(tache);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tache> getTacheById(@PathVariable int id) {
        Optional<Tache> tache = tacheService.getTacheById(id);
        if (tache.isPresent()) {
            return ResponseEntity.ok(tache.get());
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tache n'existe pas");
        }

    }
    @GetMapping
    public ResponseEntity<List<Tache>> getAllTaches() {
        List<Tache> tache = tacheService.getAllTaches();
        return ResponseEntity.ok(tache);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateTache(@PathVariable int id, @RequestBody Tache tache) {
        return tacheService.updateTache(id, tache);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletetache(@PathVariable int id) {
        return tacheService.deletetache(id);
    }

    @PutMapping("/updateStatus/{id}")
    public ResponseEntity<String> updateTacheStatus(@PathVariable int id, @RequestBody Tache tache) {
        return tacheService.updateStatus(id, tache);
    }








}

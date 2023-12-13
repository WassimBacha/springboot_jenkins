package tn.itbs.gestiontache.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import tn.itbs.gestiontache.entities.Etiquette;
import tn.itbs.gestiontache.service.EtiquetteService;

import java.util.List;
import java.util.Optional;

@RequestMapping("/Etiquette")
@RestController
public class EtiquetteController {

    @Autowired
    private EtiquetteService etiquetteService;



    @PostMapping("/addEtiquette")
    public ResponseEntity<Object> addEtiquette(@RequestBody Etiquette etiquette) {
        return etiquetteService.addEtiquette(etiquette);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateEtiquette(@PathVariable int id, @RequestBody Etiquette etiquette) {
        return etiquetteService.updateEtiquette(id, etiquette);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteEtiquette(@PathVariable int id) {
        return etiquetteService.deleteEtiquette(id);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Etiquette> getEtiquetteById(@PathVariable int id) {
        Optional<Etiquette> etiquette = etiquetteService.getEtiquetteById(id);
        if (etiquette.isPresent()) {
            return ResponseEntity.ok(etiquette.get());
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Etiquette n'existe pas");
        }

    }
    @GetMapping
    public ResponseEntity<List<Etiquette>> getAllEtiquetts() {
        List<Etiquette> etiquettes = etiquetteService.getAllEtiquetts();
        return ResponseEntity.ok(etiquettes);
    }


}

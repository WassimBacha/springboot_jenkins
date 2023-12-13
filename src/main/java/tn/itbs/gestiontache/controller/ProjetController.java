package tn.itbs.gestiontache.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import tn.itbs.gestiontache.entities.Projet;
import tn.itbs.gestiontache.service.ProjetService;

import java.util.List;
import java.util.Optional;

@RequestMapping("/projet")
@RestController
public class ProjetController

{
    @Autowired
    private ProjetService projetService;

    @PostMapping("/addProject")
    public ResponseEntity<Object> addProject(@RequestBody Projet project) {
        return projetService.addProject(project);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Projet> getProjectById(@PathVariable int id) {
        Optional<Projet> project = projetService.getProjectById(id);
        if (project.isPresent()) {
            return ResponseEntity.ok(project.get());
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Projet n'existe pas");
        }

    }
    @GetMapping
    public ResponseEntity<List<Projet>> getAllProjects() {
        List<Projet> projects = projetService.getAllProjects();
        return ResponseEntity.ok(projects);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateProject(@PathVariable int id, @RequestBody Projet project) {
        return projetService.updateProject(id, project);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteProject(@PathVariable int id) {
        return projetService.deleteProject(id);
    }

}

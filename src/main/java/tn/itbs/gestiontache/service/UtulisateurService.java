package tn.itbs.gestiontache.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import tn.itbs.gestiontache.entities.Utulisateur;
import tn.itbs.gestiontache.repo.UtulisateurRepo;

@Service
public class UtulisateurService {

    @Autowired
    private UtulisateurRepo UserRepo ;
    public ResponseEntity<?> addUser(Utulisateur user){
        UserRepo.findById(user.getId())
                .ifPresentOrElse(u ->{throw new ResponseStatusException(HttpStatus.NOT_FOUND,"utulisateur existe deja"); },
                        ()->{UserRepo.save(user);});


        return ResponseEntity.ok().body("ajout avec succe");
    }
}
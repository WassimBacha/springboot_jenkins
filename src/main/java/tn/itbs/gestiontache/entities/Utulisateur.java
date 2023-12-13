package tn.itbs.gestiontache.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Utulisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id ;
    private String  nom ;
    private String prenom ;
    private String login ;
    private String MDP ;
    private String email ;







}

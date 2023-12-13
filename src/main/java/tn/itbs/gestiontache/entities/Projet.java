package tn.itbs.gestiontache.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
public class Projet {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private String nomprojet;
    private String description;
    private Date DateDebut;
    private Date DateFin;


    @ManyToOne
    @JoinColumn(name = "Utulisateur_id")
    private Utulisateur Utulisateur;



   



}

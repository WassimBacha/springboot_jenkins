package tn.itbs.gestiontache.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
public class Tache {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String titre;
    private String description;
    private Date dateEcheance;

    @Enumerated(EnumType.STRING)
    private StatutTache statut;

    @ManyToOne
    @JoinColumn(name = "projet_id")
    private Projet Projet;



    public enum StatutTache {
        EnAttente,
        EnCours,
        Terminée
    }


}


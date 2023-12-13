package tn.itbs.gestiontache.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Etiquette {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String libelle;






}

package com.gestion.filmotheque.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "film")
@Entity
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String titre;
    private String description;
    private String anneeparution;
    @ManyToOne
    private Categorie categorie;
    
    
    
    @Override
    public String toString() {
        return "Film{id=" + id + ", titre='" + titre + "', description='" + description + "', anneeparution='" + anneeparution + "', categorie=" + (categorie != null ? categorie.getNom() : "null") + "}";
    }
}


package com.gestion.filmotheque.controller;

import com.gestion.filmotheque.entities.Categorie;
import com.gestion.filmotheque.service.ServiceCategorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categories")
public class CategorieController {

    @Autowired
    private ServiceCategorie serviceCategorie;

    // Route pour ajouter une catégorie
    @PostMapping("/ajouter")
    public ResponseEntity<Categorie> addCategorie(@RequestBody Categorie categorie) {
        Categorie createdCategorie = serviceCategorie.createCategorie(categorie);
        return new ResponseEntity<>(createdCategorie, HttpStatus.CREATED);
    }
}

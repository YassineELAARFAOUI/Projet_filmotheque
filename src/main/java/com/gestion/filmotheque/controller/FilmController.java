package com.gestion.filmotheque.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gestion.filmotheque.entities.Film;
import com.gestion.filmotheque.service.IServiceCategorie;
import com.gestion.filmotheque.service.IServiceFilm;


@Controller
@RequestMapping("/film/")
public class FilmController {
    @Autowired
    private IServiceFilm iServiceFilm;
    @Autowired
    private IServiceCategorie iServiceCategorie;

    @GetMapping("all")
    public String listeFilms(Model model) {
        model.addAttribute("films", iServiceFilm.findAllFilms());
        return "affiche"; // the view name to render
    }
    @GetMapping("new")
    public String afficheNewForm(Model model) {
        model.addAttribute("categories", iServiceCategorie.findAllCategories());
        return "ajout";
    }
    @PostMapping("add")
    public String add(Film f) {
        iServiceFilm.createFilm(f);
        return "redirect:/film/all";
    }
    @GetMapping("delete/{id}")
    public String delete(@PathVariable int id) {
        iServiceFilm.deleteFilm(id);
        return "redirect:/film/all";
    }
    @GetMapping("edit/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        Film film = iServiceFilm.findFilmById(id);  // Cette méthode doit être définie dans le service
        if (film != null) {
            model.addAttribute("film", film);
            model.addAttribute("categories", iServiceCategorie.findAllCategories());  // Charger les catégories pour l'édition
            return "modifier";  // Retourne à la vue modifier.html
        } else {
            return "redirect:/film/all";  // Si le film n'est pas trouvé, on redirige vers la liste
        }
    }
    @PostMapping("update")
    public String updateFilm(Film film) {
        iServiceFilm.updateFilm(film);  // Cette méthode doit être définie dans le service
        return "redirect:/film/all";  // Rediriger vers la liste des films après la mise à jour
    }

}

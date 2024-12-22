package com.gestion.filmotheque.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.filmotheque.entities.Film;
import com.gestion.filmotheque.repository.FilmRepository;
@Service
public class ServiceFilm implements IServiceFilm {
	@Autowired
    FilmRepository filmRepository;
    
    @Override
    public Film createFilm(Film f) {
        return filmRepository.save(f);
    }
    
    @Override
    public Film findFilmById(int id) {
        return filmRepository.findById(id).get();
    }
    
    @Override
    public List<Film> findAllFilms() {
        return filmRepository.findAll();
    }
    
    @Override
    public Film updateFilm(Film f) {
        return filmRepository.save(f);
    }
    
    @Override
    public void deleteFilm(int id) {
        filmRepository.deleteById(id);
    }
}

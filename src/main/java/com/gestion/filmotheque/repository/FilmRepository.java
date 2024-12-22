package com.gestion.filmotheque.repository;

import com.gestion.filmotheque.entities.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Film, Integer> {
}

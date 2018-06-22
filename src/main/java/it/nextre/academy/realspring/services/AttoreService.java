package it.nextre.academy.realspring.services;

import it.nextre.academy.realspring.entities.Attore;
import it.nextre.academy.realspring.entities.Disco;
import it.nextre.academy.realspring.entities.Film;

import java.util.List;

public interface AttoreService {
    List<Attore> getAll();
    Attore findById(long id);
    Attore add(Attore a) throws Exception;
    Attore save(Attore a) throws Exception;
    boolean delete(Attore a) throws Exception;
    List<Attore> findByFilm(Film f);
}

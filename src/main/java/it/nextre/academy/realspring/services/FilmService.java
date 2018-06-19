package it.nextre.academy.realspring.services;

import it.nextre.academy.realspring.entities.Film;

import java.util.List;

public interface FilmService {

    public List<Film> getAll();
    public Film findById(long id);
    public List<Film> findByTitolo(String titolo);
    public List<Film> findByRegista(String regista);
    public List<Film> findByAnno(int anno);
    public Film add(Film f) throws Exception;
    public Film save(Film f) throws Exception;
    public boolean delete(Film f) throws Exception;

}

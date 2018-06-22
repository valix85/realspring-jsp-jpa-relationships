package it.nextre.academy.realspring.services;

import it.nextre.academy.realspring.entities.Coupon;
import it.nextre.academy.realspring.entities.Disco;
import it.nextre.academy.realspring.entities.Film;

import java.util.List;

public interface DiscoService {
    List<Disco> getAll();
    Disco findById(long id);
    Disco add(Disco c) throws Exception;
    Disco save(Disco c) throws Exception;
    boolean delete(Disco c) throws Exception;
    List<Disco> findByFilm(Film f);
}

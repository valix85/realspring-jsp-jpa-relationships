package it.nextre.academy.realspring.services.impl;


import it.nextre.academy.realspring.entities.Coupon;
import it.nextre.academy.realspring.entities.Disco;
import it.nextre.academy.realspring.entities.Film;
import it.nextre.academy.realspring.repositories.DiscoRepository;
import it.nextre.academy.realspring.services.DiscoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscoServiceImpl implements DiscoService {

    @Autowired
    DiscoRepository discoRepository;


    @Override
    public List<Disco> getAll() {
        return discoRepository.findAll();
    }

    @Override
    public Disco findById(long id) {
        return discoRepository.findOne(id);
    }

    @Override
    public Disco add(Disco c) throws Exception {
        return discoRepository.save(c);
    }

    @Override
    public Disco save(Disco c) throws Exception {
        return discoRepository.save(c);
    }

    @Override
    public boolean delete(Disco c) throws Exception {
        //TODO fare metodo
        return false;
    }

    @Override
    public List<Disco> findByFilm(Film f) {
        return discoRepository.findByFilm(f);
    }
}//end class

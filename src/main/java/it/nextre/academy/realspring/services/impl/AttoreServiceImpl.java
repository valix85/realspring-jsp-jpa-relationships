package it.nextre.academy.realspring.services.impl;



import it.nextre.academy.realspring.entities.Attore;
import it.nextre.academy.realspring.entities.Disco;
import it.nextre.academy.realspring.entities.Film;
import it.nextre.academy.realspring.repositories.AttoreRepository;
import it.nextre.academy.realspring.services.AttoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttoreServiceImpl implements AttoreService {

    @Autowired
    AttoreRepository attoreRepository;


    @Override
    public List<Attore> getAll() {
        return attoreRepository.findAll();
    }

    @Override
    public Attore findById(long id) {
        return attoreRepository.findOne(id);
    }

    @Override
    public Attore add(Attore c) throws Exception {
        return attoreRepository.save(c);
    }

    @Override
    public Attore save(Attore c) throws Exception {
        return attoreRepository.save(c);
    }

    @Override
    public boolean delete(Attore c) throws Exception {
        //TODO fare metodo
        return false;
    }

    @Override
    public List<Attore> findByFilm(Film f) {
        //TODO fare metodo
        return null;
    }
}//end class

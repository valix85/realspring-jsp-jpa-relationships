package it.nextre.academy.realspring.repositories;

import it.nextre.academy.realspring.entities.Disco;
import it.nextre.academy.realspring.entities.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface DiscoRepository extends JpaRepository<Disco, Long> {

    List<Disco> findByFilm(Film f);
}

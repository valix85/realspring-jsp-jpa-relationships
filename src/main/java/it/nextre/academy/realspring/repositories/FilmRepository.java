package it.nextre.academy.realspring.repositories;

import it.nextre.academy.realspring.entities.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface FilmRepository extends JpaRepository<Film, Long> {
    List<Film> findAllByTitoloLikeOrderByTitoloAsc(String titolo);
    List<Film> findAllByTitoloContains(String titolo);
    List<Film> findAllByRegistaContains(String regista);
    List<Film> findAllByAnno(int anno);

    @Query(value="select * from film order by RAND() LIMIT 0,1", nativeQuery = true)
    Film getOneRandom();

}//end class

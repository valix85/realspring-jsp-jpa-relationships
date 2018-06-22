package it.nextre.academy.realspring.repositories;

import it.nextre.academy.realspring.entities.Attore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface AttoreRepository extends JpaRepository<Attore, Long> {
}

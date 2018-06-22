package it.nextre.academy.realspring.repositories;

import it.nextre.academy.realspring.entities.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface CouponRepository extends JpaRepository<Coupon, Long> {
}

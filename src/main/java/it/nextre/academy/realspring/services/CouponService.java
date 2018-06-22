package it.nextre.academy.realspring.services;

import it.nextre.academy.realspring.entities.Coupon;
import it.nextre.academy.realspring.entities.Film;

import java.util.List;

public interface CouponService {

    public List<Coupon> getAll();
    public Coupon findById(long id);
    public Coupon add(Coupon c) throws Exception;
    public Coupon save(Coupon c) throws Exception;
    public boolean delete(Coupon c) throws Exception;
}

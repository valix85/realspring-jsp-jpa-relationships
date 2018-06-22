package it.nextre.academy.realspring.services.impl;

import it.nextre.academy.realspring.entities.Coupon;
import it.nextre.academy.realspring.repositories.CouponRepository;
import it.nextre.academy.realspring.services.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CouponServiceImpl implements CouponService {

    @Autowired
    CouponRepository couponRepository;


    @Override
    public List<Coupon> getAll() {
        return couponRepository.findAll();
    }

    @Override
    public Coupon findById(long id) {
        return couponRepository.findOne(id);
    }

    @Override
    public Coupon add(Coupon c) throws Exception {
        return couponRepository.save(c);
    }

    @Override
    public Coupon save(Coupon c) throws Exception {
        return couponRepository.save(c);
    }

    @Override
    public boolean delete(Coupon c) throws Exception {
        //TODO fare metodo
        return false;
    }
}//end class

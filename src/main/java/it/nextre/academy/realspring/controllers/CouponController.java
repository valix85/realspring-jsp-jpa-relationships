package it.nextre.academy.realspring.controllers;

import it.nextre.academy.realspring.entities.Coupon;
import it.nextre.academy.realspring.entities.Film;
import it.nextre.academy.realspring.services.CouponService;
import it.nextre.academy.realspring.services.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/coupon")
public class CouponController {

    @Autowired
    CouponService couponService;

    @Autowired
    @Qualifier("implfilm")
    FilmService filmService;


    @GetMapping("/")
    public String allCoupon(Model m, @ModelAttribute("mex") final String mex){
        m.addAttribute("coupons", couponService.getAll());
        m.addAttribute("mex", mex);
        return "coupons";
    }


    @GetMapping("/new")
    public String newCoupon(Model m){
        m.addAttribute("films", filmService.getFilmWithoutCoupon());
        return "newCoupon";
    }


    @PostMapping("/saveCoupon")
    public String newCoupon(Model m, Coupon c, final RedirectAttributes redirectAttrs){
        System.out.println("saveCoupon" + c);
        System.out.println("saveCoupon" + c.getFilm());
        if (c!=null){
            try {
                couponService.save(c);
                Film f = filmService.findById(c.getFilm().getId());f.setCoupon(c);
                filmService.save(f);
                redirectAttrs.addFlashAttribute("mex", "Coupon inserito con successo (2)");
                return "redirect:/coupon/";
            } catch (Exception e) {
                //log.error("Coupon non valido");
                m.addAttribute("mex", e.getMessage());
            }
        }

        m.addAttribute("films", filmService.getFilmWithoutCoupon());
        return "/newCoupon";

    }

}//end class

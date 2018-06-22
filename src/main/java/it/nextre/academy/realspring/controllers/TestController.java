package it.nextre.academy.realspring.controllers;

import it.nextre.academy.realspring.controllers.api.FilmController;
import it.nextre.academy.realspring.entities.Attore;
import it.nextre.academy.realspring.entities.Coupon;
import it.nextre.academy.realspring.entities.Disco;
import it.nextre.academy.realspring.entities.Film;
import it.nextre.academy.realspring.services.AttoreService;
import it.nextre.academy.realspring.services.CouponService;
import it.nextre.academy.realspring.services.DiscoService;
import it.nextre.academy.realspring.services.FilmService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Controller
public class TestController {

    //Dichiarazione del logger
    Logger log = Logger.getLogger(FilmController.class);

    @Autowired
    @Qualifier("implfilm")
    FilmService filmService;

    @Autowired
    CouponService couponService;

    @Autowired
    DiscoService discoService;

    @Autowired
    AttoreService attoreService;

    Random r = new Random();



    @GetMapping("/121")
    public String oneToOne(Model m) {
        log.info("oneToOne Method called");
        Coupon c1 = new Coupon();
        c1.setCode("COD"+(1+r.nextInt(100)) );
        c1.setSold(new BigDecimal("2.43"));

        Film f1 = new Film();
        f1.setTitolo("F"+(10000+r.nextInt(99999)));
        f1.setRegista("Mago Merlino");
        f1.setPrezzo(new BigDecimal("18.99"));
        f1.setAnno(2018);


        try {
            c1=couponService.add(c1);
            f1.setCoupon(c1);
            log.info(f1);
            f1=filmService.add(f1);
        } catch (Exception e) {
            //e.printStackTrace();
            log.error(e.getMessage()+"\nfor film " + f1);
        }

        m.addAttribute("film", f1);
        m.addAttribute("coupon", c1);
        return "demo1";
    }






    @GetMapping("/121/{couponId}")
    public String oneToOneRead(Model m, @PathVariable("couponId") long cid) {
        log.info("oneToOneRead Method called");
        m.addAttribute("film",couponService.findById(cid).getFilm());
        m.addAttribute("coupon",couponService.findById(cid));
        return "demo1";
    }


    @GetMapping("/12m")
    public String oneToMany(Model m){
        log.info("oneToMany Method called");

        Disco d1 = new Disco();
        Disco d2 = new Disco();

        d1.setBarcode(""+(1000+r.nextInt(9999))+(1000+r.nextInt(9999)) );
        d2.setBarcode(""+(1000+r.nextInt(9999))+(1000+r.nextInt(9999)) );


        d1.setFilm(filmService.findById(2));
        d2.setFilm(filmService.findById(2));


        try {
            d1=discoService.add(d1);
            log.info("Disco salvato con ID: " + d1.getId());
            d2=discoService.add(d2);
            log.info("Disco salvato con ID: " + d2.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<Disco> dischi = new ArrayList<Disco>();
        dischi.add(d1);
        dischi.add(d2);

        m.addAttribute("dischi", dischi);
        m.addAttribute("film", filmService.findById(2));

        return "demo2";
    }


    @GetMapping("/12m/{filmId}")
    public String oneToMayRead(Model m, @PathVariable("filmId") long fid) {
        log.info("oneToMayRead Method called");
        m.addAttribute("film",filmService.findById(fid));
        m.addAttribute("dischi",discoService.findByFilm( filmService.findById(fid) ));
        return "demo2";
    }








    @GetMapping("/m2m")
    public String manyToMany(Model m) {
        log.info("manyToMany Method called");

        Attore tmp = new Attore();
        tmp.setNome("Mario " + r.nextInt(100));
        tmp.setCognome("Rossi " + r.nextInt(100));
        tmp.setSesso("M");
        for(int i = 0; i<3; i++){
            if (!tmp.addFilm(filmService.getRandomFilm())){
                log.warn("Film duplicato rilevato");
                //i--; //LOOP quando non ho più film possibili
            }
        }


        try {
            tmp=attoreService.save(tmp);
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<Film> films = filmService.getAll();
        m.addAttribute("films", films);
        m.addAttribute("attore", tmp);
        return "demo3";
    }











    @GetMapping("/m2m/{actId}")
    public String manyToMayRead(Model m, @PathVariable("actId") long aid) {
        log.info("manyToMayRead Method called");
        m.addAttribute("films",attoreService.findById(aid).getFilms());
        m.addAttribute("attore",attoreService.findById(aid));
        return "demo3";
    }





}//end class

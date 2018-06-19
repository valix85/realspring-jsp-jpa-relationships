package it.nextre.academy.realspring.controllers;

import it.nextre.academy.realspring.entities.Film;
import it.nextre.academy.realspring.services.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class GenericController {

    @Autowired
    @Qualifier("implfilm")
    FilmService filmService;

    @GetMapping("/")
    public String doHomePage(Model m) {
        List<Film> films = filmService.getAll();
        m.addAttribute("elencofilm", films);
        return "index";
    }

    @GetMapping({"/home", "/index"})
    public String redirectToHome() {
        return "redirect:/";
    }
}//end class

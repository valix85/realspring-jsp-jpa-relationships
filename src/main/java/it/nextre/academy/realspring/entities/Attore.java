package it.nextre.academy.realspring.entities;


import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@ToString
@Table(name="attore")
public class Attore {
    @Id
    @GeneratedValue
    private long id;
    private String nome;
    private String cognome;
    private String sesso;

    @ManyToMany
    //tabella di mezzo
    //joinColumns identifica le colonne di questa entità che parteciperanno alla relazione, in questo caso solo l'id
    //inverseJoinColumns identifica le colonne della controparte che parteciperanno alla relazione.
    //@Joincolumn permette di ridefinere il nome della colonna sulla tabella di join
    @JoinTable(
            name="rel_attore_film",
            uniqueConstraints = @UniqueConstraint(columnNames = {"idattore","idfilm"}),
            joinColumns = @JoinColumn(name="idattore"),
            inverseJoinColumns = @JoinColumn(name="idfilm")
    )
    private List<Film> films;
    {
        films = new ArrayList<>();
    }

    private void setFilms(List<Film> films){}

    public boolean addFilm(Film f) {
        if (films.stream().filter(item->item.getId()==f.getId()).count() == 0) {
            return films.add(f);
        }
        return false;
    }
}//end class

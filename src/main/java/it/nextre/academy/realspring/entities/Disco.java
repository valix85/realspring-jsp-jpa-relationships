package it.nextre.academy.realspring.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Disco {

    @Id
    @GeneratedValue //di default è strategy AUTO
    private long id;

    @NotNull
    @Column(unique = true)
    private String barcode;

    //più dischi possono contenere lo stesso film
    @ManyToOne
    @JoinColumn(name="film_id")
    private Film film;


    @Override
    public String toString() {
        return "Disco{" +
                "id=" + id +
                ", barcode='" + barcode + '\'' +
                ", film=" + (film!=null?film.getId():"null") +
                '}';
    }
}//end class

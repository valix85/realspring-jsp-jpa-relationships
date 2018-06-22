package it.nextre.academy.realspring.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Entity
@Table(name="film")
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="idfilm")
    private long id;

    @NotNull(message="Titolo non valido")
    @Column(length = 255)
    @Size(min=3,max=255, message="Lunghezza Titolo non valida")
    private String titolo;

    private String regista;

    @Column(length = 4)
    @Min(message = "Anno troppo piccolo",value=1870)
    @Max(message = "Anno troppo grande", value=2300)
    private int anno;

    //end mock

    @NotNull
    @Digits(integer = 3, fraction = 2)
    @DecimalMin("0.00")
    private BigDecimal prezzo;

    @OneToOne
    @JoinColumn(name="coupon_id") //nome della colonna di join sulla tabella di questa classe
    private Coupon coupon;


    //inizializzazione delle liste obbligaoria perchè lombok nel costruttore di default non lo fa.

    //Un film può avere più supporti (dischi)
    @OneToMany(mappedBy="film") //mapped by va sempre sulla tabella REFERENZIATA
    private List<Disco> dischi;
    {
        dischi=new ArrayList<>();
    }

    @ManyToMany(mappedBy = "films")
    private List<Attore> cast;
    {
        cast=new ArrayList<>();
    }


    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", titolo='" + titolo + '\'' +
                ", regista='" + regista + '\'' +
                ", anno=" + anno +
                ", prezzo=" + prezzo +
                ", coupon=" + (coupon!=null?coupon.getId():"null") +
                ", dischi=" + dischi +
                ", attori=" + cast +
                '}';
    }
}//end class

package it.nextre.academy.realspring.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@ToString
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

}//end class

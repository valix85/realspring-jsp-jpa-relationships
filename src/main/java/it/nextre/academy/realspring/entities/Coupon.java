package it.nextre.academy.realspring.entities;

import lombok.*;


import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Table(name="coupon")
public class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private long id;

    @Column(unique = true)
    @NotNull
    @Size(min=4, max=16, message = "Codice non valido")
    private String code;

    @DecimalMin("0.01")
    @DecimalMax("100.00")
    @NotNull
    @Digits(integer = 3, fraction = 2)
    private BigDecimal sold;

    @OneToOne(mappedBy = "coupon")
    private Film film;

    @Override
    public String toString() {
        return "Coupon{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", sold=" + sold +
                ", film=" + ((film!=null)?film.getId():"null") +
                '}';
    }
}//end class

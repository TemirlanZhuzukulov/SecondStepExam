package org.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
public class Products {
    @Id
    @GeneratedValue(generator = "products_gen",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "products_gen",sequenceName = "products_seq",allocationSize = 1)
    private Long id;
    private String name;
    private  int price;
    @ManyToOne(cascade = CascadeType.ALL)
    private Shop shop;
}

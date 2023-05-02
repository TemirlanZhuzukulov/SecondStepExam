package org.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "shops")
@Getter
@Setter
@NoArgsConstructor
public class Shop {
    @Id
    @GeneratedValue(generator = "shop_gen",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "shop_gen",sequenceName = "shop_seq",allocationSize = 1)
    private  Long id;
    private  String name;
    private  String address;
    @OneToMany(mappedBy = "shop" ,cascade = CascadeType.ALL)
    private List<Products> productsList;

    public Shop(String name, String address) {
        this.name = name;
        this.address = address;

    }
}

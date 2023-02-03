package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.checkerframework.checker.units.qual.C;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private  String name;

    @Column
    private int price;

    @Column
    private  String image;

    @Column
    private String[] colors;

    @Column
    private  String company;

    @Column
    private  String description;

    @Column
    private  String category;

    @Column
    private  Boolean shipping;

    private
    @Column String[] images;

    @Column
    private int stock;

    @Column
    private Boolean featured;


    public Product(String name, int price, String image, String[] colors, String company, String description, String category, Boolean shipping, String[] images, int stock, Boolean featured) {
        this.name = name;
        this.price = price;
        this.image = image;
        this.colors = colors;
        this.company = company;
        this.description = description;
        this.category = category;
        this.shipping = shipping;
        this.images = images;
        this.stock = stock;
        this.featured = featured;
    }
}

package com.sniklz.pizzaservicerenewed.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "pizzas")
@Data
public class Pizza {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @ManyToMany
    private Set<Ingredient> ingredients;
    private BigDecimal cost;
}

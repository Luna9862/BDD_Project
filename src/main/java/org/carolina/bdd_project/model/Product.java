package org.carolina.bdd_project.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data // From Lombok to generate getters, setters, toString, etc.
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private Double price;
}

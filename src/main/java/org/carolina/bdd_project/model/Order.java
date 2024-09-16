package org.carolina.bdd_project.model;


import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
//@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders") // "order" is a reserved keyword in SQL
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String customerName;

    @ManyToMany
    @JoinTable(
            name = "order_products",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> products;
}

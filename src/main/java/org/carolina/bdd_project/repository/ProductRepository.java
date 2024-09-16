package org.carolina.bdd_project.repository;

import org.carolina.bdd_project.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}

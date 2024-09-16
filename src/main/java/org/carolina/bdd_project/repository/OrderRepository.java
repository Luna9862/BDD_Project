package org.carolina.bdd_project.repository;

import org.carolina.bdd_project.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}

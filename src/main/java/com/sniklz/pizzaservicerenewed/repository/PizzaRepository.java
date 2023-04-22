package com.sniklz.pizzaservicerenewed.repository;

import com.sniklz.pizzaservicerenewed.model.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PizzaRepository extends JpaRepository<Pizza, Long> {
}

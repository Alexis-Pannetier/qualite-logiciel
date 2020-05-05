package com.tactfactory.monprojetsb.qualitelogiciel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tactfactory.monprojetsb.qualitelogiciel.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	Product getProductById(Long p1);

}

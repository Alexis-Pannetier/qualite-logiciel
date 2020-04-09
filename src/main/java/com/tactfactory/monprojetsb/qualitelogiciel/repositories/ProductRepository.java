package com.tactfactory.monprojetsb.qualitelogiciel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tactfactory.monprojetsb.qualitelogiciel.entities.Product;

public interface ProductRepository extends JpaRepository<Product,Long>{

}

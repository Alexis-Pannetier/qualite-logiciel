package com.tactfactory.monprojetsb.qualitelogiciel.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.tactfactory.monprojetsb.qualitelogiciel.entities.Product;
import com.tactfactory.monprojetsb.qualitelogiciel.repositories.ProductRepository;

public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public Product save(Product item) {
		return this.productRepository.save(item);
	}

	public void delete(Product item) {
		this.productRepository.delete(item);
	}

	public void update(Product item) {
		this.productRepository.save(item);
	}

	public List<Product> findAll() {
		return this.productRepository.findAll();
	}

	public Product getProductById(Long id) {
		return this.productRepository.getProductById(id);
	}

	public void saveList(List<Product> products) {
		for (Product product : products) {
			product.setId(productRepository.save(product).getId());
		}
	}
}

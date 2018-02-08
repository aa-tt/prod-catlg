package com.gmart.prodcatlg;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class ProductService {
	
	@Autowired
	public ProductRepository productRepository;
	
	@Transactional
	public Product addProduct(Product product) {
		
		return productRepository.save(product);
	}
	
	public List<Product> getProductsByType(String type) {
		
		return ((List<Product>) productRepository.findAll())
				.stream()
				.filter(product -> {
					return product.type.equals(type);
				})
				.collect(Collectors.toList());
	}

}

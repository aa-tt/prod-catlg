package com.gmart.prodcatlg;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
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

	@Transactional
	public Product deleteById(Integer id) {
		
		Product prod = productRepository.findOne(id);
		/*if (prod != null) */
			productRepository.delete(id);
		return prod;
	}

}

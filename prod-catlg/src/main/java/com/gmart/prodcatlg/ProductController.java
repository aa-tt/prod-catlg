package com.gmart.prodcatlg;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
	
	@Autowired
	public ProductService productService;
	
	@RequestMapping(
			value="/product", 
			method=RequestMethod.GET, 
			produces = {"application/json"})
	public ResponseEntity<List<Product>> getProdByType(@RequestParam(name="type") String type) {
		List<Product> products = productService.getProductsByType(type);
		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}
	
	@RequestMapping(
			value="/product", 
			method=RequestMethod.DELETE, 
			produces = {"application/json"})
	public ResponseEntity<Product> deleteProduct(@RequestParam(name="id") Integer id) {
		Product product = productService.deleteById(id);
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}
	
	@RequestMapping(
			value="/product", 
			method=RequestMethod.POST, 
			consumes = {"application/json"}, 
			produces = {"application/json"})
	public ResponseEntity<Product> addProduct(@RequestBody Product product) {
		Product productSaved = productService.addProduct(product);
		return new ResponseEntity<Product>(productSaved, HttpStatus.OK);
	}

}

package com.gmart.prodcatlg;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProdCatlgApplicationTests {

	@Autowired ProductService productService;
	
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void testAddProduct() {
		
		productService.addProduct(new Product("Jeans", "Denim"));
	}

}

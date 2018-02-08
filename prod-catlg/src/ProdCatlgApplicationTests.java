package com.gmart.prodcatlg;

import static org.junit.Assert.*;

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
		
		Product actual = new Product(5, "Detergent", "Homecare");
		Product expected = productService.addProduct(actual);
		assertEquals(expected.id, actual.id);
		assertEquals(expected.name, actual.name);
		assertEquals(expected.type, actual.type);
	}

}

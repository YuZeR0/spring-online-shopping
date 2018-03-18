package com.gunjankharel.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.gunjankharel.shoppingbackend.dao.ProductDAO;
import com.gunjankharel.shoppingbackend.dto.Product;

public class ProductTestCase {

	private static AnnotationConfigApplicationContext context;

	private static ProductDAO productDAO;

	private Product product;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.gunjankharel.shoppingbackend");
		context.refresh();
		productDAO = (ProductDAO) context.getBean("productDAO");
	}

	@Test
	public void testCRUDProduct() {

		product = new Product();

		product.setName("Samsung Galaxy S9");
		product.setBrand("Samsung");
		product.setDescription("New release!");
		product.setUnitPrice(80000);
		product.setActive(true);
		product.setCategoryId(3);
		product.setSupplierId(3);

		assertEquals("There was an error while adding the product.", true, productDAO.add(product));

		// Reading and Updating category

		product = productDAO.get(2);

		product.setName("Samsung Galaxy S8");
		assertEquals("There was an error while updating the product.", true, productDAO.update(product));
		
		
		//deleting a product
		assertEquals("There was an error while deleting the product.", true, productDAO.delete(product));
		
		
		//fetching the list
		assertEquals("There was an error retrieving the list of products.",7, productDAO.list().size());
	}
}

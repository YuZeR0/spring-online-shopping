package com.gunjankharel.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.gunjankharel.shoppingbackend.dao.CategoryDAO;
import com.gunjankharel.shoppingbackend.dto.Category;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;

	private static CategoryDAO categoryDAO;

	private Category category;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.gunjankharel.shoppingbackend");
		context.refresh();
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
	}

	@Test
	public void testCRUDCategory() {

		category = new Category();

		category.setName("Laptop");
		category.setDescription("Sony VAIO");
		category.setImageURL("CAT_1.png");

		assertEquals("Successfully added category inside table!", true, categoryDAO.add(category));

		category = new Category();

		category.setName("Televisoion");
		category.setDescription("Sony 55in 4K HDR");
		category.setImageURL("CAT_2.png");

		assertEquals("Successfully added category inside table!", true, categoryDAO.add(category));

		categoryDAO.get(2);

		category.setName("Computer");
		assertEquals("Successfully fetched a single category from the table!", true, categoryDAO.update(category));
		
		
		//deleting a category
		assertEquals("Successfully deleted a single category from the table!", true, categoryDAO.delete(category));
		
		
		//fetching the list
		assertEquals("Successfully fetched the list of categories from table!", 6, categoryDAO.list().size());
	}

	/*
	 * @Test public void testGetCategory() { category = categoryDAO.get(3);
	 * assertEquals("Successfully fetched a single category from the table!"
	 * ,"Laptop",category.getName()); }
	 */

	/*
	 * @Test public void testUpdateCategory() { category = categoryDAO.get(3);
	 * 
	 * category.setName("Computer");
	 * assertEquals("Successfully fetched a single category from the table!",true,
	 * categoryDAO.update(category)); }
	 */

	/*@Test
	public void testDeleteCategory() {
		category = categoryDAO.get(3);
		assertEquals("Successfully deleted a single category from the table!", true, categoryDAO.delete(category));
	}*/

	/*
	 * @Test public void testAddCategory() {
	 * 
	 * category = new Category();
	 * 
	 * category.setName("Laptop"); category.setDescription("Sony VAIO");
	 * category.setImageURL("CAT_2.png");
	 * 
	 * assertEquals("Successfully added category inside table!",true,categoryDAO.add
	 * (category));
	 * 
	 * }
	 */

	/*@Test
	public void testListCategory() {
		assertEquals("Successfully fetched the list of categories from table!", 2, categoryDAO.list().size());
	}*/
}

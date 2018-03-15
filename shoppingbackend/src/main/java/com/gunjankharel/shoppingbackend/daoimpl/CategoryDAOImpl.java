package com.gunjankharel.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.gunjankharel.shoppingbackend.dao.CategoryDAO;
import com.gunjankharel.shoppingbackend.dto.Category;


@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

	private static List<Category> categories = new ArrayList<>();

	static {

		// 1st Cateogry
		Category category = new Category();

		category.setId(1);
		category.setName("Television");
		category.setDescription("Sony 55in 4K HDR");
		category.setImageURL("CAT_1.png");

		categories.add(category);

		// 2nd Category
		category = new Category();

		category.setId(2);
		category.setName("Mobile");
		category.setDescription("Sony XPERIA Waterproof");
		category.setImageURL("CAT_2.png");

		categories.add(category);

		// 3rd Category
		category = new Category();

		category.setId(3);
		category.setName("Laptop");
		category.setDescription("Lenovo Gaming SSD Hybrid");
		category.setImageURL("CAT_3.png");

		categories.add(category);

	}

	@Override
	public List<Category> list() {
		return categories;
	}

	@Override
	public Category get(int id) {
		//enchanced for loop
		for(Category category : categories) {
			if(category.getId() == id) {
				return category;
			}
		}
		return null;
	}

}

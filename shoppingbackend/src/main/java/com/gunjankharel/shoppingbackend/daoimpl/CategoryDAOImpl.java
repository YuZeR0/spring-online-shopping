package com.gunjankharel.shoppingbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gunjankharel.shoppingbackend.dao.CategoryDAO;
import com.gunjankharel.shoppingbackend.dto.Category;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Category> list() {
		// HQL is used here. It references class names and not tables
		String selectActiveCategory = "FROM Category WHERE active = :active";
		
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
		query.setParameter("active", true);
		
		return query.getResultList();
		
	}

	// Single category is returned based on ID
	@Override
	public Category get(int id) {
		return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
	}

	@Override
	public boolean add(Category category) {
		try {
			// add the category to the DB table
			sessionFactory.getCurrentSession().persist(category);
			return true;

		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(Category category) {
		try {
			// update a single category in the DB table
			sessionFactory.getCurrentSession().update(category);
			return true;

		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Category category) {
		
		category.setActive(false);
		try {
			// update a single category in the DB table
			sessionFactory.getCurrentSession().update(category);
			return true;

		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

}

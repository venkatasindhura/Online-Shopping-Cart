package com.ksn.shoppingbackend.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ksn.shoppingbackend.dao.categoryDAO;
import com.ksn.shoppingbackend.dto.Category;
@Repository("categoryDao")
@Transactional
public class categoryDAOImpl implements categoryDAO{
	@Autowired
	private SessionFactory sessionFactory;
 /*private static List<Category> categories= new ArrayList<>();
 static{
	 Category category=new Category();
	 category.setId(1);
	 category.setName("Television");
	 category.setDescription("This is description for telivision");
	 category.setImageURL("CAT_1.png");
	 categories.add(category);
	 
	 category=new Category();
	 category.setId(2);
	 category.setName("Mobile");
	 category.setDescription("This is description for telivision");
	 category.setImageURL("CAT_2.png");
	 categories.add(category);
	 
	 category=new Category();
	 category.setId(3);
	 category.setName("Laptop");
	 category.setDescription("This is description for telivision");
	 category.setImageURL("CAT_3.png");
	 categories.add(category);
	 
 }*/
	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return null;
	}
	//Getting single category based on id.
	@Override
	public Category get(int id) {
		// TODO Auto-generated method stub
		//enhanced for loop
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		tx.commit();
		return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
		
		
	}
	@Override
	
	public boolean add(Category category) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		tx.commit();
		try{
			//add the category to the database table.
			sessionFactory.getCurrentSession().persist(category);
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
	}
	//This is for updating single category
	@Override
	public boolean update(Category category) {
		// TODO Auto-generated method stub
		try{
			//add the category to the database table.
			sessionFactory.getCurrentSession().update(category);
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
		 
	}
	@Override
	public boolean delete(Category category) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				Session session=sessionFactory.openSession();
				Transaction tx=session.beginTransaction();
				tx.commit();
		category.setActive(false);
		try{
			//add the category to the database table.
			sessionFactory.getCurrentSession().update(category);
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
		 
	}

}

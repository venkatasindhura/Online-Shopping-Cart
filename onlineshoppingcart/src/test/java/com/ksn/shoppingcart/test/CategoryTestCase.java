package com.ksn.shoppingcart.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ksn.shoppingbackend.dao.categoryDAO;
import com.ksn.shoppingbackend.dto.Category;

public class CategoryTestCase {  
	 
private static AnnotationConfigApplicationContext context;
	 private static categoryDAO categoryDao;
	 private Category category;
    
	@BeforeClass
	public static void init(){
		context = new AnnotationConfigApplicationContext();
		context.scan("com.ksn.shoppingbackend");
		context.refresh();
		categoryDao = (categoryDAO)context.getBean("categoryDao");
		
		}
	/*@Test
	public void testAddCategory(){
		category = new Category();
		category.setName("Television");
		 category.setDescription("This is description for telivision");
		 category.setImageURL("CAT_4.png");
		 assertEquals("Successfully added a category inside the table",true,categoryDao.add(category));
		
	}
	*/
	
	@Test
	public void testGetCategory(){
		category = categoryDao.get(1);
		assertEquals("Successfully fetched a single category from the table","Hp laptop",category.getName());
	}
	
	@Test
	public void testUpdateCategory(){
		category = categoryDao.get(1);
		category.setName("Hp laptop");
		assertEquals("Successfully updated a single category from the table",true,categoryDao.update(category));
	
}
	@Test
	public void testDeleteCategory(){
		category = categoryDao.get(6);
		
		assertEquals("Successfully deleted a single category from the table",true,categoryDao.delete(category));
	
}
}



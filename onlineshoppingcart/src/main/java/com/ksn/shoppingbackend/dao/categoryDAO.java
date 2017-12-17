package com.ksn.shoppingbackend.dao;



import java.util.List;

import org.springframework.stereotype.Service;

import com.ksn.shoppingbackend.dto.Category;

public interface categoryDAO {
	
	List<Category> list();
    Category get(int id); 
    boolean add(Category category);
    boolean update(Category category);
    boolean delete(Category category);
    

}

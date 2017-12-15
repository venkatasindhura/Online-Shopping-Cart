package com.ksn.shoppingbackend.dao;



import java.util.List;

import com.ksn.shoppingbackend.dto.Category;

public interface categoryDAO {
	List<Category> list();

	 Category get(int id); 

}

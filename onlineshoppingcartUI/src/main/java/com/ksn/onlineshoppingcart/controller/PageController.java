package com.ksn.onlineshoppingcart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ksn.shoppingbackend.dao.categoryDAO;
import com.ksn.shoppingbackend.dto.Category;
// +ctrl shift o to import all annaotations at a time in eclipse

@Controller
public class PageController {
	@Autowired
	private categoryDAO categoryDao;
	@RequestMapping(value = {"/" ,"/home" ,"/index"})
	public ModelAndView home(){
		ModelAndView mv = new ModelAndView("page");
		//passing the list of categories
		mv.addObject("categories",categoryDao.list());
		mv.addObject("title","Home");
		mv.addObject("userClickHome",true);
		return mv;
		
	}
	
	
	@RequestMapping(value = "about" )
	public ModelAndView about(){
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","About Us");
		mv.addObject("userClickAbout",true);
		return mv;
		
	}
	
	@RequestMapping(value = "/contact")
	public ModelAndView contact(){
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","Contact Us");
		mv.addObject("userClickContact",true);
		return mv;
		
	}
	
	
  /*@RequestMapping(value="/test")
  public ModelAndView test(@RequestParam(value="greeting",required = false)String greeting){
	  if(greeting == null){
		  greeting = "Hello there";
	  }
	  ModelAndView mv = new ModelAndView("page");
		mv.addObject("greeting",greeting);
		return mv;
	  
  }
  
  @RequestMapping(value="/test/{greeting}")
  public ModelAndView testpathvariable(@PathVariable(value="greeting")String greeting){
	  if(greeting == null){
		  greeting = "Hello there";
	  }
	  ModelAndView mv = new ModelAndView("page");
		mv.addObject("greeting",greeting);
		return mv;
	  
  }*/
	
	//methods to load all the products based on category
	@RequestMapping(value = "/show/all/products")
	public ModelAndView showallproducts(){
		ModelAndView mv = new ModelAndView("page");
		//passing the list of categories
		
		mv.addObject("title","All products");
		mv.addObject("categories",categoryDao.list());
		mv.addObject("userClickAllproducts",true);
		return mv;
		
	}
	@RequestMapping(value = "/show/category/{id}/products")
	public ModelAndView showallproductsById(@PathVariable("id")int id){
		ModelAndView mv = new ModelAndView("page");
		//categoryDao to fetch single category
		Category category =null;
		category = categoryDao.get(id);
		mv.addObject("title",category.getName());
		// passing the list of categories
		mv.addObject("categories",categoryDao.list());
		
		// passing the single category object
				mv.addObject("category",category);
		
		mv.addObject("userClickCategoryProducts",true);
		return mv;
		
	}
}

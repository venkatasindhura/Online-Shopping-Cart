package com.ksn.onlineshoppingcart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
// +ctrl shift o to import all annaotations at a time in eclipse

@Controller
public class PageController {
	@RequestMapping(value = {"/" ,"/home" ,"/index"})
	public ModelAndView home(){
		ModelAndView mv = new ModelAndView("page");
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
}

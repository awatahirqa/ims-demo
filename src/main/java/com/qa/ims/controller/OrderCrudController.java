package com.qa.ims.controller;

import java.util.List;



public interface OrderCrudController<T> {

	 List<T> readAll();
     
	    T create();
	    
	    T update();
	    
	     
	    void delete();
	    
	    T cost();
}



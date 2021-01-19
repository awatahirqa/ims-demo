package com.qa.ims.services;

import java.util.List;

public interface OrderCrudServices <T>{

	
	 public List<T> readAll();
	    
	    T create(T t);
	     
	    T add(T t);
	    
	    T update(T t);
	 
	    void delete(Long id);
	    
	   T createOrderLine(T t);
	    
	    void deleteItem(Long orderid, Long itemid);
	    
	    T cost(T t);

	}


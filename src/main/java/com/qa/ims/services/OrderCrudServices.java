package com.qa.ims.services;

import java.util.List;

public interface OrderCrudServices <T>{

	
	 public List<T> readAll();
	    
	    T create(T t);
	    
	    T createOrderLine(T t);
	    
	    T addItem(T t);
	    
	    T update(T t);
	 
	    void delete(Long id);
	    
	    
	    void deleteItem(Long orderid, Long itemid);
	    
	    T cost(T t);

	}


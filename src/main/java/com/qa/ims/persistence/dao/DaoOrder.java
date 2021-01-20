package com.qa.ims.persistence.dao;

import java.util.List;

public interface DaoOrder <T> {

	 public List<T> readAll();
	    
	    T create(T t);
	     
	    T add(T t);
	    
	    T update(T t);
	 
	    void delete(Long id);
	    
	    T createOrderLine(T t);
	    
	    void deleteItem(Long orderid, Long itemid);
	    
	    T cost(T t);

}

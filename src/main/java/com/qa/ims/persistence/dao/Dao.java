package com.qa.ims.persistence.dao;

import java.util.List;

import com.qa.ims.persistence.domain.Order;

public interface Dao<T> {

    List<T> readAll();
     
    T create(T t);
  
     
    T update(T t);
     
    void delete(long id);
    
    T createOrderLine(T t);
    
    T updateOrderline(T t);

	/**
	 * Reads all customers from the database
	 * @param itemIDs 
	 * 
	 * @return A list of customers
	 */

}
	
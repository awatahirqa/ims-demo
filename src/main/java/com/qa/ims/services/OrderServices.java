package com.qa.ims.services;

import java.util.List;

import com.qa.ims.persistence.dao.Dao;
import com.qa.ims.persistence.dao.OrderDaoMysql;
import com.qa.ims.persistence.domain.Order;

public class OrderServices implements OrderCrudServices<Order> {

		private Dao<Order> orderDao;
		
		public OrderServices(Dao<Order> orderDao) {
			super ();
			this.orderDao = orderDao;
		}
		
		public List<Order> readAll() {
			return orderDao.readAll();
		}

		public Order create(Order order) {
			return orderDao.create(order);
		}
	

		public Order update(Order order) {
			return orderDao.update(order);
		}

		public void delete(Long id) {
			orderDao.delete(id);
		}
		public Order createOrderLine(Order orderline) {
			return orderDao.create(orderline);
		}
		
		public void deleteItem(Long orderID, Long itemID) {
			// TODO Auto-generated method stub
			orderDao.delete( itemID);
			
		}

		
		public Order cost(Order t) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Order add(Order t) {
			// TODO Auto-generated method stub
			return null;
		}


	}



package com.qa.ims.services;

import java.util.List;

import com.qa.ims.persistence.dao.Dao;
import com.qa.ims.persistence.domain.OrderLine;

public class OrderLineServices implements CrudServices<OrderLine> {
	
	private Dao<OrderLine> orderlineDao;
	
	public OrderLineServices(Dao<OrderLine> orderlineDao) {
		this.orderlineDao = orderlineDao;
	}

	@Override
	public List<OrderLine> readAll() {
		return orderlineDao.readAll();
	}

	@Override
	public OrderLine create(OrderLine orderline) {
		return orderlineDao.create(orderline);
	}

	@Override
	public OrderLine update(OrderLine orderline) {
		return orderlineDao.update(orderline);
	}

	@Override
	public void delete(Long id) {
		orderlineDao.delete(id);
	}
}

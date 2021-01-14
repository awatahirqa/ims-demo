package com.qa.ims.controller;

import java.util.List;

import org.apache.log4j.Logger;

import com.qa.ims.persistence.domain.OrderLine;
import com.qa.ims.services.CrudServices;
import com.qa.ims.utils.Utils;

public class OrderLineController implements CrudController<OrderLine> {
	
	public static final Logger LOGGER = Logger.getLogger(OrderLineController.class);
	
	private CrudServices<OrderLine> orderlineService;
	
	public OrderLineController(CrudServices<OrderLine> orderlineService) {
		this.orderlineService = orderlineService;
	}
	
	String getInput() {
		return Utils.getInput();
	}

	@Override
	public List<OrderLine> readAll() {
		List<OrderLine> orderlines = orderlineService.readAll();
		for (OrderLine orderline: orderlines) {
			LOGGER.info(orderline.toString());
		}
		return orderlines;
	}

	@Override
	public OrderLine create() {
		LOGGER.info("Please enter the order ID");
		Long orderId = Long.valueOf(getInput());
		LOGGER.info("Please enter item ID");
		Long itemId = Long.valueOf(getInput());
		LOGGER.info("Please enter item Quantity");
		Long quantity = Long.valueOf(getInput());
		OrderLine orderline = orderlineService.create(new OrderLine(orderId, itemId,quantity));
		LOGGER.info("Orderline Created");
		return orderline;
	}

	@Override
	public OrderLine update() {
		LOGGER.info("Please enter the ID of the order you would like to update");
		Long orderId = Long.valueOf(getInput());
		LOGGER.info("Please enter the new item ID");
		Long itemId = Long.valueOf(getInput());
		LOGGER.info("Please enter the new item Quantity");
		Long quantity = Long.valueOf(getInput());
		OrderLine orderline = orderlineService.update(new OrderLine(orderId, itemId,quantity));
		LOGGER.info("Orderline Updated");
		return orderline;
	}

	@Override
	public void delete() {
		LOGGER.info("Please enter the ID of the orderline you would like to delete");
		Long orderId = Long.valueOf(getInput());
		orderlineService.delete(orderId);
		LOGGER.info("Orderline Deleted");
	}

}

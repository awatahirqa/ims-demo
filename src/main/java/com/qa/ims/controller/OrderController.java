package com.qa.ims.controller;

import java.util.List;

import org.apache.log4j.Logger;

import com.qa.ims.persistence.domain.Order;
import com.qa.ims.services.CrudServices;
import com.qa.ims.utils.Utils;

public class OrderController implements CrudController<Order> {

	public static final Logger LOGGER = Logger.getLogger(OrderController.class);

	private CrudServices<Order> orderService;

	public OrderController(CrudServices<Order> orderService) {
		this.orderService = orderService;
	}

	String getInput() {
		return Utils.getInput();
	}
	Long getLong() {
		return Utils.getLongInput();
		}

	/**
	 * Reads all orders to the logger
	 */
	@Override
	public List<Order> readAll() {
		List<Order> orders = orderService.readAll();
		for (Order order : orders) {
			LOGGER.info(order.toString());
		}
		return orders;
	}

	/**
	 * Creates a order by taking in user input
	 */
	@Override
	public Order create() {
		LOGGER.info("Please enter a Customer ID");
		Long CustomerID = getLong();
		LOGGER.info("Please enter a OrderLineID");
		Long OrdeLineID = getLong();
		LOGGER.info("Please enter a ItemID you would like to add to the order");
		Long ItemID = getLong();
		LOGGER.info("Please enter the Quantity of the Item you want to add");
		Long Quantity = getLong();
		Order order = orderService.create(new Order(CustomerID, OrdeLineID, ItemID, Quantity));
		LOGGER.info("Order created");
		return order;
	}

	/**
	 * Updates an existing order by taking in user input
	 */
	@Override
	public Order update() {
		LOGGER.info("Please enter the id of the order you would like to update");
		Long id = getLong();
		LOGGER.info("Please enter a Customer ID");
		Long CustomerID = getLong();
		LOGGER.info("Please enter a OrderLineID");
		Long OrderLineID = getLong();
		LOGGER.info("Please enter a ItemID you would like to add to the order");
		Long ItemID = getLong();
		LOGGER.info("Please enter the Quantity of the Item you want to add");
		Long Quantity = getLong();
		Order order = orderService.update(new Order(id, CustomerID, OrderLineID, ItemID, Quantity));
		LOGGER.info("Order Updated");
		return order;
	}

	/**
	 * Deletes an existing order by the id of the order
	 */
	@Override
	public void delete() {
		LOGGER.info("Please enter the id of the order you would like to delete");
		Long id = Long.valueOf(getInput());
		orderService.delete(id);
	}

}

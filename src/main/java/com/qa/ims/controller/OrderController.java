package com.qa.ims.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.qa.ims.persistence.domain.Item;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.services.CrudServices;
import com.qa.ims.services.OrderCrudServices;
import com.qa.ims.services.OrderServices;
import com.qa.ims.utils.Utils;

public class OrderController implements OrderCrudController<Order> {

	public static final Logger LOGGER = Logger.getLogger(OrderController.class);

	private OrderCrudServices<Order> orderService;
	private CrudServices<Item> itemServices;

	public OrderController(OrderServices orderServices) {
		this.orderService = orderServices;
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
		Order order = orderService.create(new Order(CustomerID));
		Long OrderID = order.getOrderID();
//		arrl.add(order);
		LOGGER.info("Order " + OrderID + " created ");
		LOGGER.info("Would you like to add an order to this item");
		String Responce = getInput();
		
		
		while (Responce == "yes") {
			
			LOGGER.info("Please enter the number of the Items you want to add");
			Long Quantity = getLong();
			List<Long> ItemIDs = new ArrayList<>();
			LOGGER.info("Please enter the itemIDs you want to add");
				for (int i = 1; i <= Quantity; i++) {
					LOGGER.info("Please enter the ID number of the items you would like to add " + i + ": ");
				ItemIDs.add(Long.valueOf((getInput())));
			}
			 
			Order orderline =  orderService.create(new Order(OrderID, Quantity, ItemIDs));
			LOGGER.info("Orderline created");
			return orderline;
		}
		
			
		
		return null;
	}
    
	public Order createOrderLine() {
		LOGGER.info("Please enter the OrderID of the order you would like to update");
		Long OrderID = getLong();
		LOGGER.info("Please enter the number of the Items you want to add");
		Long Quantity = getLong();
		List<Long> ItemIDs = new ArrayList<>();
		LOGGER.info("Please enter the itemIDs you want to add");
			for (int i = 1; i <= Quantity; i++) {
				LOGGER.info("Please enter the ID of item number " + i + ": ");
			ItemIDs.add(Long.valueOf((getInput())));
		}
		 
		Order orderline =  orderService.create(new Order(OrderID, Quantity, ItemIDs));
		LOGGER.info("Orderline created");
		return orderline;
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
		LOGGER.info("Please enter the Number of Items you want to add");
		Long Quantity = getLong();
		List<Long> ItemIDs = new ArrayList<>();
		for (int i = 1; i <= Quantity; i++) {
			LOGGER.info("Please enter the ItemIDs that you wish to add to the order " + i + ": ");
			ItemIDs.add(Long.valueOf((getInput())));
		}
		
		Order order = orderService.update(new Order(id, CustomerID, Quantity, ItemIDs));
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

	@Override
	public Order add() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public void deleteItem() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Order cost() {
		// TODO Auto-generated method stub
		return null;
	}

}

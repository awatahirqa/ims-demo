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

	public OrderController(OrderServices orderServices,CrudServices<Item> itemServices) {
		this.orderService = orderServices;
		this.itemServices = itemServices;
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
		List<Item> items = itemServices.readAll();
		Item item = null;
		LOGGER.info("Would you like to add an order to this item");
		Boolean loop = false;
		String Escape = "";
		

		while (!loop) {
			LOGGER.info("Please enter ITEM ID");
			Long itemID = Long.valueOf(getInput());
			LOGGER.info("Please enter the Quantity of the ITEM that you'd like");
			Integer quantity = Integer.valueOf(getInput());

			for (Item i : items) {
				if (i.getId() == itemID) {
					item = i;
					LOGGER.info("You have added" +  " " + quantity +" " + "of the below Item" );
					System.out.println(i);
					break;
				}
			}
			
				order.setOrderID(OrderID);
				order.setItemIDs(item);
				order.setIDitem(item.getId());
				LOGGER.info(item.getId());
				int cost = (int) (item.getPrice() * quantity);
				order.setQuantity(quantity);
				order.setCost(cost);
				LOGGER.info(order);
				order = orderService.createOrderLine(order);
				LOGGER.info("ADD: To add another Item to the order ");
				LOGGER.info("RETURN: TO EXIT ");
				Escape = getInput().toLowerCase();
				if (Escape.contentEquals("return")) {
					loop = true;
				}

			}
			LOGGER.info("Order Created");
		return order;	
	}
		
	
    

	/**
	 * Updates an existing order by taking in user input
	 */
	@Override
	public Order update() {
List<Order> orders = orderService.readAll();

		
		
		LOGGER.info("Please enter the Order ID thay you'd like to update");
		Long order_id = Long.valueOf(getInput());
		
		
		
		for (Order i : orders) {
			Order order = null;
			while (i.getOrderID() == order_id) {
				order = i;
				System.out.println(i);
				break;
			}
		}
		
		
		LOGGER.info("Please enter the new customer ID for this order");
		Long customer_id = Long.valueOf(getInput());
		Order Order = orderService.update(new Order(order_id, customer_id));
		LOGGER.info("Order Updated");
		return Order;
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

	@Override
	public Order createOrderLine() {
		// TODO Auto-generated method stub
		return null;
	}

}

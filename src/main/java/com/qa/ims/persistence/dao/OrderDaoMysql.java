package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.qa.ims.persistence.domain.Order;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public  class OrderDaoMysql implements DaoOrder<Order> {
	  

		public static final Logger LOGGER = Logger.getLogger(OrderDaoMysql.class);

		private String jdbcConnectionUrl;
		private String username;
		private String password;

		public OrderDaoMysql(String username, String password) {
			this.jdbcConnectionUrl = "jdbc:mysql://localhost:3306/ims";
			this.username = username;
			this.password = password;
		}

		public OrderDaoMysql(String jdbcConnectionUrl, String username, String password) {
			this.jdbcConnectionUrl = jdbcConnectionUrl;
			this.username = username;
			this.password = password;
		}
		public Order Tablejoin() {
			try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
					Statement statement = connection.createStatement();
					ResultSet resultSet = statement.executeQuery("SELECT OrderID FROM Orders INNER JOIN orderline "
							+ "ON orders.OrderID = orderline.OrderID;");) {
				resultSet.next();
				return OrderFromResultSet(resultSet);
			} catch (Exception e) {
				LOGGER.debug(e.getStackTrace());
				LOGGER.error(e.getMessage());
			}
			return null;
		}
		

		Order OrderFromResultSet(ResultSet resultSet) throws SQLException {
			Long OrderID = resultSet.getLong("OrderID");
			Long CustomerID = resultSet.getLong("CustomerID");
			
			
			return new Order(OrderID,CustomerID);
		}
		Order OrderLineFromResultSet(ResultSet resultSet) throws SQLException {
			Long OrderID = resultSet.getLong("OrderID");
			Long Quantity = resultSet.getLong("Quantity");
			List<Long> ItemIDs = new ArrayList<>();
			while (resultSet.next()) {
			    int i = 1;
			    while (i <= Quantity) {  // don't skip the last column, use <=
			        ItemIDs.add(resultSet.getLong(i++));
			    }
			}
			return new Order(OrderID,Quantity,ItemIDs);
		}
		

		/**
		 * Reads all customers from the database
		 * @param itemIDs 
		 * 
		 * @return A list of customers
		 */
		@Override
		public List<Order> readAll() {
			try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
					Statement statement = connection.createStatement();
					ResultSet resultSet = statement.executeQuery("select * from orders");) {
				ArrayList<Order> order = new ArrayList<>();
				while (resultSet.next()) {
					order.add(OrderFromResultSet(resultSet));
				}
				return order;
			} catch (SQLException e) {
				LOGGER.debug(e.getStackTrace());
				LOGGER.error(e.getMessage());
			}
			return new ArrayList<>();
		}

		public Order readLatest() {
			try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
					Statement statement = connection.createStatement();
					ResultSet resultSet = statement.executeQuery("SELECT * FROM orders ORDER BY OrderID DESC LIMIT 1");) {
				resultSet.next();
				return OrderFromResultSet(resultSet);
			} catch (Exception e) {
				LOGGER.debug(e.getStackTrace());
				LOGGER.error(e.getMessage());
			}
			return null;
		}

		/**
		 * Creates a customer in the database
		 * 
		 * @param customer - takes in a customer object. id will be ignored
		 */
		@Override
		public Order create(Order order) {
			try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
					Statement statement = connection.createStatement();) {
				statement.executeUpdate("insert into orders(CustomerID) values('" + order.getCustomerID() + "')");
				return readLatest();
			} catch (Exception e) {
				LOGGER.debug(e.getStackTrace());
				LOGGER.error(e.getMessage());
			}
			return null;
		}
		public Order readOrder(Long id) {
			try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
					Statement statement = connection.createStatement();
					ResultSet resultSet = statement.executeQuery("SELECT * FROM orders where id = " + id);) {
				resultSet.next();
				return OrderFromResultSet(resultSet);
			} catch (Exception e) {
				LOGGER.debug(e.getStackTrace());
				LOGGER.error(e.getMessage());
			}
			return null;
		}
		
		public Order readOrderLine(Long id) {
			try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
					Statement statement = connection.createStatement();
					ResultSet resultSet = statement.executeQuery("SELECT * FROM orderline where OrderID = " + id);) {
				resultSet.next();
				return OrderFromResultSet(resultSet);
			} catch (Exception e) {
				LOGGER.debug(e.getStackTrace());
				LOGGER.error(e.getMessage());
			}
			return null;
		}

		/**
		 * Updates a customer in the database
		 * 
		 * @param customer - takes in a customer object, the id field will be used to
		 *                 update that customer in the database
		 * @return
		 */
		@Override
		public Order update(Order order) {
			try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
					Statement statement = connection.createStatement();) {
				statement.executeUpdate("update orders set CustomerID ='" + order.getCustomerID() + "' where id =" + order.getOrderID());
				return readOrder(order.getOrderID());
			} catch (Exception e) {
				LOGGER.debug(e.getStackTrace());
				LOGGER.error(e.getMessage());
			}
			return null;
		}

		/**
		 * Deletes a order in the database
		 * 
		 * @param id - id of the order
		 */
		
		public void delete(Long id) {
			try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
					Statement statement = connection.createStatement();) {
				statement.executeUpdate("delete from orders where id = " + id);
			} catch (Exception e) {
				LOGGER.debug(e.getStackTrace());
				LOGGER.error(e.getMessage());
			}
		}
		
		
		public Order createOrderLine(Order order) {
			try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
					Statement statement = connection.createStatement();) {
				statement.executeUpdate("INSERT INTO orderline(OrderID, itemID, quantity) values('" + order.getOrderID() + "','"
						+ order.getItemID() + "','"
						+ order.getQuantity() + "')");
				return readLatest();
			} catch (Exception e) {
				LOGGER.debug(e.getStackTrace());
				LOGGER.error(e.getMessage());
			}
			return null;
		}

		public void deleteItem(Long orderid, Long itemid) {
			// TODO Auto-generated method stub
			try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
					Statement statement = connection.createStatement();) {
				statement.executeUpdate("delete from orderline where orderID = '" + orderid + "' AND itemID = '" + itemid + "'");
			} catch (Exception e) {
				LOGGER.debug(e.getStackTrace());
				LOGGER.error(e.getMessage());
			}
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

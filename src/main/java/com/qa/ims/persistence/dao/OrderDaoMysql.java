package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.qa.ims.persistence.domain.Item;
import com.qa.ims.persistence.domain.Order;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public  class OrderDaoMysql implements Dao<Order> {
	  

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
					ResultSet resultSet = statement.executeQuery("SELECT OrderID FROM orders INNER JOIN orderline "
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
			Integer Quantity = resultSet.getInt("Quantity");
			ArrayList<Item> ItemIDs = new ArrayList<>();
			
			
			return new Order(OrderID,ItemIDs,Quantity);
		
}

		
		@Override
		public List<Order> readAll() {
			try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
					Statement statement = connection.createStatement();
					ResultSet resultSet = statement.executeQuery("SELECT orders.OrderID, orders.CustomerID, orderline.item_id, item.item_name, item.price, orderline.quantity FROM orderline JOIN orders on orderline.order_id=orders.OrderID JOIN item on item.id=orderline.item_id;");) {
				ArrayList<Order> Orders = new ArrayList<>();
				while (resultSet.next()) {
					Orders.add(OrderFromResultSet(resultSet));
				}
				return Orders;
			} catch (SQLException e) {
				LOGGER.debug(e.getStackTrace());
				LOGGER.error(e.getMessage());
			}
			return new ArrayList<>();
		}
		

		public Order readLatest() {
			try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
					Statement statement = connection.createStatement();
					ResultSet resultSet = statement.executeQuery("SELECT * from orders ORDER BY id DESC LIMIT 1;");) {
				resultSet.next();
				return OrderFromResultSet(resultSet);
			} catch (Exception e) {
				LOGGER.debug(e.getStackTrace());
				LOGGER.error(e.getMessage());
			}
			return null;
		}

		
		@Override
		public Order create(Order order) {
			try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
					Statement statement = connection.createStatement();) {
				statement.executeUpdate("INSERT into orders(CustomerID) values('" + order.getCustomerID() + "')");
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
					ResultSet resultSet = statement.executeQuery("SELECT * from orders.OrderID, orders.CustomerID, orderline.item_id, item.item_name, item.price, orderline.quantity from orderline JOIN orders on orderline.order_id=orders.OrderID JOIN items on item.id=orderline.item_id ORDER BY id DESC LIMIT 1;\" where OrderID = " + id);) {
				resultSet.next();
				return OrderFromResultSet(resultSet);
			} catch (Exception e) {
				LOGGER.debug(e.getStackTrace());
				LOGGER.error(e.getMessage());
			}
			return null;
		}
		public Order readnewOrder(Long id) {
			try (Connection conn = DriverManager.getConnection(jdbcConnectionUrl, username, password);
					Statement stmt = conn.createStatement();
					ResultSet resultSet = stmt.executeQuery("select * from orders where OrderID = " + id);) {
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
					ResultSet resultSet = statement.executeQuery("SELECT * FROM orderline where OrderID = '" + id);) {
				resultSet.next();
				return OrderFromResultSet(resultSet);
			} catch (Exception e) {
				LOGGER.debug(e.getStackTrace());
				LOGGER.error(e.getMessage());
			}
			return null;
		}

		
		@Override
		public Order update(Order order) {
			try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
					Statement statement = connection.createStatement();) {
				statement.executeUpdate("update orders set OrderID ='" + order.getOrderID() + "', CustomerID ='" + 
					+ order.getCustomerID() +  "' where OrderID =" + order.getOrderID());
				return readnewOrder(order.getOrderID());
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
		@Override
		public void delete(long OrderID) {
			try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
					Statement statement = connection.createStatement();) {
				statement.executeUpdate("delete from orders where OrderID = " + OrderID);
				statement.executeUpdate("delete from orderline where order_id = " + OrderID);
			} catch (Exception e) {
				LOGGER.debug(e.getStackTrace());
				LOGGER.error(e.getMessage());
			}
		}
		
		
		public Order createOrderLine(Order order) {
			try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
					Statement statement = connection.createStatement();) {
				statement.executeUpdate("INSERT INTO orderline(item_id,order_id, cost, quantity) values("
					    + order.getIDitem() + ","
						+ order.getOrderID() + ","
						+ order.getCost() + ","
						+ order.getQuantity() + ")");
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
				statement.executeUpdate("delete from orderline where order_id = '" + orderid + "' AND item_id = '" + itemid + "'");
			} catch (Exception e) {
				LOGGER.debug(e.getStackTrace());
				LOGGER.error(e.getMessage());
			}
		}
		
		public Order cost(Long OrderID) {
			try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT orderline_id, order_id, SUM(cost) FROM orderline GROUP BY order_id =" + OrderID);) {
			resultSet.next();
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}
		

		

		
		public Order updateOrderLine(Order order) {
			try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
					Statement statement = connection.createStatement();) {
				statement.executeUpdate("INSERT INTO orderline(item_id,order_id, cost, quantity) values("
					    + order.getIDitem() + ","
						+ order.getOrderID() + ","
						+ order.getCost() + ","
						+ order.getQuantity() + ")");
				return readLatest();
			} catch (Exception e) {
				LOGGER.debug(e.getStackTrace());
				LOGGER.error(e.getMessage());
			}
			return null;
		}

		
}

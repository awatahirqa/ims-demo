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

		Order OrderFromResultSet(ResultSet resultSet) throws SQLException {
			Long id = resultSet.getLong("id");
			Long CustomerID = resultSet.getLong("CustomerID");
			Long OrderLineID = resultSet.getLong("OrderLineID");
			return new Order(id, CustomerID, OrderLineID);
		}

		/**
		 * Reads all customers from the database
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
					ResultSet resultSet = statement.executeQuery("SELECT * FROM orders ORDER BY id DESC LIMIT 1");) {
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
				statement.executeUpdate("insert into orders(CustomerID, OrderLineID) values('" + order.getCustomerID()
						+ "','" + order.getOrderLineID() + "')");
				return readLatest();
			} catch (Exception e) {
				LOGGER.debug(e.getStackTrace());
				LOGGER.error(e.getMessage());
			}
			return null;
		}

		public Order readCustomer(Long id) {
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
				statement.executeUpdate("update orders set CustomerID ='" + order.getCustomerID() + "', OrderLineID ='"
						+ order.getOrderLineID() + "' where id =" + order.getId());
				return readCustomer(order.getId());
			} catch (Exception e) {
				LOGGER.debug(e.getStackTrace());
				LOGGER.error(e.getMessage());
			}
			return null;
		}

		/**
		 * Deletes a customer in the database
		 * 
		 * @param id - id of the customer
		 */
		@Override
		public void delete(long id) {
			try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
					Statement statement = connection.createStatement();) {
				statement.executeUpdate("delete from orders where id = " + id);
			} catch (Exception e) {
				LOGGER.debug(e.getStackTrace());
				LOGGER.error(e.getMessage());
			}
		}

}

package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.qa.ims.persistence.domain.OrderLine;

public class OrderLineDaoMysql implements Dao<OrderLine> {

		public static final Logger LOGGER = Logger.getLogger(OrderLineDaoMysql.class);

		private String jdbcConnectionUrl;
		private String username;
		private String password;

		public OrderLineDaoMysql(String username, String password) {
			this.jdbcConnectionUrl = "jdbc:mysql://35.195.192.157	:3306/ims";
			this.username = username;
			this.password = password;
		}

		public OrderLineDaoMysql(String jdbcConnectionUrl, String username, String password) {
			this.jdbcConnectionUrl = jdbcConnectionUrl;
			this.username = username;
			this.password = password;
		}

		OrderLine orderlineFromResultSet(ResultSet resultSet) throws SQLException {
			Long orderID = resultSet.getLong("order_id");
			Long itemID = resultSet.getLong("item_id");
			Long quantitiy = resultSet.getLong("quantitiy");
			return new OrderLine(orderID, itemID,quantitiy); 
		}
		
		@Override
		public List<OrderLine> readAll() {
			try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
					Statement statement = connection.createStatement();
					ResultSet resultSet = statement.executeQuery("select * from orderline");) {
				ArrayList<OrderLine> orderlines = new ArrayList<>();
				while (resultSet.next()) {
					orderlines.add(orderlineFromResultSet(resultSet));
				}
				return orderlines;
			} catch (SQLException e) {
				LOGGER.debug(e.getStackTrace());
				LOGGER.error(e.getMessage());
			}
			return new ArrayList<>();
		}
		
		public OrderLine readLatest() {
			try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
					Statement statement = connection.createStatement();
					ResultSet resultSet = statement.executeQuery("SELECT * FROM orderline ORDER BY order_id DESC LIMIT 1");) {
				resultSet.next();
				return orderlineFromResultSet(resultSet);
			} catch (Exception e) {
				LOGGER.debug(e.getStackTrace());
				LOGGER.error(e.getMessage());
			}
			return null;
		}

		@Override
		public OrderLine create(OrderLine orderline) {
			try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
					Statement statement = connection.createStatement();) {
				statement.executeUpdate("insert into orderline(order_id, item_id) values('" + orderline.getOrderID() + "','" + orderline.getItemID() + "')");
				return readLatest();
			} catch (Exception e) {
				LOGGER.debug(e.getStackTrace());
				LOGGER.error(e.getMessage());
			}
			return null;
		}
		
		public OrderLine readItem(Long id) {
			try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
					Statement statement = connection.createStatement();
					ResultSet resultSet = statement.executeQuery("SELECT * FROM orderline where order_id = " + id);) {
				resultSet.next();
				return orderlineFromResultSet(resultSet);
			} catch (Exception e) {
				LOGGER.debug(e.getStackTrace());
				LOGGER.error(e.getMessage());
			}
			return null;
		}
		@Override
		public OrderLine update(OrderLine orderline) {
			try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
					Statement statement = connection.createStatement();) {
				statement.executeUpdate("update orderline set order_id ='" + orderline.getOrderID() + "', item_id ='"
						+ orderline.getItemID() + "' where order_id =" + orderline.getOrderID());
				return readItem(orderline.getOrderID());
			} catch (Exception e) {
				LOGGER.debug(e.getStackTrace());
				LOGGER.error(e.getMessage());
			}
			return null;
		}

		@Override
		public void delete(long order_id) {
			try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
					Statement statement = connection.createStatement();) {
				statement.executeUpdate("delete from orderline where order_id = " + order_id);
			} catch (Exception e) {
				LOGGER.debug(e.getStackTrace());
				LOGGER.error(e.getMessage());
			}
		}

		

		@Override
		public OrderLine updateOrderline(OrderLine t) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public OrderLine createOrderLine(OrderLine t) {
			// TODO Auto-generated method stub
			return null;
		}
}

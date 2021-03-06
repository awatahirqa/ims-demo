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

public class ItemDaoMysql implements Dao<Item> {
	  

		public static final Logger LOGGER = Logger.getLogger(ItemDaoMysql.class);

		private String jdbcConnectionUrl;
		private String username;
		private String password;

		public ItemDaoMysql(String username, String password) {
			this.jdbcConnectionUrl = "jdbc:mysql://localhost:3306/ims";
			this.username = username;
			this.password = password;
		}

		public ItemDaoMysql(String jdbcConnectionUrl, String username, String password) {
			this.jdbcConnectionUrl = jdbcConnectionUrl;
			this.username = username;
			this.password = password;
		}

		Item ItemFromResultSet(ResultSet resultSet) throws SQLException {
			Long id = resultSet.getLong("id");
			String IName = resultSet.getString("item_name");
			Double price = resultSet.getDouble("price");
			return new Item(id, IName, price);
		}

		/**
		 * Reads all customers from the database
		 * 
		 * @return A list of customers
		 */
		@Override
		public List<Item> readAll() {
			try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
					Statement statement = connection.createStatement();
					ResultSet resultSet = statement.executeQuery("select * from item");) {
				ArrayList<Item> item = new ArrayList<>();
				while (resultSet.next()) {
					item.add(ItemFromResultSet(resultSet));
				}
				return item;
			} catch (SQLException e) {
				LOGGER.debug(e.getStackTrace());
				LOGGER.error(e.getMessage());
			}
			return new ArrayList<>();
		}

		public Item readLatest() {
			try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
					Statement statement = connection.createStatement();
					ResultSet resultSet = statement.executeQuery("SELECT * FROM item ORDER BY id DESC LIMIT 1");) {
				resultSet.next();
				return ItemFromResultSet(resultSet);
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
		public Item create(Item item) {
			try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
					Statement statement = connection.createStatement();) {
				statement.executeUpdate("insert into item(item_name, price) values('" + item.getIName()
						+ "','" + item.getPrice() + "')");
				return readLatest();
			} catch (Exception e) {
				LOGGER.debug(e.getStackTrace());
				LOGGER.error(e.getMessage());
			}
			return null;
		}

		public Item readItem(Long id) {
			try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
					Statement statement = connection.createStatement();
					ResultSet resultSet = statement.executeQuery("SELECT * FROM item where id = " + id);) {
				resultSet.next();
				return ItemFromResultSet(resultSet);
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
		public Item update(Item item) {
			try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
					Statement statement = connection.createStatement();) {
				statement.executeUpdate("update item set item_name  ='" + item.getIName() + "', price ="
						+ item.getPrice() + " where id =" + item.getId());
				return readItem(item.getId());
			} catch (Exception e) {
				LOGGER.debug(e.getStackTrace());
				LOGGER.error(e.getMessage()); 
			}
			return null;
		}
//		update item set item_name = "Samsung sun", price = 100 where id = 1;

		/**
		 * Deletes a customer in the database
		 * 
		 * @param id - id of the customer
		 */
		@Override
		public void delete(long id) {
			try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
					Statement statement = connection.createStatement();) {
				statement.executeUpdate("delete from item where id = " + id);
			} catch (Exception e) {
				LOGGER.debug(e.getStackTrace());
				LOGGER.error(e.getMessage());
			}
		}

		

		@Override
		public Item updateOrderLine(Item t) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Item createOrderLine(Item t) {
			// TODO Auto-generated method stub
			return null;
		}

	}



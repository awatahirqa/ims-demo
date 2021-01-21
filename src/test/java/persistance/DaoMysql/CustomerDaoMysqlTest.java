package persistance.DaoMysql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.qa.ims.Ims;
import com.qa.ims.persistence.dao.CustomerDaoMysql;
import com.qa.ims.persistence.dao.Dao;
import com.qa.ims.persistence.domain.Customer;

public class CustomerDaoMysqlTest {

		public static final Logger LOGGER = Logger.getLogger(CustomerDaoMysql.class);

		private static String jdbcConnectionUrl = "jdbc:mysql://localhost:3306/ims_test";
		private static String username = "root";
		private static String password = "root";


@BeforeClass

public static void init() {
	Ims ims = new Ims();
	ims.init(jdbcConnectionUrl,username,password,"src/test/resources/sql-schema.sql");
}
@Before

public void setup() {
	try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
			Statement statement = connection.createStatement();) {
		statement.executeUpdate("delete from ims_test.customers;");
	} catch (Exception e) {
		LOGGER.debug(e.getStackTrace());
		LOGGER.error(e.getMessage());
	}
}

//Create an instance of class
@Test
public void createTest() {
	CustomerDaoMysql customerDaoMysql = new CustomerDaoMysql(jdbcConnectionUrl, username, password);
	String fn = "Jim";
	String sn = "Bean";
	Customer customer = new Customer(1l ,fn, sn);
	Customer savedCustomer = new Customer(1l, fn, sn);
	customer = customerDaoMysql.create(customer);
	customer.setId(1l);
	assertEquals(savedCustomer, customer);

}

@Test
public void readTest() {
	CustomerDaoMysql customerDaoMysql = new CustomerDaoMysql(jdbcConnectionUrl, username, password);
	String fn = "Jim";
	String sn = "Bean";
	Customer customer = new Customer(1l ,fn, sn);
	Customer savedCustomer = new Customer(1l, fn, sn);
	customer = customerDaoMysql.create(customer);
	customer.setId(1l);
	customerDaoMysql.readCustomer(1l);
	assertEquals(savedCustomer, customer);
}
@Test
public void updateTest() {
	CustomerDaoMysql customerDaoMysql = new CustomerDaoMysql(jdbcConnectionUrl, username, password);
	String fn = "Jim";
	String sn = "Bean";
	Customer customer = new Customer(1l, fn, sn);
	Customer savedCustomer = new Customer(1l, "Jim", "Bean");
	customer = customerDaoMysql.create(customer);
	customerDaoMysql.update(customer);
	customer.setId(1l);
	assertEquals(savedCustomer, customer);

}

@Test
public void readAllTest() {
	CustomerDaoMysql customerDaoMysql = new CustomerDaoMysql(jdbcConnectionUrl, username, password);
	String fn = "Jim";
	String sn = "Bean";
	Customer customer = new Customer(1l, fn, sn);
	Customer savedCustomer = new Customer(1l, fn, sn);
	List<Customer> customers = new ArrayList<>();
	customers.add(customer);
	customers.add(savedCustomer);
	customerDaoMysql.readAll();
	assertEquals(savedCustomer, customer);
	
}

@Test
public void deleteTest() {
	CustomerDaoMysql customerDaoMysql = new CustomerDaoMysql(jdbcConnectionUrl, username, password);
	String fn = "Jim";
	String sn = "Bean";
	Customer customer = new Customer(1l, fn, sn);
	Customer savedCustomer = new Customer(1l, fn, sn);
	customerDaoMysql.create(customer);
	customer.setId(null);
	customerDaoMysql.delete(1L);
	assertNotSame(customer, savedCustomer);
	assertNull(customer);
}


@After
public void clean() {
	try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
			Statement statement = connection.createStatement();) {
		statement.executeUpdate("delete from ims_test.customers");
	} catch (Exception e) {
		LOGGER.debug(e.getStackTrace());
		LOGGER.error(e.getMessage());
	}
}
}


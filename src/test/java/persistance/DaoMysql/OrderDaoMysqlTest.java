package persistance.DaoMysql;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.qa.ims.Ims;
import com.qa.ims.persistence.dao.OrderDaoMysql;
import com.qa.ims.persistence.domain.Order;

public class OrderDaoMysqlTest {
	public static final Logger LOGGER = Logger.getLogger(OrderDaoMysql.class);

	private static String jdbcConnectionUrl = "jdbc:mysql://localhost:3306/ims_test";
	private static String username = "root";
	private static String password = "root";

	@BeforeClass
	public static void init() {
		Ims ims = new Ims();
		ims.init(jdbcConnectionUrl, username, password, "src/test/resources/sql-schema.sql");
	}

	@Before
	public void setUp() throws SQLException {
		Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement(); {
			statement.executeUpdate("delete from ims_test.orders");

		}
	}
	
	@Test
	public void createTest() {
		OrderDaoMysql orderDaoMysqlTest = new OrderDaoMysql(jdbcConnectionUrl, username, password);
		Long customerID = 1L;
		Order order = new Order(1L);
		Order savedOrder = new Order(1L);
		orderDaoMysqlTest.create(order);
		order.setOrderID(1L);
		assertEquals(savedOrder, order);
		
	}
	@Test
	public void readTest() {
		OrderDaoMysql orderDaoMysqlTest = new OrderDaoMysql(jdbcConnectionUrl, username, password);
		Long customerId = 1L;
		Order order = new Order(1L);
		Order savedOrder = new Order(1L);
//		orderDaoMysqlTest.create(order);
		order.setOrderID(1L);
		orderDaoMysqlTest.readOrder(1L);
		assertEquals(savedOrder, order);
		
	}
	@Test
	public void updateTest() {
		OrderDaoMysql orderDaoMysqlTest = new OrderDaoMysql(jdbcConnectionUrl, username, password);
		Long customerId = 1L;
		Order order = new Order(1L);
		Order savedOrder = new Order(1L);
//		orderDaoMysqlTest.create(order);
		order.setOrderID(1L);
		orderDaoMysqlTest.update(order);
		assertEquals(savedOrder, order);
		
	}
	@Test
	public void readAllTest() {
		OrderDaoMysql orderDaoMysqlTest = new OrderDaoMysql(jdbcConnectionUrl, username, password);
		Long customerId = 1L;
		Order order = new Order(1L);
		Order savedOrder = new Order(1L);
		List<Order> orders = new ArrayList<>();
		orders.add(order);
		orders.add(savedOrder);
		orderDaoMysqlTest.readAll();
		assertEquals(savedOrder, order);
		
	} 
	@Test
	public void deleteTest() {
		OrderDaoMysql orderDaoMysqlTest = new OrderDaoMysql(jdbcConnectionUrl, username, password);
		Long customerId = 1L;
		Order order = new Order(1L);
		Order savedOrder = new Order(1L);
//		orderDaoMysqlTest.create(order);
//		order.setOrderId(1L);
		orderDaoMysqlTest.delete(1L);
		assertEquals(savedOrder, order);
		
	}

}

package persistance.DaoMysql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import com.qa.ims.Ims;
import com.qa.ims.persistence.dao.ItemDaoMysql;
import com.qa.ims.persistence.domain.Item;

public class ItemDaoMysqlTest {
	public static final Logger LOGGER = Logger.getLogger(ItemDaoMysql.class);

	private static String jdbcConnectionUrl = "jdbc:mysql://localhost:3306/ims_test";
	private static String username = "root";
	private static String password = "root";

	@BeforeClass
	public static void init() {
		Ims ims = new Ims();
		ims.init(jdbcConnectionUrl, username, password, "src/test/resources/sql-schema.sql");
	}

	@Before
	public void setUp() {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("delete from ims_test.items");
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
	}
	
	@Test
	public void createTest() {
		ItemDaoMysql itemsDaoMysql = new ItemDaoMysql(jdbcConnectionUrl, username, password);
		String IName = "Samsung Spaceship";
		Double price = (double) 870;
		Item item = new Item(null, IName, price);
		Item savedItem = new Item(null, IName, price);
		item = itemsDaoMysql.create(item);
		item.setId(null);
		assertEquals(savedItem, item);
		
	}
	@Test
	public void readTest() {
		ItemDaoMysql itemsDaoMysql = new ItemDaoMysql(jdbcConnectionUrl, username, password);
		String IName = "Samsung Spaceship";
		double price = (double) 870;
		Item item = new Item(null, IName, price);
		Item savedItem = new Item(null, IName, price);
		item = itemsDaoMysql.create(item);
		item.setId(null);
		itemsDaoMysql.readItem(null);
		assertEquals(savedItem, item);
	

}
	
	@Test
	public void updateTest() {
		ItemDaoMysql itemsDaoMysql = new ItemDaoMysql(jdbcConnectionUrl, username, password);
		String IName = "Samsung Spaceship";
		double price = (double) 870;
		Item item = new Item(null, IName, price);
		Item savedItem = new Item(null, IName, price);
		item = itemsDaoMysql.create(item);
		item.setId(null);
		itemsDaoMysql.update(item);
		assertEquals(savedItem, item);
		
	}
	
	@Test
	public void readAllTest() {
		ItemDaoMysql itemsDaoMysql = new ItemDaoMysql(jdbcConnectionUrl, username, password);
		String IName = "Samsung Spaceship";
		double price = (double) 870;
		Item item = new Item(null, IName, price);
		Item savedItem = new Item(null, IName, price);
		List<Item> items = new ArrayList<>();
		items.add(item);
		items.add(savedItem);
		itemsDaoMysql.readAll();
		assertEquals(savedItem, item);
		
	}
	
	@Test
	public void deleteTest() {
		ItemDaoMysql itemsDaoMysql = new ItemDaoMysql(jdbcConnectionUrl, username, password);
		Long id = 1l;
		String IName = "sample1";
		double price = 376.00;
		Item item = new Item(id, IName, price);
		Item savedItem = new Item(id, IName, price);
		itemsDaoMysql.create(item);
		itemsDaoMysql.delete(1l);
	}
	


}

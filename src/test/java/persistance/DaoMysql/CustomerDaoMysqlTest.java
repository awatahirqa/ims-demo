package persistance.DaoMysql;

import org.apache.log4j.Logger;
import org.junit.Before;

import com.qa.ims.Ims;
import com.qa.ims.persistence.dao.CustomerDaoMysql;
import com.qa.ims.persistence.dao.Dao;
import com.qa.ims.persistence.domain.Customer;

public class CustomerDaoMysqlTest {

		public static final Logger LOGGER = Logger.getLogger(CustomerDaoMysql.class);

		private String jdbcConnectionUrl;
		private String username;
		private String password;


@BeforeClass

public static void init() {
	Ims ims = new Ims;
	ims.init(root, root);
}
@Before

public void setup() {
	
}
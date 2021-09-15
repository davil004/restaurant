package tw.org.iii.cma.labcargojsp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tw.org.iii.cma.labcargojsp.Dao.CustomerDAO;
import tw.org.iii.cma.labcargojsp.domain.CustomerBean;


@SpringBootTest
public class CustomerDAOHibernateTests {

	@Autowired
	private CustomerDAO customerDao;
	
	@Test
	public void Testselect() {
		CustomerBean customer = customerDao.select("Carol");
		System.out.println(customer);

	}
}

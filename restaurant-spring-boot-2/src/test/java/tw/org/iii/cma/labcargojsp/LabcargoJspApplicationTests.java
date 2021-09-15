package tw.org.iii.cma.labcargojsp;

import java.util.Locale;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;

@SpringBootTest
class LabcargoJspApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Autowired
	private MessageSource messageSource;
	
	@Test
	public void testMessageSource() {
		String error1 = messageSource.getMessage("login.reqired", null, Locale.TAIWAN);
		System.out.println("error= "+ error1);
	}
}

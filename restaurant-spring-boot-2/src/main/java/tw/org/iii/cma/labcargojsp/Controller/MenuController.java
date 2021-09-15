package tw.org.iii.cma.labcargojsp.Controller;

import java.util.Locale;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;

import tw.org.iii.cma.labcargojsp.domain.MemberBean;
import tw.org.iii.cma.labcargojsp.service.MemberService;
import tw.org.iii.cma.labcargojsp.service.ProductService;
import tw.org.iii.cma.labcargojsp.service.ShoppingCartService;

@Controller
public class MenuController {
	@Autowired
	private ProductService productService;
	@Autowired
	private ShoppingCartService shoppingCartService;
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/secure/menu1.page")
	public String showmenu1(Model model) {
		model.addAttribute("products", productService.getAllProduct());
		model.addAttribute("ShoppingCart", shoppingCartService.getAllShoppingCart());
			
		return "/secure/menu1";
	}

	@GetMapping("/secure/menu2.page")
	public String showmenu2(Model model) {
		model.addAttribute("products", productService.getAllProduct2());
		return "/secure/menu2";
	}
	
	@GetMapping("/secure/menu3.page")
	public String showmenu3(Model model) {
		model.addAttribute("products", productService.getAllProduct3());
		return "/secure/menu3";
	}
	
	@GetMapping("/secure/menu4.page")
	public String showmenu4(Model model) {
		model.addAttribute("products", productService.getAllProduct4());
		return "/secure/menu4";
	}
	
	@GetMapping("/secure/menu5.page")
	public String showmenu5(Model model) {
		model.addAttribute("products", productService.getAllProduct5());
		return "/secure/menu5";
	}
}

package tw.org.iii.cma.labcargojsp.Controller;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import tw.org.iii.cma.labcargojsp.domain.CouponBean;
import tw.org.iii.cma.labcargojsp.domain.ShoppingCart;
import tw.org.iii.cma.labcargojsp.service.ShoppingCartService;

@Controller
public class CartController {

	@Autowired
	private ShoppingCartService shoppingCartService;

	@PostMapping("/addToCart")
	public String addToCart(HttpServletRequest request, Model model, @RequestParam("id") Long id,
			@RequestParam("quantity") int quantity) {

		// sessiontToken
		String sessionToken = (String) request.getSession(true).getAttribute("sessiontToken");
		if (sessionToken == null) {

			sessionToken = UUID.randomUUID().toString();
			request.getSession().setAttribute("sessiontToken", sessionToken);
			shoppingCartService.addShoppingCartFirstTime(id, sessionToken, quantity);
		} else {
			shoppingCartService.addToExistingShoppingCart(id, sessionToken, quantity);
		}
		return "redirect:/secure/menu1.page";
	}

	@GetMapping("/secure/shoppingCart.page")
	public String showShoopingCartView(HttpServletRequest request, Model model) {

		return "/secure/shoppingCart";
	}

	@PostMapping("/updateShoppingCart")
	public String updateCartItem(@RequestParam("item_id") Long id, @RequestParam("quantity") int quantity) {

		shoppingCartService.updateShoppingCartItem(id, quantity);
		return "redirect:/secure/shoppingCart.page";
	}

	@GetMapping("/removeCartItem/{id}")
	public String removeItem(@PathVariable("id") Long id, HttpServletRequest request) {
		String sessionToken = (String) request.getSession(false).getAttribute("sessiontToken");
		System.out.println("got here ");
		shoppingCartService.removeCartIemFromShoppingCart(id, sessionToken);
		return "redirect:/secure/shoppingCart.page";
	}

//	購物車2

	@PostMapping("/addToCart2")
	public String addToCart2(HttpServletRequest request, Model model, @RequestParam("id") Long id,
			@RequestParam("quantity") int quantity) {

		// sessiontToken
		String sessionToken = (String) request.getSession(true).getAttribute("sessiontToken");
		if (sessionToken == null) {

			sessionToken = UUID.randomUUID().toString();
			request.getSession().setAttribute("sessiontToken", sessionToken);
			shoppingCartService.addShoppingCartFirstTime2(id, sessionToken, quantity);
		} else {
			shoppingCartService.addToExistingShoppingCart2(id, sessionToken, quantity);
		}
		return "redirect:/secure/menu2.page";
	}

	@PostMapping("/updateShoppingCart2")
	public String updateCartItem2(@RequestParam("item_id") Long id, @RequestParam("quantity") int quantity) {

		shoppingCartService.updateShoppingCartItem2(id, quantity);
		return "redirect:/secure/shoppingCart.page";
	}

	@GetMapping("/removeCartItem2/{id}")
	public String removeItem2(@PathVariable("id") Long id, HttpServletRequest request) {
		String sessionToken = (String) request.getSession(false).getAttribute("sessiontToken");
		System.out.println("got here ");
		shoppingCartService.removeCartIemFromShoppingCart2(id, sessionToken);
		return "redirect:/secure/shoppingCart.page";
	}

//	購物車3

	@PostMapping("/addToCart3")
	public String addToCart3(HttpServletRequest request, Model model, @RequestParam("id") Long id,
			@RequestParam("quantity") int quantity) {

		// sessiontToken
		String sessionToken = (String) request.getSession(true).getAttribute("sessiontToken");
		if (sessionToken == null) {

			sessionToken = UUID.randomUUID().toString();
			request.getSession().setAttribute("sessiontToken", sessionToken);
			shoppingCartService.addShoppingCartFirstTime3(id, sessionToken, quantity);
		} else {
			shoppingCartService.addToExistingShoppingCart3(id, sessionToken, quantity);
		}
		return "redirect:/secure/menu3.page";
	}

	@PostMapping("/updateShoppingCart3")
	public String updateCartItem3(@RequestParam("item_id") Long id, @RequestParam("quantity") int quantity) {

		shoppingCartService.updateShoppingCartItem3(id, quantity);
		return "redirect:/secure/shoppingCart.page";
	}

	@GetMapping("/removeCartItem3/{id}")
	public String removeItem3(@PathVariable("id") Long id, HttpServletRequest request) {
		String sessionToken = (String) request.getSession(false).getAttribute("sessiontToken");
		System.out.println("got here ");
		shoppingCartService.removeCartIemFromShoppingCart3(id, sessionToken);
		return "redirect:/secure/shoppingCart.page";
	}

//	購物車4

	@PostMapping("/addToCart4")
	public String addToCart4(HttpServletRequest request, Model model, @RequestParam("id") Long id,
			@RequestParam("quantity") int quantity) {

		// sessiontToken
		String sessionToken = (String) request.getSession(true).getAttribute("sessiontToken");
		if (sessionToken == null) {

			sessionToken = UUID.randomUUID().toString();
			request.getSession().setAttribute("sessiontToken", sessionToken);
			shoppingCartService.addShoppingCartFirstTime4(id, sessionToken, quantity);
		} else {
			shoppingCartService.addToExistingShoppingCart4(id, sessionToken, quantity);
		}
		return "redirect:/secure/menu4.page";
	}

	@PostMapping("/updateShoppingCart4")
	public String updateCartItem4(@RequestParam("item_id") Long id, @RequestParam("quantity") int quantity) {

		shoppingCartService.updateShoppingCartItem4(id, quantity);
		return "redirect:/secure/shoppingCart.page";
	}

	@GetMapping("/removeCartItem4/{id}")
	public String removeItem4(@PathVariable("id") Long id, HttpServletRequest request) {
		String sessionToken = (String) request.getSession(false).getAttribute("sessiontToken");
		System.out.println("got here ");
		shoppingCartService.removeCartIemFromShoppingCart4(id, sessionToken);
		return "redirect:/secure/shoppingCart.page";
	}

//	購物車5

	@PostMapping("/addToCart5")
	public String addToCart5(HttpServletRequest request, Model model, @RequestParam("id") Long id,
			@RequestParam("quantity") int quantity) {

		// sessiontToken
		String sessionToken = (String) request.getSession(true).getAttribute("sessiontToken");
		if (sessionToken == null) {

			sessionToken = UUID.randomUUID().toString();
			request.getSession().setAttribute("sessiontToken", sessionToken);
			shoppingCartService.addShoppingCartFirstTime5(id, sessionToken, quantity);
		} else {
			shoppingCartService.addToExistingShoppingCart5(id, sessionToken, quantity);
		}
		return "redirect:/secure/menu5.page";
	}

	@PostMapping("/updateShoppingCart5")
	public String updateCartItem5(@RequestParam("item_id") Long id, @RequestParam("quantity") int quantity) {

		shoppingCartService.updateShoppingCartItem5(id, quantity);
		return "redirect:/secure/shoppingCart.page";
	}

	@GetMapping("/removeCartItem5/{id}")
	public String removeItem5(@PathVariable("id") Long id, HttpServletRequest request) {
		String sessionToken = (String) request.getSession(false).getAttribute("sessiontToken");
		System.out.println("got here ");
		shoppingCartService.removeCartIemFromShoppingCart5(id, sessionToken);
		return "redirect:/secure/shoppingCart.page";
	}

	@GetMapping("/clearShoppingCart")
	public String clearShoopiString(HttpServletRequest request) {
		String sessionToken = (String) request.getSession(false).getAttribute("sessiontToken");
		request.getSession(false).removeAttribute("sessiontToken");
		shoppingCartService.clearShoppingCart(sessionToken);
		return "redirect:/secure/shoppingCart.page";
	}

	@GetMapping("/cashShoppingCart")
	public String cashShopping(HttpSession session, HttpServletRequest request,String coupen,String coupencurret) {
		String sessionToken = (String) request.getSession(false).getAttribute("sessiontToken");
		if (sessionToken != null && !sessionToken.isEmpty() && sessionToken.length() != 0) {
			ShoppingCart shop = shoppingCartService.selecttokan(sessionToken);
			if (shop.getItems().isEmpty() && shop.getItems2().isEmpty() && shop.getItems3().isEmpty()
					&& shop.getItems4().isEmpty() && shop.getItems5().isEmpty()) {
				return "redirect:/secure/menu1.page";
			} else {
				Cookie[] cookies = request.getCookies();
				System.out.println(sessionToken);
				if (cookies != null) {
					for (Cookie cookie : cookies) {
						if (cookie.getName().equals("aaa")) {
							if(coupencurret.length()!=0) {
								CouponBean bean=shoppingCartService.selectcode(coupen);
								System.out.println(shop.getItemsNumber());
								session.setAttribute("finallmoney",shop.getTotalPrice()*(100-bean.getOff())/100);
								request.getSession().setAttribute("sessiontToken", sessionToken);
								return "redirect:/secure/cash.page";
							}else {
								CouponBean bean=shoppingCartService.selectcode(coupen);
								session.setAttribute("finallmoney",shop.getTotalPrice());
								request.getSession().setAttribute("sessiontToken", sessionToken);
								return "redirect:/secure/cash.page";
							}
						}
					}

				}
				return "redirect:/secure/login.page";
			}
		} else {
			System.out.println("null");
			return "redirect:/secure/menu1.page";
		}

	}

	@RequestMapping(path = {"/copenShoppingCart"})
	public String copenshopping(String code, Model model, HttpSession session, HttpServletRequest request) {
		System.out.println(code);
		
		if (code.length() != 0 && code != null && !code.isEmpty()) {
			CouponBean bean=shoppingCartService.selectcode(code);
			if (bean != null) {
				Date starttime = bean.getStartdata();
				Date endtime = bean.getEnddata();
				Calendar calendar = Calendar.getInstance();

				Date today = calendar.getTime();
				if (today.compareTo(starttime) == 0
						|| today.compareTo(starttime) > 0 && today.compareTo(endtime) == 0
						|| today.compareTo(endtime) < 0) {
					
						int abc= bean.getOff();
						String offer=((100-bean.getOff() ) * 0.1 ) + "折";
						session.setAttribute("code", code);
						session.setAttribute("off", abc);
						session.setAttribute("offer", offer);
						session.setAttribute("current", "1");
						session.removeAttribute("error");
						System.out.println(abc);
						return "redirect:/secure/shoppingCart.page";
				}else {
						session.setAttribute("error", "時間過期");
						session.setAttribute("off", 0);
						session.removeAttribute("offer");
						session.removeAttribute("current");
						session.removeAttribute("code");
						return "redirect:/secure/shoppingCart.page";
				}
				
				}else {
					session.setAttribute("error", "請輸入正確折扣碼");
					session.setAttribute("off", 0);
					session.removeAttribute("offer");
					session.removeAttribute("current");
					session.removeAttribute("code");
					return "redirect:/secure/shoppingCart.page";
				}

			}else if(code.length()==0){
				session.setAttribute("off", 0);
				session.removeAttribute("error");
				session.removeAttribute("offer");
				session.removeAttribute("current");
				session.removeAttribute("code");
		return "redirect:/secure/shoppingCart.page";
	}
		return"redirect:/secure/shoppingCart.page";
	}
}

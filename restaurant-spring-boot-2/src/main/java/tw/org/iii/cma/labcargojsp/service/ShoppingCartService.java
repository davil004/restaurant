package tw.org.iii.cma.labcargojsp.service;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.org.iii.cma.labcargojsp.Dao.CartItemRepository;
import tw.org.iii.cma.labcargojsp.Dao.CartItemRepository2;
import tw.org.iii.cma.labcargojsp.Dao.CartItemRepository3;
import tw.org.iii.cma.labcargojsp.Dao.CartItemRepository4;
import tw.org.iii.cma.labcargojsp.Dao.CartItemRepository5;
import tw.org.iii.cma.labcargojsp.Dao.PreferentialRepository;
import tw.org.iii.cma.labcargojsp.Dao.ShoppingCartRepository;
import tw.org.iii.cma.labcargojsp.domain.CartItem;
import tw.org.iii.cma.labcargojsp.domain.CartItem2;
import tw.org.iii.cma.labcargojsp.domain.CartItem3;
import tw.org.iii.cma.labcargojsp.domain.CartItem4;
import tw.org.iii.cma.labcargojsp.domain.CartItem5;
import tw.org.iii.cma.labcargojsp.domain.CouponBean;
import tw.org.iii.cma.labcargojsp.domain.Product;
import tw.org.iii.cma.labcargojsp.domain.Product2;
import tw.org.iii.cma.labcargojsp.domain.Product3;
import tw.org.iii.cma.labcargojsp.domain.Product4;
import tw.org.iii.cma.labcargojsp.domain.Product5;
import tw.org.iii.cma.labcargojsp.domain.ShoppingCart;

@Service
public class ShoppingCartService {

	@Autowired
	private ShoppingCartRepository shoppingCartRepository;
	@Autowired
	private ProductService productService;
	@Autowired
	CartItemRepository cartItemRepository;
	@Autowired
	CartItemRepository2 cartItemRepository2;
	@Autowired
	CartItemRepository3 cartItemRepository3;
	@Autowired
	CartItemRepository4 cartItemRepository4;
	@Autowired
	CartItemRepository5 cartItemRepository5;
	@Autowired
	private PreferentialRepository PreferentialRepo;

	public List<Object[]> all(String sessionToken) {
		List<Object[]> asd = shoppingCartRepository.log(sessionToken);
		return asd;
	}

	public List<ShoppingCart> getAllShoppingCart() {
		return shoppingCartRepository.findAll();
	}

	public ShoppingCart addShoppingCartFirstTime(Long id, String sessionToken, int quantity) {
		ShoppingCart shoppingCart = new ShoppingCart();
		CartItem cartItem = new CartItem();
		cartItem.setQuantity(quantity);
		cartItem.setDate(new Date());
		cartItem.setProduct(productService.getProductById(id));
		shoppingCart.getItems().add(cartItem);
		shoppingCart.setSessionToken(sessionToken);
		shoppingCart.setDate(new Date());
		return shoppingCartRepository.save(shoppingCart);

	}

	public ShoppingCart addToExistingShoppingCart(Long id, String sessionToken, int quantity) {

		ShoppingCart shoppingCart = shoppingCartRepository.findBySessionToken(sessionToken);
		Product p = productService.getProductById(id);
		Boolean productDoesExistInTheCart = false;
		if (shoppingCart != null) {
			Set<CartItem> items = shoppingCart.getItems();
			for (CartItem item : items) {
				if (item.getProduct().equals(p)) {
					productDoesExistInTheCart = true;
					item.setQuantity(item.getQuantity() + quantity);
					shoppingCart.setItems(items);
					return shoppingCartRepository.saveAndFlush(shoppingCart);
				}

			}
		}
		if (!productDoesExistInTheCart && (shoppingCart != null)) {
			CartItem cartItem1 = new CartItem();
			cartItem1.setDate(new Date());
			cartItem1.setQuantity(quantity);
			cartItem1.setProduct(p);
			shoppingCart.getItems().add(cartItem1);
			return shoppingCartRepository.saveAndFlush(shoppingCart);
		}

		return this.addShoppingCartFirstTime(id, sessionToken, quantity);

	}

	public ShoppingCart addShoppingCartFirstTime2(Long id, String sessionToken, int quantity) {
		ShoppingCart shoppingCart = new ShoppingCart();
		CartItem2 cartItem = new CartItem2();
		cartItem.setQuantity(quantity);
		cartItem.setDate(new Date());
		cartItem.setProduct2(productService.getProductById2(id));
		shoppingCart.getItems2().add(cartItem);
		shoppingCart.setSessionToken(sessionToken);
		shoppingCart.setDate(new Date());
		return shoppingCartRepository.save(shoppingCart);

	}

	public ShoppingCart addToExistingShoppingCart2(Long id, String sessionToken, int quantity) {

		ShoppingCart shoppingCart = shoppingCartRepository.findBySessionToken(sessionToken);
		Product2 p = productService.getProductById2(id);
		Boolean productDoesExistInTheCart = false;
		if (shoppingCart != null) {
			Set<CartItem2> items2 = shoppingCart.getItems2();
			for (CartItem2 item : items2) {
				if (item.getProduct2().equals(p)) {
					productDoesExistInTheCart = true;
					item.setQuantity(item.getQuantity() + quantity);
					shoppingCart.setItems2(items2);
					return shoppingCartRepository.saveAndFlush(shoppingCart);
				}

			}
		}
		if (!productDoesExistInTheCart && (shoppingCart != null)) {
			CartItem2 cartItem1 = new CartItem2();
			cartItem1.setDate(new Date());
			cartItem1.setQuantity(quantity);
			cartItem1.setProduct2(p);
			shoppingCart.getItems2().add(cartItem1);
			return shoppingCartRepository.saveAndFlush(shoppingCart);
		}

		return this.addShoppingCartFirstTime(id, sessionToken, quantity);

	}

	public ShoppingCart addShoppingCartFirstTime3(Long id, String sessionToken, int quantity) {
		ShoppingCart shoppingCart = new ShoppingCart();
		CartItem3 cartItem = new CartItem3();
		cartItem.setQuantity(quantity);
		cartItem.setDate(new Date());
		cartItem.setProduct3(productService.getProductById3(id));
		shoppingCart.getItems3().add(cartItem);
		shoppingCart.setSessionToken(sessionToken);
		shoppingCart.setDate(new Date());
		return shoppingCartRepository.save(shoppingCart);

	}

	public ShoppingCart addToExistingShoppingCart3(Long id, String sessionToken, int quantity) {

		ShoppingCart shoppingCart = shoppingCartRepository.findBySessionToken(sessionToken);
		Product3 p = productService.getProductById3(id);
		Boolean productDoesExistInTheCart = false;
		if (shoppingCart != null) {
			Set<CartItem3> items3 = shoppingCart.getItems3();
			for (CartItem3 item : items3) {
				if (item.getProduct3().equals(p)) {
					productDoesExistInTheCart = true;
					item.setQuantity(item.getQuantity() + quantity);
					shoppingCart.setItems3(items3);
					return shoppingCartRepository.saveAndFlush(shoppingCart);
				}

			}
		}
		if (!productDoesExistInTheCart && (shoppingCart != null)) {
			CartItem3 cartItem1 = new CartItem3();
			cartItem1.setDate(new Date());
			cartItem1.setQuantity(quantity);
			cartItem1.setProduct3(p);
			shoppingCart.getItems3().add(cartItem1);
			return shoppingCartRepository.saveAndFlush(shoppingCart);
		}

		return this.addShoppingCartFirstTime(id, sessionToken, quantity);

	}

	public ShoppingCart addShoppingCartFirstTime4(Long id, String sessionToken, int quantity) {
		ShoppingCart shoppingCart = new ShoppingCart();
		CartItem4 cartItem = new CartItem4();
		cartItem.setQuantity(quantity);
		cartItem.setDate(new Date());
		cartItem.setProduct4(productService.getProductById4(id));
		shoppingCart.getItems4().add(cartItem);
		shoppingCart.setSessionToken(sessionToken);
		shoppingCart.setDate(new Date());
		return shoppingCartRepository.save(shoppingCart);

	}

	public ShoppingCart addToExistingShoppingCart4(Long id, String sessionToken, int quantity) {

		ShoppingCart shoppingCart = shoppingCartRepository.findBySessionToken(sessionToken);
		Product4 p = productService.getProductById4(id);
		Boolean productDoesExistInTheCart = false;
		if (shoppingCart != null) {
			Set<CartItem4> items4 = shoppingCart.getItems4();
			for (CartItem4 item : items4) {
				if (item.getProduct4().equals(p)) {
					productDoesExistInTheCart = true;
					item.setQuantity(item.getQuantity() + quantity);
					shoppingCart.setItems4(items4);
					return shoppingCartRepository.saveAndFlush(shoppingCart);
				}

			}
		}
		if (!productDoesExistInTheCart && (shoppingCart != null)) {
			CartItem4 cartItem1 = new CartItem4();
			cartItem1.setDate(new Date());
			cartItem1.setQuantity(quantity);
			cartItem1.setProduct4(p);
			shoppingCart.getItems4().add(cartItem1);
			return shoppingCartRepository.saveAndFlush(shoppingCart);
		}

		return this.addShoppingCartFirstTime(id, sessionToken, quantity);

	}

	public ShoppingCart addShoppingCartFirstTime5(Long id, String sessionToken, int quantity) {
		ShoppingCart shoppingCart = new ShoppingCart();
		CartItem5 cartItem = new CartItem5();
		cartItem.setQuantity(quantity);
		cartItem.setDate(new Date());
		cartItem.setProduct5(productService.getProductById5(id));
		shoppingCart.getItems5().add(cartItem);
		shoppingCart.setSessionToken(sessionToken);
		shoppingCart.setDate(new Date());
		return shoppingCartRepository.save(shoppingCart);

	}

	public ShoppingCart addToExistingShoppingCart5(Long id, String sessionToken, int quantity) {

		ShoppingCart shoppingCart = shoppingCartRepository.findBySessionToken(sessionToken);
		Product5 p = productService.getProductById5(id);
		Boolean productDoesExistInTheCart = false;
		if (shoppingCart != null) {
			Set<CartItem5> items5 = shoppingCart.getItems5();
			for (CartItem5 item : items5) {
				if (item.getProduct5().equals(p)) {
					productDoesExistInTheCart = true;
					item.setQuantity(item.getQuantity() + quantity);
					shoppingCart.setItems5(items5);
					return shoppingCartRepository.saveAndFlush(shoppingCart);
				}

			}
		}
		if (!productDoesExistInTheCart && (shoppingCart != null)) {
			CartItem5 cartItem1 = new CartItem5();
			cartItem1.setDate(new Date());
			cartItem1.setQuantity(quantity);
			cartItem1.setProduct5(p);
			shoppingCart.getItems5().add(cartItem1);
			return shoppingCartRepository.saveAndFlush(shoppingCart);
		}

		return this.addShoppingCartFirstTime(id, sessionToken, quantity);

	}

	public ShoppingCart getShoppingCartBySessionTokent(String sessionToken) {

		return shoppingCartRepository.findBySessionToken(sessionToken);
	}

	public CartItem updateShoppingCartItem(Long id, int quantity) {
		CartItem cartItem = cartItemRepository.findById(id).get();
		cartItem.setQuantity(quantity);
		return cartItemRepository.saveAndFlush(cartItem);

	}

	public CartItem2 updateShoppingCartItem2(Long id, int quantity) {
		CartItem2 cartItem2 = cartItemRepository2.findById(id).get();
		cartItem2.setQuantity(quantity);
		return cartItemRepository2.saveAndFlush(cartItem2);

	}

	public CartItem3 updateShoppingCartItem3(Long id, int quantity) {
		CartItem3 cartItem3 = cartItemRepository3.findById(id).get();
		cartItem3.setQuantity(quantity);
		return cartItemRepository3.saveAndFlush(cartItem3);

	}

	public CartItem4 updateShoppingCartItem4(Long id, int quantity) {
		CartItem4 cartItem4 = cartItemRepository4.findById(id).get();
		cartItem4.setQuantity(quantity);
		return cartItemRepository4.saveAndFlush(cartItem4);

	}

	public CartItem5 updateShoppingCartItem5(Long id, int quantity) {
		CartItem5 cartItem5 = cartItemRepository5.findById(id).get();
		cartItem5.setQuantity(quantity);
		return cartItemRepository5.saveAndFlush(cartItem5);

	}

	public ShoppingCart removeCartIemFromShoppingCart(Long id, String sessionToken) {
		ShoppingCart shoppingCart = shoppingCartRepository.findBySessionToken(sessionToken);
		Set<CartItem> items = shoppingCart.getItems();
		CartItem cartItem = null;
		for (CartItem item : items) {
			if (item.getId() == id) {
				cartItem = item;
			}
		}
		items.remove(cartItem);
		cartItemRepository.delete(cartItem);
		shoppingCart.setItems(items);
		return shoppingCartRepository.save(shoppingCart);
	}

	public ShoppingCart removeCartIemFromShoppingCart2(Long id, String sessionToken) {
		ShoppingCart shoppingCart = shoppingCartRepository.findBySessionToken(sessionToken);
		Set<CartItem2> items = shoppingCart.getItems2();
		CartItem2 cartItem = null;
		for (CartItem2 item : items) {
			if (item.getId() == id) {
				cartItem = item;
			}
		}
		items.remove(cartItem);
		cartItemRepository2.delete(cartItem);
		shoppingCart.setItems2(items);
		return shoppingCartRepository.save(shoppingCart);
	}

	public ShoppingCart removeCartIemFromShoppingCart3(Long id, String sessionToken) {
		ShoppingCart shoppingCart = shoppingCartRepository.findBySessionToken(sessionToken);
		Set<CartItem3> items = shoppingCart.getItems3();
		CartItem3 cartItem = null;
		for (CartItem3 item : items) {
			if (item.getId() == id) {
				cartItem = item;
			}
		}
		items.remove(cartItem);
		cartItemRepository3.delete(cartItem);
		shoppingCart.setItems3(items);
		return shoppingCartRepository.save(shoppingCart);
	}

	public ShoppingCart removeCartIemFromShoppingCart4(Long id, String sessionToken) {
		ShoppingCart shoppingCart = shoppingCartRepository.findBySessionToken(sessionToken);
		Set<CartItem4> items = shoppingCart.getItems4();
		CartItem4 cartItem = null;
		for (CartItem4 item : items) {
			if (item.getId() == id) {
				cartItem = item;
			}
		}
		items.remove(cartItem);
		cartItemRepository4.delete(cartItem);
		shoppingCart.setItems4(items);
		return shoppingCartRepository.save(shoppingCart);
	}

	public ShoppingCart removeCartIemFromShoppingCart5(Long id, String sessionToken) {
		ShoppingCart shoppingCart = shoppingCartRepository.findBySessionToken(sessionToken);
		Set<CartItem5> items = shoppingCart.getItems5();
		CartItem5 cartItem = null;
		for (CartItem5 item : items) {
			if (item.getId() == id) {
				cartItem = item;
			}
		}
		items.remove(cartItem);
		cartItemRepository5.delete(cartItem);
		shoppingCart.setItems5(items);
		return shoppingCartRepository.save(shoppingCart);
	}

	public void clearShoppingCart(String sessionToken) {
		ShoppingCart sh = shoppingCartRepository.findBySessionToken(sessionToken);
		shoppingCartRepository.delete(sh);
	}

	public ShoppingCart selecttokan(String sessiontoken) {
		if (sessiontoken != null) {
			ShoppingCart shop = shoppingCartRepository.findBySessionToken(sessiontoken);
			if (shop != null) {
				return shop;
			}
		}
		return null;
	}
	
	public CouponBean selectcode(String code) {
		if(code!=null&&code.length()!=0) {
			List<CouponBean> bean=PreferentialRepo.findByCode(code);
			if(bean!=null&&!bean.isEmpty()) {
				return  bean.get(0);
			}
			
		}
		return null;
	}
}

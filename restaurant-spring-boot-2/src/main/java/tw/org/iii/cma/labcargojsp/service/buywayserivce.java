package tw.org.iii.cma.labcargojsp.service;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.org.iii.cma.labcargojsp.Dao.MemberRepository;
import tw.org.iii.cma.labcargojsp.Dao.OderdetailRepository;
import tw.org.iii.cma.labcargojsp.Dao.OdertRepository;
import tw.org.iii.cma.labcargojsp.Dao.ShoppingCartRepository;
import tw.org.iii.cma.labcargojsp.domain.CartItem;
import tw.org.iii.cma.labcargojsp.domain.CartItem2;
import tw.org.iii.cma.labcargojsp.domain.CartItem3;
import tw.org.iii.cma.labcargojsp.domain.CartItem4;
import tw.org.iii.cma.labcargojsp.domain.CartItem5;
import tw.org.iii.cma.labcargojsp.domain.MemberBean;
import tw.org.iii.cma.labcargojsp.domain.Orderdetail;
import tw.org.iii.cma.labcargojsp.domain.Ordert;
import tw.org.iii.cma.labcargojsp.domain.ShoppingCart;

@Service
public class buywayserivce {
	@Autowired
	private OdertRepository odertrepository ;
	@Autowired
	private OderdetailRepository oderdetailrepository;
	@Autowired
	private ShoppingCartRepository shoppingcartrepository;
	@Autowired
	private MemberRepository memberrepository;
//	String sessiontoken
	
	
	public MemberBean select(Integer id) {
		if(id!=null) {
			Optional<MemberBean>  bean = memberrepository.findById(id);
			if (bean != null) {
				MemberBean temp= bean.get();
				return temp;
			}
		}
		return null;
	}
	
	public ShoppingCart selecttokan(String session) {
		if(session!=null) {
			ShoppingCart shop= shoppingcartrepository.findBySessionToken(session);
			if(shop!=null) {
				return shop;
			}
		}
		return null;
	}
	
	public ShoppingCart deleted(String sessiontoken) {
	
		if(sessiontoken!=null) {
			ShoppingCart  shop = shoppingcartrepository.findBySessionToken(sessiontoken);
			
			if(shop!=null) {	
				shoppingcartrepository.delete(shop);
				Set<CartItem> items = shop.getItems();	
				Set<CartItem2> items2 = shop.getItems2();	
				Set<CartItem3> items3 = shop.getItems3();	
				Set<CartItem4> items4 = shop.getItems4();	
				Set<CartItem5> items5 = shop.getItems5();	
				
//				CartItem cartItem = null;
//				CartItem2 cartItem2 = null;
//				CartItem3 cartItem3 = null;
//				CartItem4 cartItem4 = null;
//				CartItem5 cartItem5 = null;
//				
//				for(CartItem item : items) {	
//						cartItem = item;		
//				}
//				for(CartItem2 item2 : items2) {	
//					cartItem2 = item2;		
//				}
//				for(CartItem3 item3 : items3) {	
//					cartItem3 = item3;		
//				}
//				for(CartItem4 item4 : items4) {	
//					cartItem4 = item4;		
//				}
//				for(CartItem5 item5 : items5) {	
//					cartItem5 = item5;		
//				}
//				
//				items.remove(cartItem);
//				items2.remove(cartItem2);
//				items3.remove(cartItem3);
//				items4.remove(cartItem4);
//				items5.remove(cartItem5);
				
				items.clear();
				items2.clear();
				items3.clear();
				items4.clear();
				items5.clear();
				
				shop.setItems(items);
				shop.setItems2(items2);
				shop.setItems3(items3);
				shop.setItems4(items4);
				shop.setItems5(items5);
				
				return shoppingcartrepository.saveAndFlush(shop);
			}
			
		}
		return null;
		
	}

	public Orderdetail addorderdetail1(Orderdetail bean) {
		if(bean!=null) {
			
			oderdetailrepository.saveAndFlush(bean);
			return bean;
		}
		return null;
	}

	
	public Ordert addordert(Ordert bean) {
		if(bean!=null) {
			
			odertrepository.saveAndFlush(bean);
				return bean;
		}
		return null;
	}

}

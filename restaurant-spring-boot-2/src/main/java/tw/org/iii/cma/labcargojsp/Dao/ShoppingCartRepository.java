package tw.org.iii.cma.labcargojsp.Dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tw.org.iii.cma.labcargojsp.domain.ShoppingCart;



public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
	ShoppingCart findBySessionToken(String sessionToken);
	
	@Query(value = " SELECT b.items_id , c.items2_id ,d.items3_id,e.items4_id,f.items5_id "
			+ " FROM shoppingcart as a "
			+ " LEFT join shoppingcart_items as b ON a.id=b.shopping_cart_id "
			+ " LEFT join shoppingcart_items2 as c on a.id=c.shopping_cart_id "
			+ " LEFT join shoppingcart_items3 as d on a.id=d.shopping_cart_id "
			+ " LEFT join shoppingcart_items4 as e on a.id=e.shopping_cart_id "
			+ " LEFT join shoppingcart_items5 as f on a.id=f.shopping_cart_id "
			+ " where session_Token= ?1", nativeQuery = true)
	public List<Object[]> log(String sessionToken);
	
}

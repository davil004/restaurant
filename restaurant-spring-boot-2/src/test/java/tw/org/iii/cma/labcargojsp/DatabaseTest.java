package tw.org.iii.cma.labcargojsp;

import java.awt.Window.Type;
import java.math.BigInteger;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tw.org.iii.cma.labcargojsp.Dao.CartItemRepository;
import tw.org.iii.cma.labcargojsp.Dao.CartItemRepository2;
import tw.org.iii.cma.labcargojsp.Dao.CartItemRepository3;
import tw.org.iii.cma.labcargojsp.Dao.CartItemRepository4;
import tw.org.iii.cma.labcargojsp.Dao.CartItemRepository5;
import tw.org.iii.cma.labcargojsp.Dao.OderdetailRepository;
import tw.org.iii.cma.labcargojsp.Dao.ShoppingCartRepository;
import tw.org.iii.cma.labcargojsp.domain.CartItem;
import tw.org.iii.cma.labcargojsp.domain.CartItem2;
import tw.org.iii.cma.labcargojsp.domain.CartItem3;
import tw.org.iii.cma.labcargojsp.domain.CartItem4;
import tw.org.iii.cma.labcargojsp.domain.CartItem5;
import tw.org.iii.cma.labcargojsp.domain.Orderdetail;
import tw.org.iii.cma.labcargojsp.domain.Ordert;
import tw.org.iii.cma.labcargojsp.domain.ShoppingCart;

@SpringBootTest
public class DatabaseTest {

	@Test
	void contextLoads() {

	}

	@Autowired
	private DataSource dataSource;

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private ShoppingCartRepository shp;
	
	@Autowired
	private OderdetailRepository odr;
	@Autowired
	private CartItemRepository at;
	@Autowired
	private CartItemRepository2 at2;
	@Autowired
	private CartItemRepository3 at3;
	@Autowired
	private CartItemRepository4 at4;
	@Autowired
	private CartItemRepository5 at5;

	@Test
	public void test() {
//		List<Object[]> asd = shp.log("ba046605-caec-4912-a62d-85108e2fd63a");
		
		ShoppingCart cart= shp.findBySessionToken("088fabcf-c417-4afe-afc3-3e1bfb56000e");
		System.out.println(cart);
		Set<CartItem> sss=cart.getItems();
		for(CartItem a:sss) {
			System.out.println(a.getId()+"-"+a.getProduct().getId());
		}
		
		System.out.println();
		
//		System.out.println(asd.size());
//		double money =0.0;
//		int quity=0;
//		if (!asd.isEmpty()) {
//			for (int i = 0; i < asd.size(); i++) {
//				Object[] sadsa = asd.get(i);
//				for (int y = 0; y < sadsa.length; y++) {
//					
//					String aa= String.valueOf(sadsa[y]);
//					
//					if ( aa!= null && !aa.equals("null")) {
//						BigInteger aaa = new BigInteger(aa);
//						if(y==0) {
//							Optional<CartItem> asds = at.findById(aaa.longValue());
//							System.out.println(asds.get().getQuantity()*asds.get().getProduct().getPrice());
//							Orderdetail oda= new Orderdetail();
//							oda.setFoodcount(asds.get().getQuantity());
//							oda.setFoodid(asds.get().getProduct().getId().intValue());
//							oda.setFoodmoney((asds.get().getQuantity()*asds.get().getProduct().getPrice().intValue()));
//							oda.setFoodname(asds.get().getProduct().getName());
//							oda.setOrderno1("asdsadsa545");
//							odr.saveAndFlush(oda);
//							money=money+(asds.get().getQuantity()*asds.get().getProduct().getPrice());
//							quity=quity+asds.get().getQuantity();
//							at.deleteById(asds.get().getId());
//							shp.deleteById(shp.findBySessionToken("ba046605-caec-4912-a62d-85108e2fd63a").getId()); 
//						}else if(y==1) {
//							Optional<CartItem2> asds = at2.findById(aaa.longValue());
//							System.out.println(asds.get().getQuantity()*asds.get().getProduct2().getPrice());
//							money=money+(asds.get().getQuantity()*asds.get().getProduct2().getPrice());
//							quity=quity+asds.get().getQuantity();
//						}else if(y==2) {
//							Optional<CartItem3> asds = at3.findById(aaa.longValue());
//							System.out.println(asds.get().getQuantity()*asds.get().getProduct3().getPrice());
//							money=money+(asds.get().getQuantity()*asds.get().getProduct3().getPrice());
//							quity=quity+asds.get().getQuantity();
//						}else if(y==3) {
//							Optional<CartItem4> asds = at4.findById(aaa.longValue());
//							System.out.println(asds.get().getQuantity()*asds.get().getProduct4().getPrice());
//							money=money+(asds.get().getQuantity()*asds.get().getProduct4().getPrice());
//							quity=quity+asds.get().getQuantity();
//						}else if(y==4) {
//							Optional<CartItem5> asds = at5.findById(aaa.longValue());
//							System.out.println(asds.get().getQuantity()*asds.get().getProduct5().getPrice());
//							money=money+(asds.get().getQuantity()*asds.get().getProduct5().getPrice());
//							quity=quity+asds.get().getQuantity();
//						}else {
//							System.out.println("fail");
//						}
//					}else if( aa!= null && aa.equals("null")) {
//						System.out.println("null D");
//					}
//
//				}
//
//			}
//		} else {
//			System.out.println("null data");
//		}
//		System.out.println(money);
//		System.out.println(quity);
	}

//	@Test
//	@Transactional
//	public void testSessionFactory() {
//		   Session session = sessionFactory.openSession();
//	        Transaction transaction = session.beginTransaction();
//	        
//	        List result = session.createNativeQuery("select * from customer").list();
//	        for (Object obj : result) {
//	            Object[] array = (Object[]) obj;
//	            System.out.println(array[0] + ":" + array[2] + ":" + array[3]);
//	        }
//	        
//	        transaction.commit();
//	        session.close();
//	        System.out.println("--------");
//	}
//	
//	
//	@Test
//	public void testDatasource() throws SQLException{
//	     Connection conn = dataSource.getConnection();
//	        PreparedStatement stmt = conn.prepareStatement("select * from product");
//	        ResultSet rset = stmt.executeQuery();
//	        
//	        while(rset.next()) {
//	            int id = rset.getInt("id");
//	            String name = rset.getString("name");
//	            System.out.println(id+":"+name);
//	        }
//	        
//	        rset.close();
//	        stmt.close();
//	        conn.close();
//	}
//	

}

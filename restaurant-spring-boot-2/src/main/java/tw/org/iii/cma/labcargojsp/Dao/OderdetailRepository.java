package tw.org.iii.cma.labcargojsp.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import tw.org.iii.cma.labcargojsp.domain.Orderdetail;
import tw.org.iii.cma.labcargojsp.domain.Ordert;


public interface OderdetailRepository extends JpaRepository<Orderdetail,Integer> {

	List<Orderdetail> findByOrderno1(String id);

	@Modifying
	@Transactional
	String  deleteByOrderno1(String id);
	
	@Query(value = "SELECT  SUM(order_money)  FROM ordert WHERE order_user =?1", nativeQuery = true)
	public int findLevel(String user);
}

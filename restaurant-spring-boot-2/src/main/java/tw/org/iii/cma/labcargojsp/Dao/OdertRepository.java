package tw.org.iii.cma.labcargojsp.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tw.org.iii.cma.labcargojsp.domain.Ordert;

public interface OdertRepository extends JpaRepository<Ordert,String>{

	@Query (value = "SELECT COUNT(*) FROM `ordert` demos WHERE order_way = 'takeout'", nativeQuery = true)
	long countbyordered();

	@Query (value = "SELECT COUNT(*) FROM `ordert` demos WHERE order_way = 'delivery'", nativeQuery = true)
	long countbyordered2();
	
	@Query (value = "SELECT COUNT(*) FROM `ordert` demos WHERE order_way = 'takeout' AND order_money <= 200", nativeQuery = true)
	long countsalesmoney();
	
	@Query (value = "SELECT COUNT(*) FROM `ordert` demos WHERE order_way = 'takeout' AND order_money > 200 AND  order_money <= 500", nativeQuery = true)
	long countsalesmoney2();
	
	@Query (value = "SELECT COUNT(*) FROM `ordert` demos WHERE order_way = 'takeout' AND order_money > 500", nativeQuery = true)
	long countsalesmoney3();
	
	@Query (value = "SELECT COUNT(*) FROM `ordert` demos WHERE order_way = 'delivery' AND order_money <= 200", nativeQuery = true)
	long countdeliverymoney();
	
	@Query (value = "SELECT COUNT(*) FROM `ordert` demos WHERE order_way = 'delivery' AND order_money > 200 AND  order_money <= 500", nativeQuery = true)
	long countdeliverymoney2();
	
	@Query (value = "SELECT COUNT(*) FROM `ordert` demos WHERE order_way = 'delivery' AND order_money > 500", nativeQuery = true)
	long countdeliverymoney3();
	
	@Query (value = "SELECT SUM(order_money) FROM `ordert` WHERE order_way = 'takeout'", nativeQuery = true)
	int countsorder();
	
	@Query (value = "SELECT SUM(order_money) FROM `ordert` WHERE order_way = 'delivery'", nativeQuery = true)
	int countdorder();
	
	@Query (value = "SELECT SUM(order_money) FROM `ordert`   ", nativeQuery = true)
	int countordermoney();

}

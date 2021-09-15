package tw.org.iii.cma.labcargojsp.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tw.org.iii.cma.labcargojsp.domain.CouponBean;

public interface CouponRepository extends JpaRepository<CouponBean, Integer> {
	@Query(value = "SELECT COUPON_NO FROM COUPON", nativeQuery = true)
	public List<String> findCouponNo();
	@Query(value = "SELECT * FROM COUPON WHERE COUPON_NO=?1", nativeQuery = true)
	public CouponBean findByCouponNo(Integer couponNo);
}

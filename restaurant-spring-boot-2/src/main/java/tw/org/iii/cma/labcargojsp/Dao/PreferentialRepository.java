package tw.org.iii.cma.labcargojsp.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tw.org.iii.cma.labcargojsp.domain.CouponBean;

@Repository
public interface PreferentialRepository extends JpaRepository<CouponBean, Integer> {
	
	public List<CouponBean> findByCode(String code);

}

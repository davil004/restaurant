package tw.org.iii.cma.labcargojsp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.org.iii.cma.labcargojsp.Dao.CouponRepository;
import tw.org.iii.cma.labcargojsp.domain.CouponBean;

@Service
@Transactional
public class CouponService {
	@Autowired
	private CouponRepository couponRepository;

	public CouponBean insert(CouponBean bean) {
//		System.out.println("CouponService" + bean.getStartDate());
//		System.out.println("CouponService" + bean.getEndDate());

		if (bean != null && bean.getCouponno() != null) {
			Optional<CouponBean> temp = couponRepository.findById(bean.getCouponno());
			if (temp.isEmpty()) {
				return couponRepository.save(bean);
			}
		}
		return null;
	}
	
	
	@Transactional(readOnly = true)
	public List<CouponBean> select(CouponBean bean) {
		List<CouponBean> result = null;
		if (bean != null && bean.getCouponno() != null && !bean.getCouponno().equals(0)) {
			Optional<CouponBean> temp = couponRepository.findById(bean.getCouponno());
			if (temp.isPresent()) {
				result = new ArrayList<CouponBean>();
				result.add(temp.get());
			}
		} else {
			result = couponRepository.findAll();
		}
		return result;

	}

}

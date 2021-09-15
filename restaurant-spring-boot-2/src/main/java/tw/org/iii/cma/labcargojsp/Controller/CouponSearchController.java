package tw.org.iii.cma.labcargojsp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import tw.org.iii.cma.labcargojsp.domain.CouponBean;
import tw.org.iii.cma.labcargojsp.service.CouponService;

@Controller
public class CouponSearchController {
	@Autowired
	private MessageSource messageSource;
	@Autowired
	private CouponService couponService;

	@RequestMapping(path = { "/pages/couponsearch.controller" })
	public String handlerMethod(CouponBean bean, BindingResult bindingResult, String create, Model model) {
		create = "Select" ;
		System.out.println("xxxxxxx");
		if (create != null && create.equals("Select")) {
			System.out.println("OOOOO");
			List<CouponBean> result = couponService.select(bean);
			model.addAttribute("select", result);
			return "/pages/coupon";
			
		}return null;
	}
}

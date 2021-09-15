package tw.org.iii.cma.labcargojsp.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import tw.org.iii.cma.labcargojsp.domain.CouponBean;
import tw.org.iii.cma.labcargojsp.service.CouponService;

@Controller
public class CouponController {
	@Autowired
	private MessageSource messageSource;
	@Autowired
	private CouponService couponService;

	@RequestMapping(path = { "/pages/coupon.controller" })
	public String handlerMethod(CouponBean bean, BindingResult bindingResult, String create, Model model) {

		Map<String, String> errors = new HashMap<String, String>();
		model.addAttribute("errors", errors);
		System.out.println("CouponController"+bean.getStartdata());
		System.out.println("CouponController"+bean.getEnddata());

//		System.out.println("bean="+bean);
//		System.out.println("bindingResult="+bindingResult);
//		System.out.println("create="+create);
//		System.out.println("model="+model);
		
		if (create != null && create.equals("提交優惠券")) {
			CouponBean result = couponService.insert(bean);
			System.out.println("result="+result);
			
			if (result == null) {
				System.out.println("XXXXXX");

				errors.put("action", "Insert fail");
			} else {
				System.out.println("OOOOOOOOO");

				model.addAttribute("insert", result);
			}

		}
		return "/pages/createcoupon";
	}
}

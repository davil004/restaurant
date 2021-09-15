package tw.org.iii.cma.labcargojsp.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import tw.org.iii.cma.labcargojsp.domain.MemberBean;
import tw.org.iii.cma.labcargojsp.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	private MessageSource messageSource;
	@Autowired
	private MemberService memberService;

	@RequestMapping(path = { "/pages/signup.controller" })
	public String handlerMethod(String account, String password, String memberName,
			String phone, String address, String signup, Model model) {
		Map<String, String> errors = new HashMap<String, String>();
		model.addAttribute("errors", errors);
		
		if (signup != null && signup.equals("註冊")) {
			memberService.insert(account , password , memberName , phone , address);
//			if (result == null) {
//				errors.put("action", "Insert fail");
//			} else {
//				model.addAttribute("insert", result);
//			}

		}
		return "/secure/login";
	}

}

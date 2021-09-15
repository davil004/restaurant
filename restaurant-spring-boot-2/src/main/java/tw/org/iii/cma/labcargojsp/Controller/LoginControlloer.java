package tw.org.iii.cma.labcargojsp.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tw.org.iii.cma.labcargojsp.Dao.MemberRepository;
import tw.org.iii.cma.labcargojsp.domain.MemberBean;
import tw.org.iii.cma.labcargojsp.service.MemberService;

@Controller
public class LoginControlloer {
	@Autowired
	private MemberService memberService;

	@Autowired
	private MessageSource messageSource;

	@Autowired
	private MemberRepository memberRepository;

	@RequestMapping(path = { "/secure/login.controller" })
	public String handlerMethod(MemberBean bean, BindingResult bindingResult, String login, Model model,
			HttpSession session, Locale locale,HttpServletResponse response,HttpServletRequest request) {
//		System.out.println("bean="+bean);
//		System.out.println("bindingResult="+bindingResult);
//		System.out.println("login="+login);
//		System.out.println("model="+model);
//		System.out.println(memberService.login(bean));
//		System.out.println("-----------");

		Map<String, String> errors = new HashMap<String, String>();
		model.addAttribute("errors", errors);
		// 驗證資料
		if (login != null && login.equals("登出")) {
			session.removeAttribute("user");
			errors.put("action", "登出成功1");
			session.setAttribute("fail", "登出成功");
			Cookie[] cookies = request.getCookies();
			if (cookies != null) {
				for (Cookie cookie : cookies) {
					if (cookie.getName().equals("aaa")) {
						
						cookie.setMaxAge(0);
						cookie.setPath("/");
						response.addCookie(cookie);
						return "redirect:/";
					}
				}
			}
		}
		if (login != null && login.equals("登入")) {
			MemberBean result = memberService.login(bean);
			MemberBean result2 = memberService.loginok(bean);
//			System.out.println(result);
			if (result == null) {
//				System.out.println("XX");
//				errors.put("action", "登入失敗");
				session.setAttribute("fail", "登入失敗");
//				session.removeAttribute("user");
			} else {
//				System.out.println("OK");
//				errors.put("action", "login OK  " + "HI," + memberRepository.findMemberName(bean.getAccount()));
				model.addAttribute("login", result);
				session.setAttribute("user", result2);
				String s=result2.getMemberNo().toString();
				Cookie cookie = new Cookie("aaa",s);
				cookie.setPath("/");
				response.addCookie(cookie);
				return "redirect:/";
				
			}
			
			if (bean.getAccount() == null || bean.getAccount().length() == 0) {
//				session.setAttribute("failaccount", messageSource.getMessage("login.account.required", null, locale));
				errors.put("failaccount", messageSource.getMessage("login.account.required", null, locale));
			}
			if (bean.getPassword() == null || bean.getPassword().length() == 0) {
//				session.setAttribute("failpassword", messageSource.getMessage("login.password.required", null, locale));
				errors.put("failpassword", messageSource.getMessage("login.password.required", null, locale));
			}
			

//			// 呼叫model
//			MemberBean bean2 = memberService.login(bean);
//			// 根據model執行結果，導向view
//			if (bean == null) {
//				errors.put("password", messageSource.getMessage("login.fail", null, locale));
//				return "/secure/login";
//			} else {
//				session.setAttribute("user", bean);
//				return "redirect:/";
//			}
		}

		return "redirect:";
	}
	
	
}

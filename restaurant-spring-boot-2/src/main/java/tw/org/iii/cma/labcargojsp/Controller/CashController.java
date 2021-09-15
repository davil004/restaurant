package tw.org.iii.cma.labcargojsp.Controller;

import java.util.Date;
import java.util.Set;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tw.org.iii.cma.labcargojsp.domain.CartItem;
import tw.org.iii.cma.labcargojsp.domain.CartItem2;
import tw.org.iii.cma.labcargojsp.domain.CartItem3;
import tw.org.iii.cma.labcargojsp.domain.CartItem4;
import tw.org.iii.cma.labcargojsp.domain.CartItem5;
import tw.org.iii.cma.labcargojsp.domain.MemberBean;
import tw.org.iii.cma.labcargojsp.domain.Orderdetail;
import tw.org.iii.cma.labcargojsp.domain.Ordert;
import tw.org.iii.cma.labcargojsp.domain.ShoppingCart;
import tw.org.iii.cma.labcargojsp.service.buywayserivce;

@Controller
public class CashController {

	@Autowired
	private buywayserivce BuywaySerivce;

	@GetMapping(path = { "/secure/cash.page" })
	public String initview(Model model, HttpServletRequest request) {

		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("aaa")) {
					String sss = cookie.getValue();
					Integer ss = Integer.valueOf(sss);
					MemberBean buycar = BuywaySerivce.select(ss);
					model.addAttribute("buycar", buycar);
					return "/secure/cash";
				}
			}
		}
		return "/secure/cash";
	}

	@RequestMapping(path = { "/cash.controller" }, method = RequestMethod.POST)
	public String checkcash(String foodWay, String addWay, String addch, String moneyWay, String cashgo,
			HttpSession session, HttpServletRequest request,String finallmoney) {

		if (cashgo != null && cashgo.equals("確認結帳")) {
			if (foodWay != null && foodWay.equals("takeout")) { // 外帶
				System.out.println(foodWay);
				if (moneyWay != null && moneyWay.equals("cash")) { // 使用金錢
					System.out.println(moneyWay);
					int rd = (int) (Math.random() * (100000));
					String aaa = "Big" + rd + "PIG";
					int count = 0;
					String sessionToken = (String) request.getSession(true).getAttribute("sessiontToken");
					ShoppingCart cart = BuywaySerivce.selecttokan(sessionToken);
					if (cart != null) {
						Cookie[] cookies = request.getCookies();
						if (cookies != null) {
							for (Cookie cookie : cookies) {
								if (cookie.getName().equals("aaa")) {
									String sss = cookie.getValue();
									Integer ss = Integer.valueOf(sss);
									MemberBean buycar = BuywaySerivce.select(ss);
									Set<CartItem> ci = cart.getItems();
									Set<CartItem2> ci2 = cart.getItems2();
									Set<CartItem3> ci3 = cart.getItems3();
									Set<CartItem4> ci4 = cart.getItems4();
									Set<CartItem5> ci5 = cart.getItems5();

									if (ci != null && !ci.isEmpty()) {
										for (CartItem ci1 : ci) {
											Orderdetail bean = new Orderdetail();
											bean.setFoodid(ci1.getProduct().getId().intValue());
											bean.setFoodcount(ci1.getQuantity());
											bean.setFoodmoney(
													ci1.getQuantity() * ci1.getProduct().getPrice().intValue() - ci1.getProduct().getDiscount().getDiscount() * ci1.getProduct().getPrice().intValue() / 100);
											bean.setFoodname(ci1.getProduct().getName());
											bean.setOrderno1(aaa);
											BuywaySerivce.addorderdetail1(bean);
											
											count = count + ci1.getQuantity();
										}
									}
									if (ci2 != null && !ci2.isEmpty()) {
										for (CartItem2 ci12 : ci2) {
											Orderdetail bean = new Orderdetail();
											bean.setFoodid(ci12.getProduct2().getId().intValue());
											bean.setFoodcount(ci12.getQuantity());
											bean.setFoodmoney(
													ci12.getQuantity() * ci12.getProduct2().getPrice().intValue() - ci12.getProduct2().getDiscount().getDiscount() * ci12.getProduct2().getPrice().intValue() / 100);
											bean.setFoodname(ci12.getProduct2().getName());
											bean.setOrderno1(aaa);
											BuywaySerivce.addorderdetail1(bean);
											
											count = count + ci12.getQuantity();
										}
									}
									if (ci3 != null && !ci3.isEmpty()) {
										for (CartItem3 ci13 : ci3) {
											Orderdetail bean = new Orderdetail();
											bean.setFoodid(ci13.getProduct3().getId().intValue());
											bean.setFoodcount(ci13.getQuantity());
											bean.setFoodmoney(
													ci13.getQuantity() * ci13.getProduct3().getPrice().intValue() - ci13.getProduct3().getDiscount().getDiscount() * ci13.getProduct3().getPrice().intValue() / 100);
											bean.setFoodname(ci13.getProduct3().getName());
											bean.setOrderno1(aaa);
											BuywaySerivce.addorderdetail1(bean);
											
											count = count + ci13.getQuantity();
										}
									}
									if (ci4 != null && !ci4.isEmpty()) {
										for (CartItem4 ci14 : ci4) {
											Orderdetail bean = new Orderdetail();
											bean.setFoodid(ci14.getProduct4().getId().intValue());
											bean.setFoodcount(ci14.getQuantity());
											bean.setFoodmoney(
													ci14.getQuantity() * ci14.getProduct4().getPrice().intValue() - ci14.getProduct4().getDiscount().getDiscount() * ci14.getProduct4().getPrice().intValue() / 100);
											bean.setFoodname(ci14.getProduct4().getName());
											bean.setOrderno1(aaa);
											BuywaySerivce.addorderdetail1(bean);
											
											count = count + ci14.getQuantity();
										}
									}
									if (ci5 != null && !ci5.isEmpty()) {
										for (CartItem5 ci15 : ci5) {
											Orderdetail bean = new Orderdetail();
											bean.setFoodid(ci15.getProduct5().getId().intValue());
											bean.setFoodcount(ci15.getQuantity());
											bean.setFoodmoney(
													ci15.getQuantity() * ci15.getProduct5().getPrice().intValue()- ci15.getProduct5().getDiscount().getDiscount() * ci15.getProduct5().getPrice().intValue() / 100);
											bean.setFoodname(ci15.getProduct5().getName());
											bean.setOrderno1(aaa);
											BuywaySerivce.addorderdetail1(bean);
											
											count = count + ci15.getQuantity();
										}
									}

									Ordert odt = new Ordert();
									odt.setOrderno(aaa);
									odt.setOrderadd(buycar.getAddress());
									odt.setOrdercount(count);
									odt.setOrdermoney(Math.round(Float.valueOf(finallmoney)));
									odt.setOrderphone(buycar.getPhone());
									odt.setOrdered("未取餐");
									odt.setDate(new Date());
									odt.setOrdertype("cash");
									odt.setOrderuser(buycar.getMemberName());
									odt.setOrderway("takeout");
									BuywaySerivce.addordert(odt);
									BuywaySerivce.deleted(sessionToken);
								}

							}
						}
					} else {
						return "redirect:/";
					}
					return "/secure/finall";
				}
			} else if (foodWay != null && foodWay.equals("delivery")) { // 外送
				System.out.println(foodWay);
				if (addWay != null && addWay.equals("okck")) {// 使用資料中的地址
					System.out.println(addWay);

					if (moneyWay != null && moneyWay.equals("cash")) {// 使用金錢
						System.out.println(moneyWay);
						int rd = (int) (Math.random() * (100000));
						String aaa = "Big" + rd + "PIG";
						
						int count = 0;
						String sessionToken = (String) request.getSession(true).getAttribute("sessiontToken");
						ShoppingCart cart = BuywaySerivce.selecttokan(sessionToken);
						if (cart != null) {
							Cookie[] cookies = request.getCookies();
							if (cookies != null) {
								for (Cookie cookie : cookies) {
									if (cookie.getName().equals("aaa")) {
										String sss = cookie.getValue();
										Integer ss = Integer.valueOf(sss);
										MemberBean buycar = BuywaySerivce.select(ss);
										Set<CartItem> ci = cart.getItems();
										Set<CartItem2> ci2 = cart.getItems2();
										Set<CartItem3> ci3 = cart.getItems3();
										Set<CartItem4> ci4 = cart.getItems4();
										Set<CartItem5> ci5 = cart.getItems5();

										if (ci != null && !ci.isEmpty()) {
											for (CartItem ci1 : ci) {
												Orderdetail bean = new Orderdetail();
												bean.setFoodid(ci1.getProduct().getId().intValue());
												bean.setFoodcount(ci1.getQuantity());
												bean.setFoodmoney(
														ci1.getQuantity() * ci1.getProduct().getPrice().intValue()- ci1.getProduct().getDiscount().getDiscount() * ci1.getProduct().getPrice().intValue() / 100);
												bean.setFoodname(ci1.getProduct().getName());
												bean.setOrderno1(aaa);
												BuywaySerivce.addorderdetail1(bean);
												
												count = count + ci1.getQuantity();
											}
										}
										if (ci2 != null && !ci2.isEmpty()) {
											for (CartItem2 ci12 : ci2) {
												Orderdetail bean = new Orderdetail();
												bean.setFoodid(ci12.getProduct2().getId().intValue());
												bean.setFoodcount(ci12.getQuantity());
												bean.setFoodmoney(
														ci12.getQuantity() * ci12.getProduct2().getPrice().intValue()- ci12.getProduct2().getDiscount().getDiscount() * ci12.getProduct2().getPrice().intValue() / 100);
												bean.setFoodname(ci12.getProduct2().getName());
												bean.setOrderno1(aaa);
												BuywaySerivce.addorderdetail1(bean);
											
												count = count + ci12.getQuantity();
											}
										}
										if (ci3 != null && !ci3.isEmpty()) {
											for (CartItem3 ci13 : ci3) {
												Orderdetail bean = new Orderdetail();
												bean.setFoodid(ci13.getProduct3().getId().intValue());
												bean.setFoodcount(ci13.getQuantity());
												bean.setFoodmoney(
														ci13.getQuantity() * ci13.getProduct3().getPrice().intValue()- ci13.getProduct3().getDiscount().getDiscount() * ci13.getProduct3().getPrice().intValue() / 100);
												bean.setFoodname(ci13.getProduct3().getName());
												bean.setOrderno1(aaa);
												BuywaySerivce.addorderdetail1(bean);
												
												count = count + ci13.getQuantity();
											}
										}
										if (ci4 != null && !ci4.isEmpty()) {
											for (CartItem4 ci14 : ci4) {
												Orderdetail bean = new Orderdetail();
												bean.setFoodid(ci14.getProduct4().getId().intValue());
												bean.setFoodcount(ci14.getQuantity());
												bean.setFoodmoney(
														ci14.getQuantity() * ci14.getProduct4().getPrice().intValue()- ci14.getProduct4().getDiscount().getDiscount() * ci14.getProduct4().getPrice().intValue() / 100);
												bean.setFoodname(ci14.getProduct4().getName());
												bean.setOrderno1(aaa);
												BuywaySerivce.addorderdetail1(bean);
												
												count = count + ci14.getQuantity();
											}
										}
										if (ci5 != null && !ci5.isEmpty()) {
											for (CartItem5 ci15 : ci5) {
												Orderdetail bean = new Orderdetail();
												bean.setFoodid(ci15.getProduct5().getId().intValue());
												bean.setFoodcount(ci15.getQuantity());
												bean.setFoodmoney(
														ci15.getQuantity() * ci15.getProduct5().getPrice().intValue()- ci15.getProduct5().getDiscount().getDiscount() * ci15.getProduct5().getPrice().intValue() / 100);
												bean.setFoodname(ci15.getProduct5().getName());
												bean.setOrderno1(aaa);
												BuywaySerivce.addorderdetail1(bean);
												
												count = count + ci15.getQuantity();
											}
										}

										Ordert odt = new Ordert();
										odt.setOrderno(aaa);
										odt.setOrderadd(buycar.getAddress());
										odt.setOrdercount(count);
										odt.setOrdermoney(Math.round(Float.valueOf(finallmoney)));
										odt.setOrderphone(buycar.getPhone());
										odt.setOrdered("未取餐");
										odt.setDate(new Date());
										odt.setOrdertype("cash");
										odt.setOrderuser(buycar.getMemberName());
										odt.setOrderway("delivery");
										BuywaySerivce.addordert(odt);
										BuywaySerivce.deleted(sessionToken);
									}

								}
							}
						} else {
							return "redirect:/";
						}
						return "/secure/finall";

					}

				} else if (addWay != null && addWay.equals("chageck")) {
					System.out.println(addWay);
					if (addch != null && addch.length() != 0) {// 使用新地址
						System.out.println(addch);
						if (moneyWay != null && moneyWay.equals("cash")) {// 使用金錢
							System.out.println(moneyWay);
							int rd = (int) (Math.random() * (100000));
							String aaa = "Big" + rd + "PIG";
							
							int count = 0;
							String sessionToken = (String) request.getSession(true).getAttribute("sessiontToken");
							ShoppingCart cart = BuywaySerivce.selecttokan(sessionToken);
							if (cart != null) {
								Cookie[] cookies = request.getCookies();
								if (cookies != null) {
									for (Cookie cookie : cookies) {
										if (cookie.getName().equals("aaa")) {
											String sss = cookie.getValue();
											Integer ss = Integer.valueOf(sss);
											MemberBean buycar = BuywaySerivce.select(ss);
											Set<CartItem> ci = cart.getItems();
											Set<CartItem2> ci2 = cart.getItems2();
											Set<CartItem3> ci3 = cart.getItems3();
											Set<CartItem4> ci4 = cart.getItems4();
											Set<CartItem5> ci5 = cart.getItems5();

											if (ci != null && !ci.isEmpty()) {
												for (CartItem ci1 : ci) {
													Orderdetail bean = new Orderdetail();
													bean.setFoodid(ci1.getProduct().getId().intValue());
													bean.setFoodcount(ci1.getQuantity());
													bean.setFoodmoney(
															ci1.getQuantity() * ci1.getProduct().getPrice().intValue()- ci1.getProduct().getDiscount().getDiscount() * ci1.getProduct().getPrice().intValue() / 100);
													bean.setFoodname(ci1.getProduct().getName());
													bean.setOrderno1(aaa);
													BuywaySerivce.addorderdetail1(bean);
													
													count = count + ci1.getQuantity();
												}
											}
											if (ci2 != null && !ci2.isEmpty()) {
												for (CartItem2 ci12 : ci2) {
													Orderdetail bean = new Orderdetail();
													bean.setFoodid(ci12.getProduct2().getId().intValue());
													bean.setFoodcount(ci12.getQuantity());
													bean.setFoodmoney(
															ci12.getQuantity() * ci12.getProduct2().getPrice().intValue()- ci12.getProduct2().getDiscount().getDiscount() * ci12.getProduct2().getPrice().intValue() / 100);
													bean.setFoodname(ci12.getProduct2().getName());
													bean.setOrderno1(aaa);
													BuywaySerivce.addorderdetail1(bean);
													
													count = count + ci12.getQuantity();
												}
											}
											if (ci3 != null && !ci3.isEmpty()) {
												for (CartItem3 ci13 : ci3) {
													Orderdetail bean = new Orderdetail();
													bean.setFoodid(ci13.getProduct3().getId().intValue());
													bean.setFoodcount(ci13.getQuantity());
													bean.setFoodmoney(
															ci13.getQuantity() * ci13.getProduct3().getPrice().intValue()- ci13.getProduct3().getDiscount().getDiscount() * ci13.getProduct3().getPrice().intValue() / 100);
													bean.setFoodname(ci13.getProduct3().getName());
													bean.setOrderno1(aaa);
													BuywaySerivce.addorderdetail1(bean);
													
													count = count + ci13.getQuantity();
												}
											}
											if (ci4 != null && !ci4.isEmpty()) {
												for (CartItem4 ci14 : ci4) {
													Orderdetail bean = new Orderdetail();
													bean.setFoodid(ci14.getProduct4().getId().intValue());
													bean.setFoodcount(ci14.getQuantity());
													bean.setFoodmoney(
															ci14.getQuantity() * ci14.getProduct4().getPrice().intValue()- ci14.getProduct4().getDiscount().getDiscount() * ci14.getProduct4().getPrice().intValue() / 100);
													bean.setFoodname(ci14.getProduct4().getName());
													bean.setOrderno1(aaa);
													BuywaySerivce.addorderdetail1(bean);
													
													count = count + ci14.getQuantity();
												}
											}
											if (ci5 != null && !ci5.isEmpty()) {
												for (CartItem5 ci15 : ci5) {
													Orderdetail bean = new Orderdetail();
													bean.setFoodid(ci15.getProduct5().getId().intValue());
													bean.setFoodcount(ci15.getQuantity());
													bean.setFoodmoney(
															ci15.getQuantity() * ci15.getProduct5().getPrice().intValue()- ci15.getProduct5().getDiscount().getDiscount() * ci15.getProduct5().getPrice().intValue() / 100);
													bean.setFoodname(ci15.getProduct5().getName());
													bean.setOrderno1(aaa);
													BuywaySerivce.addorderdetail1(bean);
													
													count = count + ci15.getQuantity();
												}
											}

											Ordert odt = new Ordert();
											odt.setOrderno(aaa);
											odt.setOrderadd(addch);
											odt.setOrdercount(count);
											odt.setOrdermoney(Math.round(Float.valueOf(finallmoney)));
											odt.setOrdered("未取餐");
											odt.setDate(new Date());
											odt.setOrderphone(buycar.getPhone());
											odt.setOrdertype("cash");
											odt.setOrderuser(buycar.getMemberName());
											odt.setOrderway("delivery");
											BuywaySerivce.addordert(odt);
											BuywaySerivce.deleted(sessionToken);
										}

									}
								}
							} else {
								return "redirect:/";
							}
							return "/secure/finall";

						}

					} else {
						session.setAttribute("fails", "請輸入地址");
						System.out.println("fail");
						return "redirect:/secure/cash.page";
					}
				}
			}
		} else if (cashgo != null && cashgo.equals("返回購物")) {
			return "redirect:/secure/menu1.page";
		}
		return "redirect:/secure/cash.page";
	}

}

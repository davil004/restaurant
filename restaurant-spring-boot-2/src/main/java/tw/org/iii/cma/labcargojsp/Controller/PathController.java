package tw.org.iii.cma.labcargojsp.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import tw.org.iii.cma.labcargojsp.domain.Category;
import tw.org.iii.cma.labcargojsp.domain.Ordert;
import tw.org.iii.cma.labcargojsp.domain.Product;
import tw.org.iii.cma.labcargojsp.service.ProductService;
import tw.org.iii.cma.labcargojsp.service.ShoppingCartService;

@Controller
public class PathController {

	@Autowired
	private ProductService productService;
//	  	java 路徑組態檔
	
//		前台路徑
		@GetMapping(
				path = {"/"}
		)
		public String FrontEnd1() {
				return "/index";
		}
		@RequestMapping(
				path = {"/secure/login.page"}
		)
		public String FrontEnd2() {
			
			return "/secure/login";
		}
		@RequestMapping(
				path = {"/secure/cash.page"}
		)
		public String FrontEnd3(HttpServletRequest request, Model model) {
			
			return "/secure/cash";
		}
		@RequestMapping(
				path = {"/secure/finall.page"}
		)
		public String FrontEnd4() {
			
			return "/secure/finall";
		}
		@RequestMapping(
				path = {"/secure/news.page"}
		)
		public String FrontEnd5( Model model) {
			model.addAttribute("Preferentials", productService.getAlloffer());
			return "/secure/news";
		}
		@RequestMapping(
				path = {"/secure/newsdetail.page"}
		)
		public String FrontEnd6() {
			
			return "/secure/newsdetail";
		}
		@RequestMapping(
				path = {"/secure/signup.page"}
		)
		public String FrontEnd7() {
			
			return "/secure/signup";
		}
		@RequestMapping(
				path = {"/secure/member.page"}
		)
		public String FrontEnd8() {
			
			return "/secure/member";
		}
		@RequestMapping(
				path = {"/secure/about.page"}
		)
		public String FrontEnd9() {
			
			return "/secure/about";
		}
		@RequestMapping(
				path = {"/pages/memberdetail.page"}
		)
		public String FrontEnd10() {
			
			return "/pages/memberdetail";
		}
		
		
		
//		後台路徑  		    
		@GetMapping(
				path = {"/manage/back.page"}
		)
		public String BackEnd1(Model model) {
			model.addAttribute("products", productService.count());
			model.addAttribute("products2", productService.count2());
			model.addAttribute("products3", productService.count3());
			model.addAttribute("products4", productService.count4());
			model.addAttribute("products5", productService.count5());
			model.addAttribute("orders", productService.orders());
			model.addAttribute("members", productService.countmember());
			
			return "/manage/back";
		}
		
		@RequestMapping(
				path = {"/manage/sales.page"}
		)
		public String BackEnd4(Model model) {
			model.addAttribute("sales", productService.salescount());
			model.addAttribute("orders", productService.orders());
			model.addAttribute("ordermoney", productService.ordermoney());
			model.addAttribute("countsorder", productService.countsorder());
			
			model.addAttribute("countsalesmoney", productService.countsalesmoney());
			model.addAttribute("countsalesmoney2", productService.countsalesmoney2());
			model.addAttribute("countsalesmoney3", productService.countsalesmoney3());
			model.addAttribute("countdeliverymoney", productService.countdeliverymoney());
			model.addAttribute("countdeliverymoney2", productService.countdeliverymoney2());
			model.addAttribute("countdeliverymoney3", productService.countdeliverymoney3());
		
			return "/manage/sales";
		}
		@RequestMapping(
				path = {"/manage/Preferential.page"}
		)
		public String BackEnd5(Model model) {
			model.addAttribute("Preferentials", productService.getAlloffer());
			return "/manage/Preferential";
		}
		@RequestMapping(
				path = {"/manage/delivery.page"}
		)
		public String BackEnd6(Model model) {
			model.addAttribute("ordermoney", productService.ordermoney());
			model.addAttribute("dordermoney", productService.countdorder());
			model.addAttribute("deliveryorders", productService.deliverycount());
			model.addAttribute("orders", productService.orders());
			
			
			
			model.addAttribute("countsalesmoney", productService.countsalesmoney());
			model.addAttribute("countsalesmoney2", productService.countsalesmoney2());
			model.addAttribute("countsalesmoney3", productService.countsalesmoney3());
			model.addAttribute("countdeliverymoney", productService.countdeliverymoney());
			model.addAttribute("countdeliverymoney2", productService.countdeliverymoney2());
			model.addAttribute("countdeliverymoney3", productService.countdeliverymoney3());
			
			return "/manage/delivery";
		}
		@RequestMapping(
				path = {"/pages/display.page"}
		)
		public String BackEnd7() {
			
			return "/pages/display";
		}
		@GetMapping(
				path = {"/pages/orderbuyway.page"}
		)
		public String BackEnd8(Model model) {
		
			model.addAttribute("orders", productService.getAllOrder());
			return "/pages/orderbuyway";
		}
		@GetMapping(
				path = {"/pages/Preferentialadd.page"}
		)
		public String BackEnd9(Model model) {
		
			return "/pages/Preferentialadd";
		}
}

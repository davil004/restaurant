
package tw.org.iii.cma.labcargojsp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import tw.org.iii.cma.labcargojsp.Dao.PreferentialRepository;
import tw.org.iii.cma.labcargojsp.domain.CouponBean;
import tw.org.iii.cma.labcargojsp.domain.Product;
import tw.org.iii.cma.labcargojsp.domain.Product2;
import tw.org.iii.cma.labcargojsp.domain.Product3;
import tw.org.iii.cma.labcargojsp.domain.Product4;
import tw.org.iii.cma.labcargojsp.domain.Product5;
import tw.org.iii.cma.labcargojsp.service.ProductService;

@Controller
public class DetailsController {
	@Autowired
	private ProductService productService;
	

	@GetMapping("/secure/detail/{id}")
	public String showIndex(@PathVariable("id") Long id, Model model) {
		Product produt = productService.getProductById(id);
		model.addAttribute("product", produt);
		return "/secure/details";
	}
	
	@GetMapping("/secure/detail2/{id}")
	public String showIndex2(@PathVariable("id") Long id, Model model) {
		Product2 produt = productService.getProductById2(id);
		model.addAttribute("product", produt);
		return "/secure/details";
	}
	
	@GetMapping("/secure/detail3/{id}")
	public String showIndex3(@PathVariable("id") Long id, Model model) {
		Product3 produt = productService.getProductById3(id);
		model.addAttribute("product", produt);
		return "/secure/details";
	}
	
	@GetMapping("/secure/detail4/{id}")
	public String showIndex4(@PathVariable("id") Long id, Model model) {
		Product4 produt = productService.getProductById4(id);
		model.addAttribute("product", produt);
		return "/secure/details";
	}
	
	@GetMapping("/secure/detail5/{id}")
	public String showIndex5(@PathVariable("id") Long id, Model model) {
		Product5 produt = productService.getProductById5(id);
		model.addAttribute("product", produt);
		return "/secure/details";
	}
	
	@GetMapping("/secure/newsdetail/{id}")
	public String showNewsDetail(@PathVariable("id") Integer id, Model model) {
		CouponBean news = productService.getnewsById(id);
		model.addAttribute("news", news);
		return "/secure/newsdetail";
	}
}

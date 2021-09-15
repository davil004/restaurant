package tw.org.iii.cma.labcargojsp.adminProductController;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Delayed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import tw.org.iii.cma.labcargojsp.Dao.PreferentialRepository;
import tw.org.iii.cma.labcargojsp.domain.CartItem;
import tw.org.iii.cma.labcargojsp.domain.Category;
import tw.org.iii.cma.labcargojsp.domain.Orderdetail;
import tw.org.iii.cma.labcargojsp.domain.Ordert;
import tw.org.iii.cma.labcargojsp.domain.Product;
import tw.org.iii.cma.labcargojsp.domain.Product2;
import tw.org.iii.cma.labcargojsp.domain.Product3;
import tw.org.iii.cma.labcargojsp.domain.Product4;
import tw.org.iii.cma.labcargojsp.domain.Product5;
import tw.org.iii.cma.labcargojsp.domain.ShoppingCart;
import tw.org.iii.cma.labcargojsp.service.ProductService;

@Controller
public class AdminProductController {
	
	@Autowired
	private ProductService productService;
	
	
	@GetMapping("/Admin/index")
	public String showExampleView(Model model)
	{
		List<Product> products = productService.getAllProduct();
		model.addAttribute("products", products);
		return "Admin/index";
	}
    @GetMapping("/Admin/product")
    public String showAddProduct(Model model)
    {
    	model.addAttribute("category", new Category());
    	model.addAttribute("categories", productService.getAllCategories());
    	model.addAttribute("products", productService.getAllProduct());
    	return "Admin/product";
    }
    
    @GetMapping("/manage/product.page")
	public String prodcut(Model model)
	{
    	
		List<Product> products = productService.getAllProduct();
		model.addAttribute("products", products);
		return "manage/product";
	}
 
    
    @GetMapping("/pages/pcrud.page")
    public String BackEnd2showAddProductp(Model model)
    {
    	model.addAttribute("category", new Category());
    	model.addAttribute("categories", productService.getAllCategories());
    	model.addAttribute("products", productService.getAllProduct());
    	
    	return "pages/pcrud";
    }
  
    @GetMapping("/pages/pcrud2.page")
    public String BackEnd3showAddProductp(Model model)
    {
    	model.addAttribute("category", new Category());
    	model.addAttribute("categories", productService.getAllCategories());
    	model.addAttribute("products", productService.getAllProduct());
    	model.addAttribute("products2", productService.getAllProduct2());
    	model.addAttribute("products3", productService.getAllProduct3());
    	model.addAttribute("products4", productService.getAllProduct4());
    	model.addAttribute("products5", productService.getAllProduct5());
    	return "pages/pcrud2";
    }
    
    
    
    @RequestMapping(
			path = {"/manage/order.page"}
	)
	public String BackEnd3showorder(Model model) {
    	model.addAttribute("orders", productService.getAllOrder());
		return "/manage/order";
	}
    
    @GetMapping(
			path = {"/manage/orderdetail/{id}"}
	)
	public String showorderdetial(@PathVariable("id") String id, Model model) {
    	model.addAttribute("orders", productService.getAllOrder());
    	model.addAttribute("orderdetails", productService.getAllOrderDetails(id));
    	
		return "/manage/orderdetail";
	}
    
    @PostMapping(
			path = {"updatebuyway"}
	)
	public String updatebuyway(@RequestParam("id") String id ,	@RequestParam("buyway") String buyway) {
    	
		productService.updateOrder(id, buyway);
    	
		return "redirect:/pages/orderbuyway.page";
	}
   
    @PostMapping(
			path = {"deleteOrder"}
	)
	public String deleteOrder(@RequestParam("id") String id) {
		
		productService.deleteOrder(id);
    	
		return "redirect:/manage/order.page";
	}
    
    
    @PostMapping("/Admin/addP")
    public String saveProduct(@RequestParam("file") MultipartFile file,
    		@RequestParam("pname") String name,
    		@RequestParam("price") Double price,
    		@RequestParam("desc") String desc,
    		@RequestParam("quantity") int quantity,
    		@RequestParam("special") String special,
    		@RequestParam("categories") String categories)
    {
    
    	productService.saveProductToDB(file ,name, desc,quantity, price,special);
    	return "redirect:/Admin/product";
    }
    
    @PostMapping("/pages/addP")
    public String saveProductp(@RequestParam("file") MultipartFile file,
    		@RequestParam("pname") String name,
    		@RequestParam("price") Double price,
    		@RequestParam("desc") String desc,
    		@RequestParam("quantity") int quantity,
    		@RequestParam("special") String special
    		)
    {	
    		productService.saveProductToDB(file ,name ,desc ,quantity, price,special);
        	return "redirect:/pages/pcrud.page";
    }
    @PostMapping("/pages/updatePic")
    public String updateProductp(@RequestParam("id") Long id,
    		@RequestParam("newfile") MultipartFile file)
    {
    	productService.updateImageToProduct(file ,id);
    	return "redirect:/manage/product.page";
    }
    
//  產品2
  @PostMapping("/pages/addP2")
  public String saveProductp2(@RequestParam("file") MultipartFile file,
  		@RequestParam("pname") String name,
  		@RequestParam("price") Double price,
  		@RequestParam("desc") String desc,
  		@RequestParam("quantity") int quantity,	
  		@RequestParam("special") String special
  		)
  {
  	productService.saveProduct2ToDB(file, name, desc,quantity, price,special);
  	return "redirect:/pages/pcrud.page";
  }
  @GetMapping("/manage/product2.page")
 	public String prodcut2(Model model)
 	{
     	
 		List<Product2> products = productService.getAllProduct2();
 		model.addAttribute("products", products);
 		return "manage/product2";
 	}
  @PostMapping("/manage/changedetil2")
  public String changeProduct2detil(@RequestParam("id") Long id,
  		@RequestParam("newPname") String name,
  		@RequestParam("newDescription") String description,
  		@RequestParam("newPrice") Double price,
  		@RequestParam("newQuantity") int quantity,
  		@RequestParam("newSpecial") String special,
  		@RequestParam("newDiscount") int discount)
  {
  	productService.chageProduct2detil(id, name ,description ,price ,quantity ,special ,discount);
  	return "redirect:/manage/product2.page";
  }
  @GetMapping("/manage/deleteProd2/{id}")
  public String deleteProduct2(@PathVariable("id") Long id)
  {
  	productService.deleteProductById2(id);
  	return "redirect:/manage/product2.page";
  }
  @PostMapping("/pages/updatePic2")
  public String updateProductp2(@RequestParam("id") Long id,
  		@RequestParam("newfile") MultipartFile file)
  {
  	productService.updateImageToProduct2(file ,id);
  	return "redirect:/manage/product2.page";
  }
  
  
//    產品3
    @PostMapping("/pages/addP3")
    public String saveProductp3(@RequestParam("file") MultipartFile file,
    		@RequestParam("pname") String name,
    		@RequestParam("price") Double price,
    		@RequestParam("desc") String desc,
    		@RequestParam("quantity") int quantity,	
    		@RequestParam("special") String special
    		)
    {
    	productService.saveProduct3ToDB(file, name, desc,quantity, price,special);
    	return "redirect:/pages/pcrud.page";
    }
    @GetMapping("/manage/product3.page")
   	public String prodcut3(Model model)
   	{
       	
   		List<Product3> products = productService.getAllProduct3();
   		model.addAttribute("products", products);
   		return "manage/product3";
   	}
    @PostMapping("/manage/changedetil3")
    public String changeProduct3detil(@RequestParam("id") Long id,
    		@RequestParam("newPname") String name,
    		@RequestParam("newDescription") String description,
    		@RequestParam("newPrice") Double price,
    		@RequestParam("newQuantity") int quantity,
    		@RequestParam("newSpecial") String special,
    		@RequestParam("newDiscount") int discount)
    {
    	productService.chageProduct3detil(id, name ,description ,price ,quantity ,special ,discount);
    	return "redirect:/manage/product3.page";
    }
    @GetMapping("/manage/deleteProd3/{id}")
    public String deleteProduct3(@PathVariable("id") Long id)
    {
    	productService.deleteProductById3(id);
    	return "redirect:/manage/product3.page";
    }
    @PostMapping("/pages/updatePic3")
    public String updateProductp3(@RequestParam("id") Long id,
    		@RequestParam("newfile") MultipartFile file)
    {
    	productService.updateImageToProduct3(file ,id);
    	return "redirect:/manage/product3.page";
    }
    
    
//    產品4
    @PostMapping("/pages/addP4")
    public String saveProductp4(@RequestParam("file") MultipartFile file,
    		@RequestParam("pname") String name,
    		@RequestParam("price") Double price,
    		@RequestParam("desc") String desc,
    		@RequestParam("quantity") int quantity,	
    		@RequestParam("special") String special
    		)
    {
    	productService.saveProduct4ToDB(file, name, desc,quantity, price,special);
    	return "redirect:/pages/pcrud.page";
    }
    @GetMapping("/manage/product4.page")
   	public String prodcut4(Model model)
   	{
       	
   		List<Product4> products = productService.getAllProduct4();
   		model.addAttribute("products", products);
   		return "manage/product4";
   	}
    @PostMapping("/manage/changedetil4")
    public String changeProduct4detil(@RequestParam("id") Long id,
    		@RequestParam("newPname") String name,
    		@RequestParam("newDescription") String description,
    		@RequestParam("newPrice") Double price,
    		@RequestParam("newQuantity") int quantity,
    		@RequestParam("newSpecial") String special,
    		@RequestParam("newDiscount") int discount)
    {
    	productService.chageProduct4detil(id, name ,description ,price ,quantity ,special ,discount);
    	return "redirect:/manage/product4.page";
    }
    @GetMapping("/manage/deleteProd4/{id}")
    public String deleteProduct4(@PathVariable("id") Long id)
    {
    	productService.deleteProductById4(id);
    	return "redirect:/manage/product4.page";
    }
    @PostMapping("/pages/updatePic4")
    public String updateProductp4(@RequestParam("id") Long id,
    		@RequestParam("newfile") MultipartFile file)
    {
    	productService.updateImageToProduct4(file ,id);
    	return "redirect:/manage/product4.page";
    }
    
    
//    產品5
    
    @PostMapping("/pages/addP5")
    public String saveProductp5(@RequestParam("file") MultipartFile file,
    		@RequestParam("pname") String name,
    		@RequestParam("price") Double price,
    		@RequestParam("desc") String desc,
    		@RequestParam("quantity") int quantity,	
    		@RequestParam("special") String special
    		)
    {
    	productService.saveProduct5ToDB(file, name, desc,quantity, price,special);
    	return "redirect:/pages/pcrud.page";
    }
    @GetMapping("/manage/product5.page")
   	public String prodcut5(Model model)
   	{
       	
   		List<Product5> products = productService.getAllProduct5();
   		model.addAttribute("products", products);
   		return "manage/product5";
   	}
    @PostMapping("/manage/changedetil5")
    public String changeProduct5detil(@RequestParam("id") Long id,
    		@RequestParam("newPname") String name,
    		@RequestParam("newDescription") String description,
    		@RequestParam("newPrice") Double price,
    		@RequestParam("newQuantity") int quantity,
    		@RequestParam("newSpecial") String special,
    		@RequestParam("newDiscount") int discount)
    {
    	productService.chageProduct5detil(id, name ,description ,price ,quantity ,special ,discount);
    	return "redirect:/manage/product5.page";
    }
    @GetMapping("/manage/deleteProd5/{id}")
    public String deleteProduct5(@PathVariable("id") Long id)
    {
    	productService.deleteProductById5(id);
    	return "redirect:/manage/product5.page";
    }
    @PostMapping("/pages/updatePic5")
    public String updateProductp5(@RequestParam("id") Long id,
    		@RequestParam("newfile") MultipartFile file)
    {
    	productService.updateImageToProduct5(file ,id);
    	return "redirect:/manage/product5.page";
    }

    
    
    
    @GetMapping("/Admin/deleteProd/{id}")
    public String deleteProduct(@PathVariable("id") Long id)
    {
    	productService.deleteProductById(id);
    	return "redirect:/Admin/index";
    }
    @GetMapping("/manage/deleteProd/{id}")
    public String deleteProduct1(@PathVariable("id") Long id)
    {
    	productService.deleteProductById(id);
    	return "redirect:/manage/product.page";
    }
   
    
    // 修改產品
    @PostMapping("/manage/changedetil")
    public String changeProductdetil(@RequestParam("id") Long id,	
    		@RequestParam("newPname") String name,
    		@RequestParam("newDescription") String description,
    		@RequestParam("newPrice") Double price,
    		@RequestParam("newQuantity") int quantity,
    		@RequestParam("newSpecial") String special,
    		@RequestParam("newDiscount") int discount)
    {
    	productService.chageProductdetil(id, name ,description ,price ,quantity ,special ,discount);
    	return "redirect:/manage/product.page";
    }
    
    
    //優惠管理
    @PostMapping("/manage/addPreferential")
    public String savePreferential(@RequestParam("file") MultipartFile file,
    		@RequestParam("ename") String name,
    		@RequestParam("code") String code,
    		@RequestParam("off") Integer off,
    		@RequestParam("desc") String desc,
    		@DateTimeFormat(iso = ISO.DATE)Date sdate ,
    		@DateTimeFormat(iso = ISO.DATE )Date edate
    		) throws InterruptedException
    {	
    		productService.savePreferential(file ,name,code ,desc ,sdate,off, edate);
    		Thread.sleep(400);
        	return "redirect:/pages/Preferentialadd.page";
    }
    @PostMapping("updatePreferential")
    public String updatePreferential(@RequestParam("id") Integer id,
    		@RequestParam("file") MultipartFile file,
    		@RequestParam("ename") String name,
    		@RequestParam("code") String code,
    		@RequestParam("off") Integer off,
    		@RequestParam("desc") String desc,
    		@DateTimeFormat(iso = ISO.DATE)Date sdate ,
    		@DateTimeFormat(iso = ISO.DATE )Date edate)
    {
    	productService.chagePreferential(id,file ,name,code ,desc ,sdate,off, edate);
    	return "redirect:/manage/Preferential.page";
    }
    
    @GetMapping("/manage/deletePreferential/{id}")
    public String deletePreferential(@PathVariable("id") Integer id)
    {
    	productService.deletePreferential(id);
    	return "redirect:/manage/Preferential.page";
    }
    
    
    
    @PostMapping("/Admin/changeName")
    public String changePname(@RequestParam("id") Long id,
    		@RequestParam("newPname") String name)
    {
    	productService.chageProductName(id, name);
    	return "redirect:/Admin/index";
    }
    @PostMapping("/Admin/changeDescription")
    public String changeDescription(@RequestParam("id") Long id ,
    		@RequestParam("newDescription") String description)
    {
    	productService.changeProductDescription(id, description);
    	return "redirect:/Admin/index";
    }
    
    @PostMapping("/Admin/changePrice")
    public String changePrice(@RequestParam("id") Long id ,
    		@RequestParam("newPrice") Double price)
    {
    	
    	productService.changeProductPrice(id, price);
    	return "redirect:/Admin/index";
    }
    @PostMapping("/Admin/changeQuantity")
    public String changeQuantity(@RequestParam("id") Long id ,
    		@RequestParam("newQuantity") int quantity)
    {
    	
    	productService.changeProductQuantity(id, quantity);
    	return "redirect:/Admin/index";
    }
    
    @PostMapping("/Admin/changeDiscount")
    public String changeDiscount(@RequestParam("id") Long id ,
    		@RequestParam("newDiscount") int discount)
    {
    	
    	productService.changeProductDiscount(id, discount);
    	return "redirect:/Admin/index";
    }
    
    @PostMapping("/Admin/addCategory")
    public String addCategory(@ModelAttribute Category category , Model model) {
    	productService.saveCategory(category);
    	return "redirect:/Admin/product";
    }
//    @PostMapping("/Admin/addPictureToP")
//    public String addImageToProduct(@RequestParam("file") MultipartFile file,
//    		@RequestParam("product_id") Long id ) {
//    	productService.addImageToProduct(file,id);
//    	return "redirect:/Admin/product";
//    }
    @PostMapping("/Admin/addDiscountToP")
    public String addDiscountToproduct(@RequestParam("product_id") Long id ,
    		@RequestParam("discount") int discount) {
    	productService.saveProductDicount(id,discount);
    	return "redirect:/pages/pcrud2.page";
    }

 
}

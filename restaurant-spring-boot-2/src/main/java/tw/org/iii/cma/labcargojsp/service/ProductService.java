package tw.org.iii.cma.labcargojsp.service;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.http.HttpClient.Redirect;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import net.coobird.thumbnailator.Thumbnails;
import tw.org.iii.cma.labcargojsp.Dao.CategoryRepository;
import tw.org.iii.cma.labcargojsp.Dao.MemberRepository;
import tw.org.iii.cma.labcargojsp.Dao.OderdetailRepository;
import tw.org.iii.cma.labcargojsp.Dao.OdertRepository;
import tw.org.iii.cma.labcargojsp.Dao.PreferentialRepository;
import tw.org.iii.cma.labcargojsp.Dao.ProductRepositry;
import tw.org.iii.cma.labcargojsp.Dao.ProductRepositry2;
import tw.org.iii.cma.labcargojsp.Dao.ProductRepositry3;
import tw.org.iii.cma.labcargojsp.Dao.ProductRepositry4;
import tw.org.iii.cma.labcargojsp.Dao.ProductRepositry5;
import tw.org.iii.cma.labcargojsp.Dao.ShoppingCartRepository;
import tw.org.iii.cma.labcargojsp.domain.CartItem;
import tw.org.iii.cma.labcargojsp.domain.Category;
import tw.org.iii.cma.labcargojsp.domain.Coupon;
import tw.org.iii.cma.labcargojsp.domain.CouponBean;
import tw.org.iii.cma.labcargojsp.domain.Orderdetail;
import tw.org.iii.cma.labcargojsp.domain.Ordert;
import tw.org.iii.cma.labcargojsp.domain.Product;
import tw.org.iii.cma.labcargojsp.domain.Product2;
import tw.org.iii.cma.labcargojsp.domain.Product3;
import tw.org.iii.cma.labcargojsp.domain.Product4;
import tw.org.iii.cma.labcargojsp.domain.Product5;
import tw.org.iii.cma.labcargojsp.domain.ShoppingCart;

@Service
public class ProductService {
	@Autowired
	private ProductRepositry productRepo;
	@Autowired
	private ProductRepositry2 productRepo2;
	@Autowired
	private ProductRepositry3 productRepo3;
	@Autowired
	private ProductRepositry4 productRepo4;
	@Autowired
	private ProductRepositry5 productRepo5;
	@Autowired
	private OdertRepository OrdertRepo;
	@Autowired
	private OderdetailRepository OrderdetailRepo;
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private PreferentialRepository PreferentialRepo;
	@Autowired
	private MemberRepository MemberRepo;

	public void saveProductToDB(MultipartFile file, String name, String description, int quantity, Double price,
			String special) {
		Product p = new Product();
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		if (fileName.contains("..")) {
			System.out.println("not a valid file");
		}
		try {
			p.setImage(resizeImageForUse(Base64.getEncoder().encodeToString(file.getBytes()), 400, 400));
		} catch (IOException e) {
			e.printStackTrace();
		}
		p.setDescription(description);
		p.setName(name);
		p.setPrice(price);
		p.setSpecial(special);
		p.setQuantity(quantity);
		Coupon c = new Coupon();
		c.setDiscount(0);
		p.setDiscount(c);
		productRepo.save(p);
	}

	public void updateImageToProduct(MultipartFile file, Long id) {

		Product p = productRepo.findById(id).get();
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		if (fileName.contains("..")) {
			System.out.println("not a valid file");
		}
		try {
			p.setImage(resizeImageForUse(Base64.getEncoder().encodeToString(file.getBytes()), 400, 400));
		} catch (IOException e) {
			e.printStackTrace();
		}
		productRepo.save(p);

	}

	public void updateImageToProduct2(MultipartFile file, Long id) {

		Product2 p = productRepo2.findById(id).get();
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		if (fileName.contains("..")) {
			System.out.println("not a valid file");
		}
		try {
			p.setImage(resizeImageForUse(Base64.getEncoder().encodeToString(file.getBytes()), 400, 400));
		} catch (IOException e) {
			e.printStackTrace();
		}
		productRepo2.save(p);

	}

	public void updateImageToProduct3(MultipartFile file, Long id) {

		Product3 p = productRepo3.findById(id).get();
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		if (fileName.contains("..")) {
			System.out.println("not a valid file");
		}
		try {
			p.setImage(resizeImageForUse(Base64.getEncoder().encodeToString(file.getBytes()), 400, 400));
		} catch (IOException e) {
			e.printStackTrace();
		}
		productRepo3.save(p);

	}

	public void updateImageToProduct4(MultipartFile file, Long id) {

		Product4 p = productRepo4.findById(id).get();
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		if (fileName.contains("..")) {
			System.out.println("not a valid file");
		}
		try {
			p.setImage(resizeImageForUse(Base64.getEncoder().encodeToString(file.getBytes()), 400, 400));
		} catch (IOException e) {
			e.printStackTrace();
		}
		productRepo4.save(p);

	}

	public void updateImageToProduct5(MultipartFile file, Long id) {

		Product5 p = productRepo5.findById(id).get();
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		if (fileName.contains("..")) {
			System.out.println("not a valid file");
		}
		try {
			p.setImage(resizeImageForUse(Base64.getEncoder().encodeToString(file.getBytes()), 400, 400));
		} catch (IOException e) {
			e.printStackTrace();
		}
		productRepo5.save(p);

	}

	public void saveProduct2ToDB(MultipartFile file, String name, String description, int quantity, Double price,
			String special) {
		Product2 p = new Product2();
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		if (fileName.contains("..")) {
			System.out.println("not a valid file");
		}
		try {
			p.setImage(resizeImageForUse(Base64.getEncoder().encodeToString(file.getBytes()), 400, 400));
		} catch (IOException e) {
			e.printStackTrace();
		}
		p.setDescription(description);

		p.setName(name);
		p.setPrice(price);
		p.setSpecial(special);
		p.setQuantity(quantity);
		Coupon c = new Coupon();
		c.setDiscount(0);
		p.setDiscount(c);
		productRepo2.save(p);
	}

	public void saveProduct3ToDB(MultipartFile file, String name, String description, int quantity, Double price,
			String special) {
		Product3 p = new Product3();
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		if (fileName.contains("..")) {
			System.out.println("not a valid file");
		}
		try {
			p.setImage(resizeImageForUse(Base64.getEncoder().encodeToString(file.getBytes()), 400, 400));
		} catch (IOException e) {
			e.printStackTrace();
		}
		p.setDescription(description);

		p.setName(name);
		p.setPrice(price);
		p.setSpecial(special);
		p.setQuantity(quantity);
		Coupon c = new Coupon();
		c.setDiscount(0);
		p.setDiscount(c);
		productRepo3.save(p);
	}

	public void saveProduct4ToDB(MultipartFile file, String name, String description, int quantity, Double price,
			String special) {
		Product4 p = new Product4();
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		if (fileName.contains("..")) {
			System.out.println("not a valid file");
		}
		try {
			p.setImage(resizeImageForUse(Base64.getEncoder().encodeToString(file.getBytes()), 400, 400));
		} catch (IOException e) {
			e.printStackTrace();
		}
		p.setDescription(description);

		p.setName(name);
		p.setPrice(price);
		p.setSpecial(special);
		p.setQuantity(quantity);
		Coupon c = new Coupon();
		c.setDiscount(0);
		p.setDiscount(c);
		productRepo4.save(p);
	}

	public void saveProduct5ToDB(MultipartFile file, String name, String description, int quantity, Double price,
			String special) {
		Product5 p = new Product5();
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		if (fileName.contains("..")) {
			System.out.println("not a valid file");
		}
		try {
			p.setImage(resizeImageForUse(Base64.getEncoder().encodeToString(file.getBytes()), 400, 400));
		} catch (IOException e) {
			e.printStackTrace();
		}
		p.setDescription(description);

		p.setName(name);
		p.setPrice(price);
		p.setSpecial(special);
		p.setQuantity(quantity);
		Coupon c = new Coupon();
		c.setDiscount(0);
		p.setDiscount(c);
		productRepo5.save(p);
	}

	public void savePreferential(MultipartFile file, String name, String code, String desc, Date sdate, Integer off,
			Date edate) {
		CouponBean p = new CouponBean();
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		if (fileName.contains("..")) {
			System.out.println("not a valid file");
		}
		try {
			p.setPic(resizeImageForUse(Base64.getEncoder().encodeToString(file.getBytes()), 400, 400));
		} catch (IOException e) {
			e.printStackTrace();
		}
		p.setDescription(desc);
		p.setEventname(name);
		p.setOff(off);
		p.setCode(code);
		p.setStartdata(sdate);
		p.setEnddata(edate);

		PreferentialRepo.save(p);
	}

	public List<Product> getAllProduct() {
		return productRepo.findAll();
	}

	public List<Product2> getAllProduct2() {
		return productRepo2.findAll();
	}

	public List<Product3> getAllProduct3() {
		return productRepo3.findAll();
	}

	public List<Product4> getAllProduct4() {
		return productRepo4.findAll();
	}

	public List<Product5> getAllProduct5() {
		return productRepo5.findAll();
	}

	public void deleteProductById(Long id) {
		productRepo.deleteById(id);
	}

	public void deleteProductById2(Long id) {
		productRepo2.deleteById(id);
	}

	public void deleteProductById3(Long id) {
		productRepo3.deleteById(id);
	}

	public void deleteProductById4(Long id) {
		productRepo4.deleteById(id);
	}

	public void deleteProductById5(Long id) {
		productRepo5.deleteById(id);
	}

	public void chageProductdetil(Long id, String name, String description, Double price, int quantity, String special,
			int discount) {
		Product p = new Product();
		p = productRepo.findById(id).get();
		p.setDescription(description);
		p.setName(name);
		p.setPrice(price);
		p.setQuantity(quantity);
		p.setSpecial(special);
		if (p.getDiscount() != null) {
			Coupon c = new Coupon();
			c.setDiscount(discount);
			p.setDiscount(c);
		}
		productRepo.save(p);
	}

	public void chageProduct2detil(Long id, String name, String description, Double price, int quantity, String special,
			int discount) {
		Product2 p = new Product2();
		p = productRepo2.findById(id).get();
		p.setDescription(description);
		p.setName(name);
		p.setPrice(price);
		p.setQuantity(quantity);
		p.setSpecial(special);
		if (p.getDiscount() != null) {
			Coupon c = new Coupon();
			c.setDiscount(discount);
			p.setDiscount(c);
		}
		productRepo2.save(p);
	}

	public void chageProduct3detil(Long id, String name, String description, Double price, int quantity, String special,
			int discount) {
		Product3 p = new Product3();
		p = productRepo3.findById(id).get();
		p.setDescription(description);
		p.setName(name);
		p.setPrice(price);
		p.setQuantity(quantity);
		p.setSpecial(special);
		if (p.getDiscount() != null) {
			Coupon c = new Coupon();
			c.setDiscount(discount);
			p.setDiscount(c);
		}
		productRepo3.save(p);
	}

	public void chageProduct4detil(Long id, String name, String description, Double price, int quantity, String special,
			int discount) {
		Product4 p = new Product4();
		p = productRepo4.findById(id).get();
		p.setDescription(description);
		p.setName(name);
		p.setPrice(price);
		p.setQuantity(quantity);
		p.setSpecial(special);
		if (p.getDiscount() != null) {
			Coupon c = new Coupon();
			c.setDiscount(discount);
			p.setDiscount(c);
		}
		productRepo4.save(p);
	}

	public void chageProduct5detil(Long id, String name, String description, Double price, int quantity, String special,
			int discount) {
		Product5 p = new Product5();
		p = productRepo5.findById(id).get();
		p.setDescription(description);
		p.setName(name);
		p.setPrice(price);
		p.setQuantity(quantity);
		p.setSpecial(special);
		if (p.getDiscount() != null) {
			Coupon c = new Coupon();
			c.setDiscount(discount);
			p.setDiscount(c);
		}
		productRepo5.save(p);
	}

	public void chagePreferential(Integer id, MultipartFile file, String name, String code, String desc, Date sdate,
			Integer off, Date edate) {
		CouponBean p = new CouponBean();
		p = PreferentialRepo.findById(id).get();
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		if (fileName.contains("..")) {
			System.out.println("not a valid file");
		}
		try {
			p.setPic(resizeImageForUse(Base64.getEncoder().encodeToString(file.getBytes()), 400, 400));
		} catch (IOException e) {
			e.printStackTrace();
		}
		p.setDescription(desc);
		p.setEventname(name);
		p.setOff(off);
		p.setCode(code);
		p.setStartdata(sdate);
		p.setEnddata(edate);

		PreferentialRepo.save(p);
	}

	public void chageProductName(Long id, String name) {
		Product p = new Product();
		p = productRepo.findById(id).get();
		p.setName(name);
		productRepo.save(p);
	}

	public void changeProductDescription(Long id, String description) {
		Product p = new Product();
		p = productRepo.findById(id).get();
		p.setDescription(description);
		productRepo.save(p);
	}

	public void changeProductPrice(Long id, Double price) {
		Product p = new Product();
		p = productRepo.findById(id).get();
		p.setPrice(price);
		productRepo.save(p);
	}

	public Category saveCategory(Category category) {
		return categoryRepository.save(category);
	}

	public List<Category> getAllCategories() {

		return categoryRepository.findAll();
	}

//	public void addImageToProduct(MultipartFile file, Long id) {
//
//		Product p = productRepo.findById(id).get();
//		Carousel carousel = new Carousel();
//		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
//		if (fileName.contains("..")) {
//			System.out.println("not a valid file");
//		}
//		try {
//			carousel.setImage(resizeImageForUse(Base64.getEncoder().encodeToString(file.getBytes()), 400, 400));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		p.getCarousel().add(carousel);
//		productRepo.save(p);
//
//	}

	public void changeProductQuantity(Long id, int quantity) {
		Product p = new Product();
		p = productRepo.findById(id).get();
		p.setQuantity(quantity);
		productRepo.save(p);

	}

	public void saveProductDicount(Long id, int discount) {
		Product p = new Product();
		p = productRepo.findById(id).get();
		if (p.getDiscount() == null) {
			Coupon c = new Coupon();
			c.setDiscount(discount);
			p.setDiscount(c);
		}

		else {
			p.getDiscount().setDiscount(discount);
		}
		productRepo.save(p);

	}

	public void changeProductDiscount(Long id, int discount) {
		Product p = new Product();
		p = productRepo.findById(id).get();
		p.getDiscount().setDiscount(discount);
		productRepo.save(p);

	}

	// No API
	public String resizeImageForUse(String src, int width, int height) {
		BufferedImage image = base64ToBufferedImage(src);
		try {
			image = resizeImage(image, width, height);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			return bufferedImageTobase64(image);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	private BufferedImage resizeImage(BufferedImage image, int width, int height) throws IOException {
		ByteArrayOutputStream outputstream = new ByteArrayOutputStream();
		try {
			Thumbnails.of(image).size(width, height).outputFormat("JPEG").outputQuality(1).toOutputStream(outputstream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		byte[] data = outputstream.toByteArray();
		ByteArrayInputStream inputStream = new ByteArrayInputStream(data);
		return ImageIO.read(inputStream);
	}

	private BufferedImage base64ToBufferedImage(String base64Img) {
		BufferedImage image = null;
		byte[] decodedBytes = Base64.getDecoder().decode(base64Img);

		try {
			image = ImageIO.read(new ByteArrayInputStream(decodedBytes));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return image;
	}

	private String bufferedImageTobase64(BufferedImage image) throws UnsupportedEncodingException {
		final ByteArrayOutputStream out = new ByteArrayOutputStream();
		try {
			ImageIO.write(image, "JPEG", Base64.getEncoder().wrap(out));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return out.toString(StandardCharsets.ISO_8859_1.name());
	}

	public Product getProductById(Long id) {

		return productRepo.findById(id).get();
	}

	public Product2 getProductById2(Long id) {

		return productRepo2.findById(id).get();
	}

	public Product3 getProductById3(Long id) {

		return productRepo3.findById(id).get();
	}

	public Product4 getProductById4(Long id) {

		return productRepo4.findById(id).get();
	}

	public Product5 getProductById5(Long id) {

		return productRepo5.findById(id).get();
	}

	// 訂單顯示
	public List<Ordert> getAllOrder() {
		return OrdertRepo.findAll();
	}

	// 訂單明細
	public List<Orderdetail> getAllOrderDetails(String id) {
		List<Orderdetail> orderdetail = OrderdetailRepo.findByOrderno1(id);
		return orderdetail;
	}

	// 訂單狀態
	public Ordert updateOrder(String id, String buyway) {
		Ordert od = new Ordert();
		od = OrdertRepo.findById(id).get();
		od.setOrdered(buyway);
		return OrdertRepo.save(od);
	}

	// 訂單刪除
	public void deleteOrder(String id) {

		OrdertRepo.deleteById(id);
		OrderdetailRepo.deleteByOrderno1(id);

	}

	// 網路訂餐訂單數
	public long salescount() {
		return OrdertRepo.countbyordered();
	}

	// 外送訂餐訂單數
	public long deliverycount() {
		return OrdertRepo.countbyordered2();
	}

	// 優惠活動
	public List<CouponBean> getAlloffer() {
		return PreferentialRepo.findAll();
	}

	// 優惠刪除
	public void deletePreferential(Integer id) {
		PreferentialRepo.deleteById(id);
	}

	// 優惠詳細內容
	public CouponBean getnewsById(Integer id) {

		return PreferentialRepo.findById(id).get();
	}

	// 會員數量
	public long countmember() {
		return MemberRepo.count();
	}

	// 產品數量
	public long count() {
		return productRepo.count();
	}

	public long count2() {
		return productRepo2.count();
	}

	public long count3() {
		return productRepo3.count();
	}

	public long count4() {
		return productRepo4.count();
	}

	public long count5() {
		return productRepo5.count();
	}

	// 訂單數量
	public long orders() {
		return OrdertRepo.count();
	}

	// 訂單總金額
	public int ordermoney() {
		return OrdertRepo.countordermoney();
	}

	// 網路訂單總金額
	public int countsorder() {
		return OrdertRepo.countsorder();
	}

	// 外送訂單總金額
	public int countdorder() {
		return OrdertRepo.countdorder();
	}

	// 訂單分析

	public long countsalesmoney() {
		return OrdertRepo.countsalesmoney();
	}

	public long countsalesmoney2() {
		return OrdertRepo.countsalesmoney2();
	}

	public long countsalesmoney3() {
		return OrdertRepo.countsalesmoney3();
	}

	public long countdeliverymoney() {
		return OrdertRepo.countdeliverymoney();
	}

	public long countdeliverymoney2() {
		return OrdertRepo.countdeliverymoney2();
	}

	public long countdeliverymoney3() {
		return OrdertRepo.countdeliverymoney3();
	}

}

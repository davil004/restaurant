package tw.org.iii.cma.labcargojsp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.transaction.annotation.Transactional;

@Entity
@Table(name = "ORDERDETAIL")
public class Orderdetail {
	@Id
	@Column(name = "OD_NO")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer odno;
	
	@Column(name = "ORDER_NO")
	private String orderno1;

	@Column(name = "FOOD_ID")
	private Integer foodid;

	@Column(name = "FOOD_COUNT")
	private Integer foodcount;

	@Column(name = "FOOD_MONEY")
	private Integer foodmoney;

	@Column(name = "FOOD_NAME")
	private String foodname;

	@Override
	public String toString() {
		return "OrderDetailBean [odno=" + odno + ", orderno1=" + orderno1 + ", foodid=" + foodid + ", foodcount="
				+ foodcount + ", foodmoney=" + foodmoney + ", foodname=" + foodname + "]";
	}

	public Integer getOdno() {
		return odno;
	}

	public void setOdno(Integer odno) {
		this.odno = odno;
	}

	public String getOrderno1() {
		return orderno1;
	}

	public void setOrderno1(String orderno1) {
		this.orderno1 = orderno1;
	}

	public Integer getFoodid() {
		return foodid;
	}

	public void setFoodid(Integer foodid) {
		this.foodid = foodid;
	}

	public Integer getFoodcount() {
		return foodcount;
	}

	public void setFoodcount(Integer foodcount) {
		this.foodcount = foodcount;
	}

	public Integer getFoodmoney() {
		return foodmoney;
	}

	public void setFoodmoney(Integer foodmoney) {
		this.foodmoney = foodmoney;
	}

	public String getFoodname() {
		return foodname;
	}

	public void setFoodname(String foodname) {
		this.foodname = foodname;
	}
}

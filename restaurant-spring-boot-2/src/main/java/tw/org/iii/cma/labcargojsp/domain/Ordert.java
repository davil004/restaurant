package tw.org.iii.cma.labcargojsp.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.transaction.annotation.Transactional;

@Entity
@Table(name = "ORDERT")
public class Ordert {
	@Id
	@Column(name = "ORDER_NOO")
	private String orderno;
	
	@Column(name = "ORDER_USER" )
	private String orderuser;
	
	@Column(name = "ORDER_PHONE")
	private String orderphone;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "ORDER_DATE")
	private Date date;
	
	@Column(name = "ORDERED")
	private String ordered;
	
	@Column(name = "ORDER_ADD")
	private String orderadd;
	
	@Column(name = "ORDER_COUNT")
	private int ordercount;
	
	@Column(name = "ORDER_MONEY")
	private int ordermoney;
	
	@Column(name = "ORDER_TYPE")
	private String ordertype;
	
	@Column(name = "ORDER_WAY")
	private String orderway;
	
	@Transient
	private int totalPrice;
	
	@Override
	public String toString() {
		return "OrderBean [orderno=" + orderno + ", orderuser=" + orderuser + ", orderphone=" + orderphone
				+ ", orderadd=" + orderadd + ", ordercount=" + ordercount + ", ordermoney=" + ordermoney
				+ ", ordertype=" + ordertype + ", orderway=" + orderway + "]";
	}

	public int getTotalPrice() {
		return totalPrice;		
	}



	public String getOrderno() {
		return orderno;
	}

	public void setOrderno(String orderno) {
		this.orderno = orderno;
	}

	public String getOrderuser() {
		return orderuser;
	}

	public void setOrderuser(String orderuser) {
		this.orderuser = orderuser;
	}

	public String getOrderphone() {
		return orderphone;
	}

	public void setOrderphone(String orderphone) {
		this.orderphone = orderphone;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getOrderadd() {
		return orderadd;
	}

	public void setOrderadd(String orderadd) {
		this.orderadd = orderadd;
	}

	public String getOrdered() {
		return ordered;
	}

	public void setOrdered(String ordered) {
		this.ordered = ordered;
	}

	public Integer getOrdercount() {
		return ordercount;
	}

	public void setOrdercount(Integer ordercount) {
		this.ordercount = ordercount;
	}

	public Integer getOrdermoney() {
		return ordermoney;
	}

	public void setOrdermoney(Integer ordermoney) {
		this.ordermoney = ordermoney;
	}

	public String getOrdertype() {
		return ordertype;
	}

	public void setOrdertype(String ordertype) {
		this.ordertype = ordertype;
	}

	public String getOrderway() {
		return orderway;
	}

	public void setOrderway(String orderway) {
		this.orderway = orderway;
	}
	
}

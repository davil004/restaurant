package tw.org.iii.cma.labcargojsp.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "shoppingcart")
public class ShoppingCart {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Temporal(TemporalType.DATE)
	private Date date;

	@Transient
	private Double totalPrice;
	@Transient
	private int itemsNumber;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<CartItem> items = new HashSet<CartItem>();

	public ShoppingCart() {
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<CartItem2> items2 = new HashSet<CartItem2>();

	public void ShoppingCart2() {
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<CartItem3> items3 = new HashSet<CartItem3>();

	public void ShoppingCart3() {
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<CartItem4> items4 = new HashSet<CartItem4>();

	public void ShoppingCart4() {
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<CartItem5> items5 = new HashSet<CartItem5>();

	public void ShoppingCart5() {
	}

	private String sessionToken;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getTotalPrice() {
		Double sum = 0.0;
		Double sum2 = 0.0;
		Double sum3 = 0.0;
		Double sum4 = 0.0;
		Double sum5 = 0.0;

		for (CartItem item : this.items) {
			sum = sum + item.getProduct().getPrice() * item.getQuantity()
					* ((float) (100 - item.getProduct().getDiscount().getDiscount()) / 100);

		}
		for (CartItem2 item2 : this.items2) {
			sum2 = sum2 + item2.getProduct2().getPrice() * item2.getQuantity()
					* ((float) (100 - item2.getProduct2().getDiscount().getDiscount()) / 100);
		}
		for (CartItem3 item3 : this.items3) {
			sum3 = sum3 + item3.getProduct3().getPrice() * item3.getQuantity()
					* ((float) (100 - item3.getProduct3().getDiscount().getDiscount()) / 100);
		}
		for (CartItem4 item4 : this.items4) {
			sum4 = sum4 + item4.getProduct4().getPrice() * item4.getQuantity()
					* ((float) (100 - item4.getProduct4().getDiscount().getDiscount()) / 100);
		}
		for (CartItem5 item5 : this.items5) {
			sum5 = sum5 + item5.getProduct5().getPrice() * item5.getQuantity()
					* ((float) (100 - item5.getProduct5().getDiscount().getDiscount()) / 100);
		}
		Double TotalPrice=sum + sum2 + sum3 + sum4 + sum5;
		return (double) Math.round(TotalPrice) ;
		
	}

	public int getItemsNumber() {

//	    int INB = 0 + this.items.size() + this.items2.size() + this.items3.size()+ this.items4.size()+ this.items5.size();		
//		this.items.size() + this.items2.size() + this.items3.size()+ this.items4.size()+ this.items5.size()
		return this.items.size() + this.items2.size() + this.items3.size() + this.items4.size() + this.items5.size();
	}

	public Set<CartItem> getItems() {
		return items;
	}

	public Set<CartItem2> getItems2() {
		return items2;
	}

	public Set<CartItem3> getItems3() {
		return items3;
	}

	public Set<CartItem4> getItems4() {
		return items4;
	}

	public Set<CartItem5> getItems5() {
		return items5;
	}

	public void setItems5(Set<CartItem5> items5) {
		this.items5 = items5;
	}

	public void setItems4(Set<CartItem4> items4) {
		this.items4 = items4;
	}

	public void setItems3(Set<CartItem3> items3) {
		this.items3 = items3;
	}

	public void setItems2(Set<CartItem2> items2) {
		this.items2 = items2;
	}

	public void setItems(Set<CartItem> items) {
		this.items = items;
	}

	public String getSessionToken() {
		return sessionToken;
	}

	public void setSessionToken(String sessionToken) {
		this.sessionToken = sessionToken;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((items == null) ? 0 : items.hashCode());
		result = prime * result + ((sessionToken == null) ? 0 : sessionToken.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ShoppingCart other = (ShoppingCart) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (items == null) {
			if (other.items != null)
				return false;
		} else if (!items.equals(other.items))
			return false;
		if (sessionToken == null) {
			if (other.sessionToken != null)
				return false;
		} else if (!sessionToken.equals(other.sessionToken))
			return false;
		return true;
	}

}

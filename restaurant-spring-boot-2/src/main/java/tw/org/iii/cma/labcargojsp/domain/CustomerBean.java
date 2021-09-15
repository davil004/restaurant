package tw.org.iii.cma.labcargojsp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
//		會員資料設定檔
@Entity
@Table(name = "CUSTOMER")
public class CustomerBean {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CUSTID")
	private Long custid;
	
	@Column(name = "PASSWORD")
	private byte[] password;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "BIRTH")
	private java.util.Date birth;
	
	@Override
	public String toString() {
		return "model.CustomerBean ["+ custid+ ","+ email+ ","+ birth+ "]";
	}
	public Long getCustid() {
		return custid;
	}
	public void setCustid(Long custid) {
		this.custid = custid;
	}
	public byte[] getPassword() {
		return password;
	}
	public void setPassword(byte[] password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public java.util.Date getBirth() {
		return birth;
	}
	public void setBirth(java.util.Date birth) {
		this.birth = birth;
	}
}

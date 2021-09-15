package tw.org.iii.cma.labcargojsp.domain;

import java.text.DateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "OFFEROFF")
public class CouponBean {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "coupon_no")
	private Integer couponno;
	@Column(name = "event_name")
	private String eventname;
	@Column(name = "code")
	private String code;
	@Column(name = "off")
	private Integer off;
	@Column(name = "description" ,columnDefinition = "LONGTEXT")
	private String description;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8" ,pattern = "yyyy-MM-dd")
	@Column(name = "start_date" )
	public Date startdate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8" ,pattern = "yyyy-MM-dd")
	@Column(name = "end_date")
	public Date enddate;
	@Column(columnDefinition = "MEDIUMBLOB")
	private String pic;

	@Override
	public String toString() {
		return "CouponBean [couponno=" + couponno + ", eventname=" + eventname + ", code=" + code + ", off=" + off
				+ ", startdata=" + startdate + ", enddata=" + enddate + ", pic=" + pic + "]";
	}

	public Integer getCouponno() {
		return couponno;
	}

	public void setCouponno(Integer couponno) {
		this.couponno = couponno;
	}

	public String getEventname() {
		return eventname;
	}

	public void setEventname(String eventname) {
		this.eventname = eventname;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getOff() {
		return off;
	}

	public void setOff(Integer off) {
		this.off = off;
	}

	public java.util.Date getStartdata() {
		return startdate;
	}

	public void setStartdata(java.util.Date startdata) {
		this.startdate = startdata;
	}

	public java.util.Date getEnddata() {
		return enddate;
	}

	public void setEnddata(java.util.Date enddata) {
		this.enddate = enddata;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}

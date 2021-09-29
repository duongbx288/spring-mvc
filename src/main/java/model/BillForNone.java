package model;

import java.sql.Date;

public class BillForNone {
	public BillForNone() {
	}

	public BillForNone(int billfornone_id, String fullname, Date datebill, String address, int total) {
		this.billfornone_id = billfornone_id;
		this.fullname = fullname;
		this.datebill = datebill;
		this.address = address;
		this.total = total;
	}

	private int billfornone_id;
	private String fullname;
	private Date datebill;
	private String address;
	private int total;

	public int getBillfornone_id() {
		return billfornone_id;
	}

	public void setBillfornone_id(int billfornone_id) {
		this.billfornone_id = billfornone_id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public Date getDatebill() {
		return datebill;
	}

	public void setDatebill(Date datebill) {
		this.datebill = datebill;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
}

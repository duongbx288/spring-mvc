package model;

import java.sql.Date;
import java.util.List;

public class Bill {
	public Bill() {
	}

	public Bill(int bill_id, String username, Date dateBill, String address) {
		this.bill_id = bill_id;
		this.username = username;
		this.dateBill = dateBill;
		this.address = address;
		this.billDetail = service.BillDetailService.getDetail(bill_id);
	}

	private int bill_id;
	private String username;
	private Date dateBill;
	private String address;
	private List<BillDetail> billDetail;

	public List<BillDetail> getBillDetail() {
		return billDetail;
	}

	public void setBillDetail(List<BillDetail> billDetail) {
		this.billDetail = billDetail;
	}

	public int getBill_id() {
		return bill_id;
	}

	public void setBill_id(int bill_id) {
		this.bill_id = bill_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getDateBill() {
		return dateBill;
	}

	public void setDateBill(Date dateBill) {
		this.dateBill = dateBill;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}

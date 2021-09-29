package model;

public class BillDetail {
	public BillDetail() {

	}
	
	public BillDetail(int billDetail_id, int bill_id, String watch_id, int quantity) {
		this.billDetail_id = billDetail_id;
		this.bill_id = bill_id;
		this.watch_id = watch_id;
		this.quantity = quantity;
	}

	private int billDetail_id;
	private int bill_id;
	private String watch_id;
	private int quantity;

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getBillDetail_id() {
		return billDetail_id;
	}

	public void setBillDetail_id(int billDetail_id) {
		this.billDetail_id = billDetail_id;
	}

	public int getBill_id() {
		return bill_id;
	}

	public void setBill_id(int bill_id) {
		this.bill_id = bill_id;
	}

	public String getWatch_id() {
		return watch_id;
	}

	public void setWatch_id(String watch_id) {
		this.watch_id = watch_id;
	}

}

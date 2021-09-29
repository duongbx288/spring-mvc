package model;

import java.util.List;

public class Cart {
	private Watch product;
	private int quantity;
	
	public Cart() {
		super();
	}

	public Cart(Watch product, int quantity) {
		super();
		this.product = product;
		this.quantity = quantity;
	}
	
	public Watch getProduct() {
		return product;
	}
	public void setProduct(Watch product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public static Cart getCartByWatchId(List<Cart> listCart, String watchId) {
		for (Cart cart : listCart) {
			if (cart.getProduct().getWatch_id().equals(watchId)) {
				return cart;
			}
		}
		return null;
	}
	
}

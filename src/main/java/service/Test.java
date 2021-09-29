package service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import model.Admin;
import model.Cart;
import model.User;
import model.Watch;
import model.BillForNone;

public class Test {
	public static void main(String[] args) {
		AdminService a = new AdminService();
		UserService u = new UserService();
		WatchesService w = new WatchesService();
		BillService b = new BillService();
		BillForNoneService bfn = new BillForNoneService();
		ChartService c = new ChartService();
		a.getAllAdmin();
		u.getAllUser();
		w.delWatch("K1");
		bfn.getBillAll();
		List<Integer> bill = w.typeWatch();
		System.out.printf("\n");
		int h = bill.size();
		for (int f = 0; f < h; f++) {
			System.out.print(bill.get(f));
		}
		List<String> hello = w.typeName();
		w.changeWatch("G4", "gsgd", 12, "ads", 12);
		//bfn.addBillForNone("Tran Khanh Du", "Ha Noi, Ha Nam Ninh");
		//w.getAllWatch();
		//w.getWatchPrice(10000, 1000000);
		//w.getWatchById("A1");
		//w.getWatchByName("Casio B31");
		//w.getWatchNew();
		//w.getWatchGenre("Chronograph watch");
		//w.getWatchFeatured();
		//b.getBillAll();
		//System.out.print(cart.getQuantity());
	}
}

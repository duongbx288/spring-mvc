package service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.BillForNone;

public class BillForNoneService {
	private Connection connection = JDBCConnection.getJDBCConnection();
	String sql;
	ResultSet rs;
	
	public List<BillForNone> getBillAll() {
		List<BillForNone> bill = new ArrayList<BillForNone>();
		sql = "SELECT * FROM billfornone";
		try {
			Statement statement = connection.createStatement();
			rs = statement.executeQuery(sql);
			while (rs.next()) {
				int bill_id = rs.getInt("billfornone_id");
				String username = rs.getString("fullname");
				Date dateBill = rs.getDate("date_bill");
				String address = rs.getString("address");
				int total = rs.getInt("total");
				System.out.printf(bill_id + " " + username + " " + address);
				BillForNone a = new BillForNone(bill_id, username, dateBill, address, total);
				bill.add(a);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return bill;

	}
	
	public void addBillForNone(String fullname, String address, float total) {
		String billId = null;
		Connection connection = JDBCConnection.getJDBCConnection();
		long millis = System.currentTimeMillis();
		Date date = new Date(millis);
		sql = "select count(billfornone_id) cout from billfornone";
		try {
			Statement statement = connection.createStatement();
			rs = statement.executeQuery(sql);
			while (rs.next()) {
				billId = String.valueOf(rs.getInt("cout") + 1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		sql = "INSERT INTO billfornone (billfornone_id, fullname, date_bill, address, total) " + "VALUES ('" + billId + "','" + fullname + "','"
				+ date.toString() + "','" + address + "','" + total +"')";
		try {
			Statement st = connection.createStatement();
			st.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

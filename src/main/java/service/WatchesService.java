package service;

import model.Watch;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class WatchesService {
	private String sql;
	ResultSet rs;

	List<Watch> getWatch() {
		Connection connection = JDBCConnection.getJDBCConnection();
		List<Watch> watch = new ArrayList<Watch>();
		try {
			Statement statement = connection.createStatement();
			rs = statement.executeQuery(sql);
			while (rs.next()) {
				String watch_id = rs.getString("watch_id");
				String watch_name = rs.getString("watch_name");
				int price = rs.getInt("price");
				String publisher = rs.getString("publisher");
				int year = rs.getInt("year");
				String color = rs.getString("color");
				String intro = rs.getString("intro");
				String image = rs.getString("image");
				System.out
						.println(watch_id + watch_name + " " + price + " " + publisher + year + color + intro + image);
				Watch a = new Watch(watch_id, watch_name, price, publisher, year, color, intro, image);
				watch.add(a);

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
		return watch;
	}

	// trả về tất cả đồng hồ
	public List<Watch> getAllWatch() {
		sql = "SELECT * FROM product limit 50";
		return getWatch();
	}

	// trả về thể loại sách
	public List<Watch> getWatchGenre(String type) {
		sql = "select p.watch_id, watch_name, price, color, publisher, year, intro, image\r\n"
				+ "from product p, typew t, typewatch tp\r\n" + "where t.type_name = '" + type
				+ "' and t.type_id = tp.type_id and p.watch_id = tp.watch_id";
		return getWatch();
	}

	// trả về đh có giá từ price1 dến price2
	public List<Watch> getWatchPrice(int price1, int price2) {
		sql = "SELECT * FROM product WHERE price between " + price1 + " and " + price2;
		return getWatch();
	}

	// trả về đh mới
	public List<Watch> getWatchNew() {
		sql = "SELECT *\r\n" + "from product\r\n" + "where year(curdate()) - 1 = year";
		return getWatch();
	}

	// trả về dh ngẫu nhiên
	public List<Watch> getWatchFeatured() {
		sql = "SELECT * \r\n" + "FROM product\r\n" + "ORDER BY RAND() LIMIT 30";
		return getWatch();
	}

	public Watch getWatchById(String watchid) {
		sql = "SELECT * FROM product WHERE watch_id = '" + watchid + "'";
		Connection connection = JDBCConnection.getJDBCConnection();
		Watch watch = new Watch();
		try {
			Statement statement = connection.createStatement();
			rs = statement.executeQuery(sql);
			while (rs.next()) {
				watch.setWatch_id(rs.getString("watch_id"));
				watch.setWatch_name(rs.getString("watch_name"));
				watch.setPrice(rs.getInt("price"));
				watch.setPublisher(rs.getString("publisher"));
				watch.setYear(rs.getInt("year"));
				watch.setColor(rs.getString("color"));
				watch.setIntro(rs.getString("intro"));
				watch.setImage(rs.getString("image"));
				System.out.println(rs.getString("watch_id"));
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
		return watch;
	}

	// tìm kiếm dh theo tên
	public List<Watch> getWatchByName(String name) {
		sql = "SELECT * \r\n" + "FROM product w\r\n" + "where w.watch_name like '%" + name + "%'";
		return getWatch();
	}

	// public void rateService(String bookId, int number) {
	// sql = "update book \r\n" + "set rate = (rateturn * rate + " + number
	// + ") / (rateturn + 1), rateturn = rateturn + 1\r\n" + "where book_id = '" +
	// bookId + "'";
	// Connection connection = JDBCConnection.getJDBCConnection();

	// try {
	// Statement st = connection.createStatement();
	// st.execute(sql);
	// } catch (SQLException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// } finally {
	// if (connection != null)
	// try {
	// connection.close();
	// } catch (SQLException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }
	// }

	public boolean checkWatch(String watchId) {
		List<Watch> watch = getAllWatch();
		for (Watch i : watch) {
			if (i.getWatch_id().equals(watchId))
				return true;
		}
		return false;
	}

	public void addWatch(String watchId, String watchName, String NXS, int nam, int price, String color, String image,
			String content) {
		sql = "INSERT INTO product (watch_id, watch_name, price, publisher, year, color, intro, image)\r\n"
				+ " VALUES ('" + watchId + "','" + watchName + "', '" + price + "', '" + NXS + "', '" + nam + "', '"
				+ color + "', '" + content + "', '" + image + "')";
		Connection connection = JDBCConnection.getJDBCConnection();

		try {
			Statement st = connection.createStatement();
			st.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (connection != null)
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}

	public void delWatch(String watchId) {
		sql = "DELETE FROM product WHERE watch_id = " + "'" + watchId + "'";
		Connection connection = JDBCConnection.getJDBCConnection();
		try {
			Statement st = connection.createStatement();
			st.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (connection != null)
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}

	public void changeWatch(String watchId, String watch_name, int price, String publisher, int year) {
		sql = "UPDATE product SET `watch_name` = '" + watch_name + "', `price` = '" + price + "', `publisher` = '"
				+ publisher + "', `year` = '" + year + "' WHERE `watch_id`= '" + watchId + "'";
		Connection connection = JDBCConnection.getJDBCConnection();
		try {
			Statement st = connection.createStatement();
			st.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (connection != null)
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}

	public List<Integer> typeWatch() {
		sql = "SELECT COUNT(watch_id) w, type_id FROM typewatch GROUP BY type_id";
		List<Integer> typenum = new ArrayList<Integer>();
		Connection connection = JDBCConnection.getJDBCConnection();
		try {
			Statement statement = connection.createStatement();
			rs = statement.executeQuery(sql);
			while (rs.next()) {
				int num = rs.getInt("w");
				typenum.add(num);
				System.out.printf("\n" + num);
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
		return typenum;
	}

	public List<String> typeName() {
		List<String> typename = new ArrayList<String>();
		sql = "SELECT type_name w FROM typew";
		Connection connection = JDBCConnection.getJDBCConnection();
		try {
			Statement statement = connection.createStatement();
			rs = statement.executeQuery(sql);
			while (rs.next()) {
				String num = rs.getString("w");
				typename.add(num);
				System.out.printf("\n" + num);
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
		return typename;

	}
}

package model;

import java.util.List;

public class Watch {
	public Watch() {
	}

	public Watch(String watch_id, String watch_name, int price, String publisher, int year,
			String color, String intro, String image) {
		this.watch_id = watch_id;
		this.watch_name = watch_name;
		//this.genre = service.GenreSevice.getAll(book_id);
		this.price = price;
		this.publisher = publisher;
		this.year = year;
		this.color = color;
		this.intro = intro;
		this.image = image;
		//this.author = service.AuthorService.getBookAuthor(book_id);
	}

	private String watch_id;
	private String watch_name;
	//private List<Genre> genre;
	private int price;
	private String publisher;
	private int year;
	private String color;
	private String intro;
	private String image;
	//private List<Author> author;

	public String getWatch_id() {
		return watch_id;
	}

	public void setWatch_id(String watch_id) {
		this.watch_id = watch_id;
	}

	public String getWatch_name() {
		return watch_name;
	}

	public void setWatch_name(String watch_name) {
		this.watch_name = watch_name;
	}

	//public List<Genre> getGenre() {
	//	return genre;
	//}

	//public void setGenre(List<Genre> genre) {
	//	this.genre = genre;
	//}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}


	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public String getImage() {
		return "/resources/user/images/" +  image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	
	//public List<Author> getAuthor() {
	//	return author;
	//}

	//public void setAuthor(List<Author> author) {
	//	this.author = author;
	//}

}
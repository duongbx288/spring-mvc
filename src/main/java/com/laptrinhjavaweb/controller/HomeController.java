
package com.laptrinhjavaweb.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.itextpdf.text.DocumentException;

import model.Admin;
import model.User;
import model.Cart;
import model.Comment;
import model.Watch;
import service.AdminService;
import service.BillForNoneService;
import service.BillService;
import service.CommentService;
import service.UserService;
import service.WatchesService;
import service.PDFTest;

@Controller
public class HomeController {

	AdminService adminService = new AdminService();
	UserService userService = new UserService();
	WatchesService watchesService = new WatchesService();
	BillService billService = new BillService();
	BillForNoneService bfnService = new BillForNoneService();
	PDFTest PDF = new PDFTest();
	CommentService commentService = new CommentService();

	// Homepage
	@RequestMapping(value = "/trang-chu", method = RequestMethod.GET)
	public ModelAndView homePage() {
		ModelAndView mav = new ModelAndView("user/index");
		List<Watch> allWatch = new WatchesService().getAllWatch();
		List<Watch> listBestWatch = new WatchesService().getWatchNew();
		List<Watch> listRandomWatch = new WatchesService().getWatchFeatured();
		mav.addObject("watch", allWatch);
		mav.addObject("bestSellerProduct", listBestWatch);
		mav.addObject("randomProduct", listRandomWatch);
		return mav;
	}

	// Dong ho moi hoac dong ho dac biet
	@RequestMapping(value = "/type", method = RequestMethod.GET)
	public ModelAndView typePage(String type) {
		ModelAndView mav = new ModelAndView("user/type");
		if (type.equals("new")) {
			List<Watch> typeProduct = new WatchesService().getWatchNew();
			mav.addObject("typeProduct", typeProduct);
			return mav;
		} else if (type.equals("featured")) {
			List<Watch> typeProduct = new WatchesService().getWatchFeatured();
			mav.addObject("typeProduct", typeProduct);
			return mav;
		} else {
			List<Watch> typeProduct = new WatchesService().getWatchFeatured();
			mav.addObject("typeProduct", typeProduct);
			return mav;
		}
	}

	// Tim kiem san pham theo ten
	@RequestMapping(value = "/searchByName", method = RequestMethod.GET)
	public ModelAndView searchByName(@RequestParam("watchName") String watchName) {
		ModelAndView mav = new ModelAndView("user/delivery");
		List<Watch> listWatchSearch = new WatchesService().getWatchByName(watchName);
		mav.addObject("allProduct", listWatchSearch);
		return mav;
	}

	// Chon san pham theo loai
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ModelAndView searchPage(String type) {
		ModelAndView mav = new ModelAndView("user/watchSearch");
		List<Watch> listTypeWatch = new WatchesService().getWatchGenre(type);
		mav.addObject("genreProduct", listTypeWatch);
		return mav;
	}

	// Tat ca san pham
	@RequestMapping(value = "/delivery", method = RequestMethod.GET)
	public ModelAndView deliveryPage() {
		ModelAndView mav = new ModelAndView("user/delivery");
		List<Watch> allWatch = new WatchesService().getAllWatch();
		int size = allWatch.size();
		mav.addObject("allProduct", allWatch);
		mav.addObject("size", size);
		return mav;
	}

	// Thong tin san pham
	@RequestMapping(value = "/preview", method = RequestMethod.GET)
	public ModelAndView preview(String watchId) {
		ModelAndView mav = new ModelAndView("user/preview");
		Watch watchSelected = new WatchesService().getWatchById(watchId);
		List<Comment> listComment = new CommentService().getCmtByWatchId(watchId);
		mav.addObject("watchSelected", watchSelected);
		mav.addObject("listComment", listComment);
		return mav;
	}
	
	// Binh luan
	@RequestMapping(value = "/comment")
	public ModelAndView comment(@RequestParam(value = "watchId") String watchId,
			@RequestParam(value = "comment") String comment, @RequestParam(value = "username") String username) {
		if (username != "") {
			commentService.addCommentByWatchId(watchId, comment, username);
		}
		ModelAndView mav = preview(watchId);
		return mav;
	}

	// Lien he
	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public ModelAndView contactPage() {
		ModelAndView mav = new ModelAndView("user/contact");
		return mav;
	}

	// Thong tin cua hang
	@RequestMapping(value = "/about", method = RequestMethod.GET)
	public ModelAndView aboutPage() {
		ModelAndView mav = new ModelAndView("user/about");
		return mav;
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView homeePage() {
		ModelAndView mav = new ModelAndView("user/home");
		return mav;
	}

	// Tin tuc
	@RequestMapping(value = "/news", method = RequestMethod.GET)
	public ModelAndView newsPage() {
		ModelAndView mav = new ModelAndView("user/news");
		return mav;
	}

	// Login and signup
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView loginPage() {
		ModelAndView mav = new ModelAndView("user/login");
		return mav;
	}

	@RequestMapping(value = "/logined")
	public ModelAndView logined(@RequestParam("username") String username, @RequestParam("password") String password,
			HttpSession session) {
		if (adminService.checkLoginAdmin(username, password)) {
			ModelAndView mav = new ModelAndView("admin/index");
			Admin adminLogged = new Admin(username, password);
			List<User> allUser = new UserService().getAllUser();
			mav.addObject("users", allUser);
			session.setAttribute("logged", adminLogged);
			return mav;
		} else if (userService.checkLoginUser(username, password)) {
			ModelAndView mav = homePage();
			User userLogged = new User(username, password, "", "", "", "", null);
			session.setAttribute("logged", userLogged);
			return mav;
		} else {
			ModelAndView mav = new ModelAndView("user/login");
			return mav;
		}
	}

	@RequestMapping(value = "/logout")
	public ModelAndView logined(HttpSession session) {
		session.removeAttribute("logged");
		ModelAndView mav = homePage();
		return mav;
	}

	@RequestMapping(value = "/signUp")
	public ModelAndView signUp(@RequestParam("username") String username, @RequestParam("password") String password) {
		if (adminService.checkLoginAdmin(username, password)) {
			ModelAndView mav = new ModelAndView("admin/index");
			return mav;
		} else if (userService.checkLoginUser(username, password)) {
			ModelAndView mav = new ModelAndView("user/homepage");
			return mav;
		} else {
			ModelAndView mav = new ModelAndView("user/login");
			return mav;
		}
	}

	// Gio hang
	@RequestMapping(value = "/cart", method = RequestMethod.GET)
	public ModelAndView cartPage() {
		ModelAndView mav = new ModelAndView("user/cart");
		return mav;
	}

	@RequestMapping(value = "/deleteCart")
	public @ResponseBody String deleteCart(@RequestParam(value = "watchId") String watchId, HttpSession session) {
		List<Cart> listCart = (List<Cart>) session.getAttribute("listCart");
		listCart.remove(Cart.getCartByWatchId(listCart, watchId));
		String json = "";
		if (listCart != null & listCart.size() > 0) {
			json = new Gson().toJson(listCart);
			System.out.println(json);
			return json;
		}
		return "user/cart";
	}

	@RequestMapping(value = "/addCart")
	public ModelAndView addCart(@RequestParam("watchId") String watchId, @RequestParam("number") String quantity,
			HttpSession session) {
		int quantityInt = Integer.parseInt(quantity);
		Watch watch = new WatchesService().getWatchById(watchId);
		List<Cart> listCart = (List<Cart>) session.getAttribute("listCart");
		if (listCart == null) {
			listCart = new ArrayList<>();
			Cart cart = new Cart(watch, quantityInt);
			listCart.add(cart);
		} else {
			boolean check = false;
			for (Cart cart : listCart) {
				if (cart.getProduct().getWatch_id().equals(watchId)) {
					check = true;
					cart.setQuantity(cart.getQuantity() + quantityInt);
					break;
				}
			}
			if (!check) {
				Cart cart = new Cart(watch, quantityInt);
				listCart.add(cart);
			}
		}
		session.setAttribute("listCart", listCart);

		session.setAttribute("totalAmount", calTotalAmount(listCart));
		return preview(watchId);
	}

	public float calTotalAmount(List<Cart> listCart) {
		float totalAmount = 0;

		for (Cart cart : listCart) {
			totalAmount += cart.getProduct().getPrice() * cart.getQuantity();
		}
		return totalAmount;
	}

	@RequestMapping(value = "/thanhtoan")
	public ModelAndView thanhtoan(@RequestParam(value = "username") String username, HttpSession session)
			throws DocumentException, IOException {
		List<Cart> listCart = (List<Cart>) session.getAttribute("listCart");
		User user = new UserService().getUserById(username);
		String fullname = user.getFullname();
		String address = user.getAddress();
		String phone = user.getPhone();
		PDF.createPDF(listCart, fullname, address, phone);
		if (username != "") {
			billService.addBill(username, address, listCart);
		}
		ModelAndView mav = cartPage();
		return mav;
	}

	@RequestMapping(value = "/cartfornone", method = RequestMethod.GET)
	public ModelAndView cartfornonePage() {
		ModelAndView mav = new ModelAndView("user/cartfornone");
		return mav;
	}

	//Thanh toan cho nguoi khong dang nhap
	@RequestMapping(value = "/thanhtoan1")
	public ModelAndView thanhtoan1(@RequestParam(value = "fullname") String fullname,
			@RequestParam(value = "address") String address, @RequestParam(value = "phone") String phone,
			HttpSession session) throws DocumentException, IOException {
		List<Cart> listCart = (List<Cart>) session.getAttribute("listCart");
		int total = PDF.calTotal(listCart);
		PDF.createPDF(listCart, fullname, address, phone);
		if ((fullname != "") && (address != " ")) {
			bfnService.addBillForNone(fullname, address, total);
		}

		ModelAndView mav = cartfornonePage();
		return mav;
	}
}
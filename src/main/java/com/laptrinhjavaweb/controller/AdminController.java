package com.laptrinhjavaweb.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import model.Bill;
import model.BillDetail;
import model.Watch;
import model.User;
import service.BillService;
import service.ChartService;
import service.WatchesService;
import service.UserService;

@Controller
public class AdminController {
	WatchesService watchesService = new WatchesService();
	UserService userService = new UserService();
	BillService billService = new BillService();
	ChartService c = new ChartService();

	@RequestMapping(value = "/adminPage", method = RequestMethod.GET)
	public ModelAndView adminPage() {
		ModelAndView mav = new ModelAndView("admin/index");
		List<User> allUser = new UserService().getAllUser();
		mav.addObject("users", allUser);
		return mav;
	}

	@RequestMapping(value = "/dataWatch", method = RequestMethod.GET)
	public ModelAndView dataWatchPage() {
		ModelAndView mav = new ModelAndView("admin/tables");
		List<Watch> allWatch = new WatchesService().getAllWatch();
		mav.addObject("allWatch", allWatch);
		return mav;
	}

	@RequestMapping(value = "/dataBill", method = RequestMethod.GET)
	public ModelAndView dataBookBill() {
		ModelAndView mav = new ModelAndView("admin/tables2");
		List<User> listUser = new UserService().getAllUser();
		List<BillDetail> listBillDetail = new ArrayList<BillDetail>();
		for (User user : listUser) {
			List<BillDetail> list = new BillService().getBillByUsername(user.getUsername());
			listBillDetail.addAll(list);
		}
		mav.addObject("listBillDetail", listBillDetail);
		return mav;
	}

	@RequestMapping(value = "/addWatch", method = RequestMethod.GET)
	public ModelAndView addWatchPage() {
		ModelAndView mav = new ModelAndView("admin/addWatch");
		return mav;
	}

	@RequestMapping(value = "/addWatchFill", method = RequestMethod.GET)
	public ModelAndView addBookFill(@RequestParam(value = "watchId") String watchId,
			@RequestParam(value = "watchName") String watchName, @RequestParam(value = "NXS") String NXS,
			@RequestParam(value = "year") int year, @RequestParam(value = "price") int price,
			@RequestParam(value = "color") String color, @RequestParam(value = "image") String image,
			@RequestParam(value = "content") String content) {
		if (watchesService.checkWatch(watchId)) {
			return addWatchPage();
		} else {
			watchesService.addWatch(watchId, watchName, NXS, year, price, color, image, content);
			ModelAndView mav = addWatchPage();
			return mav;
		}
	}

	@RequestMapping(value = "/delWatch", method = RequestMethod.GET)
	public ModelAndView delWatchPage() {
		ModelAndView mav = new ModelAndView("admin/watchdel");
		List<Watch> allWatch = new WatchesService().getAllWatch();
		mav.addObject("allWatch", allWatch);
		return mav;
	}

	@RequestMapping(value = "/deleteWatch", method = RequestMethod.GET)
	public ModelAndView deleteWatch(@RequestParam(value = "watchId") String watchId) {
		watchesService.delWatch(watchId);
		ModelAndView mav = delWatchPage();
		return mav;
	}

	
	@RequestMapping(value = "/chaWatch", method = RequestMethod.GET)
	public ModelAndView chaWatchPage() {
		ModelAndView mav = new ModelAndView("admin/watchchange");
		List<Watch> allWatch = new WatchesService().getAllWatch();
		mav.addObject("allWatch", allWatch);
		return mav;
	}
	
	@RequestMapping(value = "/changeWatch", method = RequestMethod.GET)
	public ModelAndView deleteWatch(@RequestParam(value = "watchId") String watchId,
			@RequestParam(value = "watch_name") String watch_name, @RequestParam(value = "price") int price,
			@RequestParam(value="publisher") String publisher, @RequestParam(value="year") int year) {
		watchesService.changeWatch(watchId, watch_name, price, publisher, year);
		ModelAndView mav = chaWatchPage();
		return mav;
	}

	@RequestMapping(value = "/charts", method = RequestMethod.GET)
	public ModelAndView chartsPage() {
		ModelAndView mav = new ModelAndView("admin/charts");
		return mav;
	}

	@RequestMapping(value = "/input", method = RequestMethod.GET)
	public ModelAndView inputPage() {
		ModelAndView mav = new ModelAndView("admin/input");
		List<User> allUser = new UserService().getAllUser();
		mav.addObject("users", allUser);
		return mav;
	}

	@RequestMapping(value = "/bill", method = RequestMethod.GET)
	public ModelAndView billPage() {
		ModelAndView mav = new ModelAndView("admin/tables3");
		List<Bill> allBill = new BillService().getBillAll();
		mav.addObject("allBill", allBill);
		return mav;
	}

	@RequestMapping(value = "/statistic", method = RequestMethod.GET)
	public ModelAndView statisticPage() {
		ModelAndView mav = new ModelAndView("admin/static1");
		List<Integer> bill = billService.getBillaccordingtoDate();
		List<Integer> numOfProduct = watchesService.typeWatch();
		List<String> type = watchesService.typeName();
		mav.addObject("numOfProduct", numOfProduct);
		mav.addObject("type", type);
		c.DrawChart(bill);
		return mav;
	}
}

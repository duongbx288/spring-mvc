package service;

import java.io.*;
import java.sql.Date;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class ChartService {

	public static void main(String[] args) throws Exception {
		Instant now = Instant.now();
		Instant yesterday = now.minus(1, ChronoUnit.DAYS);
		System.out.println(now);
		System.out.println(yesterday);
		DefaultCategoryDataset line_chart_dataset = new DefaultCategoryDataset();
		line_chart_dataset.addValue(15, "schools", "1970");
		line_chart_dataset.addValue(30, "schools", "1980");
		line_chart_dataset.addValue(60, "schools", "1990");
		line_chart_dataset.addValue(120, "schools", "2000");
		line_chart_dataset.addValue(240, "schools", "2010");
		line_chart_dataset.addValue(300, "schools", "2014");

		JFreeChart lineChartObject = ChartFactory.createLineChart("Schools Vs Years", "Year", "Schools Count",
				line_chart_dataset, PlotOrientation.VERTICAL, true, true, false);

		int width = 640; /* Width of the image */
		int height = 480; /* Height of the image */
		File lineChart = new File("LineChart.jpeg");
		ChartUtils.saveChartAsJPEG(lineChart, lineChartObject, width, height);
	}

	public void DrawChart(List<Integer> bill) {
		DefaultCategoryDataset line_chart_dataset = new DefaultCategoryDataset();
		int b = bill.size();
		long millis = System.currentTimeMillis();
		Date date = new Date(millis);
		for (int i = 0; i < b; i++) {
			date = new Date(System.currentTimeMillis() - i * 24 * 60 * 60 * 1000);
			line_chart_dataset.addValue(bill.get(i), "bill", date.toString());
		}

		JFreeChart lineChartObject = ChartFactory.createLineChart("Thống kê hóa đơn thanh toán trong 1 tuần", "Ngày", "Số hóa đơn",
				line_chart_dataset, PlotOrientation.VERTICAL, true, true, false);
		
		int width = 800; /* Width of the image */
		int height = 600; /* Height of the image */
		File lineChart = new File("F:\\Workspace Eclipse EE\\spring-mvc\\src\\main\\webapp\\resources\\user\\images\\LineChart.jpeg");
		try {
			ChartUtils.saveChartAsJPEG(lineChart, lineChartObject, width, height);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
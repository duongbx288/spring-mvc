package service;

import java.io.FileNotFoundException;

import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.util.List;

import javax.swing.text.StyleConstants.FontConstants;
import model.Cart;

public class PDFTest {

	public void createPDF(List<Cart> cart, String Name, String address, String phone)
			throws DocumentException, IOException {
		if (cart != null) {
			Document document = new Document();
			try {
				BaseFont bf = BaseFont.createFont("f:/Workspace Eclipse EE/spring-mvc/ArialUnicodeMS.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
				PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("Hoa don.pdf"));
				document.open();
				Paragraph br = new Paragraph("\r\n");
				Paragraph in = new Paragraph("----------------------------------------------------------------------------------------------------------------------------------");
				Paragraph p = new Paragraph(
						"    Cửa hàng Watch's Store\r\n" + "    Địa chỉ: XYZ, AB Hà Nội, Việt Nam\r\n",
						new Font(bf, 12, Font.BOLD));

				Paragraph p1 = new Paragraph("                              Hóa đơn thanh toán\r\n\r\n",
						new Font(bf, 20, Font.BOLD));
				Paragraph p2 = new Paragraph("Họ và tên: " + Name + "\r\n",new Font(bf, 12));
				Paragraph p3 = new Paragraph("Số điện thoại: " + phone + "\r\n",new Font(bf, 12));
				Paragraph p4 = new Paragraph("Địa chỉ: " + address + "\r\n",new Font(bf, 12));
				document.add(p);
				document.add(in);
				document.add(p1);
				document.add(in);
				document.add(p2);
				document.add(p3);
				document.add(p4);

				document.add(new Paragraph("\r\n"));

				PdfPTable table = new PdfPTable(3); // 3 columns.
				table.setWidthPercentage(100); // Width 100%
				table.setSpacingBefore(10f); // Space before table
				table.setSpacingAfter(10f); // Space after table

				// Set Column widths
				float[] columnWidths = { 1f, 1f, 1f };
				table.setWidths(columnWidths);

				PdfPCell cell1 = new PdfPCell(new Paragraph("Product Name:"));
				cell1.setBorderColor(BaseColor.GRAY);
				cell1.setPaddingLeft(10);
				cell1.setFixedHeight(30);
				cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);

				PdfPCell cell2 = new PdfPCell(new Paragraph("Quantity"));
				cell2.setBorderColor(BaseColor.GRAY);
				cell2.setPaddingLeft(10);
				cell1.setFixedHeight(30);
				cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);

				PdfPCell cell3 = new PdfPCell(new Paragraph("Price"));
				cell3.setBorderColor(BaseColor.GRAY);
				cell3.setPaddingLeft(10);
				cell1.setFixedHeight(30);
				cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);

				table.addCell(cell1);
				table.addCell(cell2);
				table.addCell(cell3);

				int totalAmount = 0;

				for (Cart giohang : cart) {

					table.addCell(giohang.getProduct().getWatch_name());
					table.addCell(String.valueOf(giohang.getQuantity()));
					table.addCell(String.valueOf(giohang.getProduct().getPrice() * giohang.getQuantity()));
					totalAmount += giohang.getProduct().getPrice() * giohang.getQuantity();
				}

				String hello = String.valueOf(totalAmount);

				document.add(table);
				Paragraph p5 = new Paragraph("Tổng tiền cần thanh toán là:     " + hello,new Font(bf, 12));
				Paragraph p6 = new Paragraph("     Chữ ký người mua                                                        Chữ ký người giao hàng",new Font(bf,12));
				document.add(in);
				document.add(p5);
				document.add(in);
				document.add(br);
				document.add(br);
				document.add(p6);
				document.close();
				writer.close();

			} catch (DocumentException e) {
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}

	}
	
	public int calTotal(List<Cart> cart) {
		int Total = 0;
		for (Cart giohang : cart) {
			
			Total += giohang.getProduct().getPrice() * giohang.getQuantity();
		}
		
		return Total;
	}

}

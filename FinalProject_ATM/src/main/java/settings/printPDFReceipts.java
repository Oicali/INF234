/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package settings;

import com.itextpdf.io.font.FontConstants;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.property.TextAlignment;
import java.io.*;
import java.net.*;
import java.awt.Desktop;
import Main.*;

public class printPDFReceipts extends frames {
   
    public static final String path1 = "C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\PDF\\ATMReceipt.pdf";

    public static void printReceipt(String transactionType, String accountType, String refNo, String date, double amount, double balance) throws FileNotFoundException, MalformedURLException, IOException {
        PdfWriter writer = new PdfWriter(path1);
        PdfDocument pdf = new PdfDocument(writer);
        PageSize ps = new PageSize(350, 400);
        Document document = new Document(pdf, ps);

        PdfFont font = PdfFontFactory.createFont(FontConstants.TIMES_ROMAN);

        document.add(new Paragraph("BANK OF INCLUSIVE TRANSACTIONS").setTextAlignment(TextAlignment.CENTER).setFontSize(15).setFont(font).setBold());
        
        Paragraph p = new Paragraph("------------------------------------------------------").setFont(font).setTextAlignment(TextAlignment.CENTER).setBold().setFontSize(15);
        p.setFixedPosition(-25, 314, 400);
        document.add(p);
        
        Paragraph p1 = new Paragraph("Username : ").setFont(font).setTextAlignment(TextAlignment.LEFT);
        p1.setFixedPosition(43, 290, 100);
        document.add(p1);
        
        // Display name
        Paragraph p2 = new Paragraph(account.user.getName()).setFont(font).setTextAlignment(TextAlignment.RIGHT);
        p2.setFixedPosition(157, 290, 150);
        document.add(p2);
        
        Paragraph p3 = new Paragraph("Account number : ").setFont(font).setTextAlignment(TextAlignment.LEFT);
        p3.setFixedPosition(43, 265, 100);
        document.add(p3);
        
        // Display censored UID
        Paragraph p4 = new Paragraph(viewBalance.maskedStr1 + viewBalance.str2).setFont(font).setTextAlignment(TextAlignment.RIGHT);
        p4.setFixedPosition(157, 265, 150);
        document.add(p4);
        
        Paragraph p5 = new Paragraph("Transaction type : ").setFont(font).setTextAlignment(TextAlignment.LEFT);
        p5.setFixedPosition(43, 240, 100);
        document.add(p5);
        
        // Display Transaction type
        Paragraph p6 = new Paragraph(transactionType).setFont(font).setTextAlignment(TextAlignment.RIGHT);
        p6.setFixedPosition(157, 240, 150);
        document.add(p6);
        
        Paragraph p7 = new Paragraph("Account type : ").setFont(font).setTextAlignment(TextAlignment.LEFT);
        p7.setFixedPosition(43, 215, 100);
        document.add(p7);
        
        // Display accountType used
        Paragraph p8 = new Paragraph(accountType).setFont(font).setTextAlignment(TextAlignment.RIGHT);
        p8.setFixedPosition(157, 215, 150);
        document.add(p8);
        
        Paragraph p9 = new Paragraph("Amount : ").setFont(font).setTextAlignment(TextAlignment.LEFT);
        p9.setFixedPosition(43, 190, 100);
        document.add(p9);
        
        // Display amount to transact
        Paragraph p10 = new Paragraph().setFont(font).setTextAlignment(TextAlignment.RIGHT);
        if(transactionType.equalsIgnoreCase("Deposit")){
            p10.add("+ PHP " + format.format(amount));
        } else {
            p10.add("- PHP " + format.format(amount));
        }
        p10.setFixedPosition(157, 190, 150);
        document.add(p10);
        
        Paragraph p11 = new Paragraph("Account Balance : ").setFont(font).setTextAlignment(TextAlignment.LEFT);
        p11.setFixedPosition(43, 165, 100);
        document.add(p11);
        
        
        // Display account balance
        Paragraph p12 = new Paragraph("PHP " + format.format(balance)).setFont(font).setTextAlignment(TextAlignment.RIGHT);
        p12.setFixedPosition(107, 165, 200);
        document.add(p12);
        
        Paragraph p13 = new Paragraph().setFont(font).setTextAlignment(TextAlignment.LEFT);
        if(transactionType.equalsIgnoreCase("Deposit") || transactionType.equalsIgnoreCase("Withdraw")){
            p13.add("");
        } else {
            p13.add("Recipient :");
        }
        p13.setFixedPosition(43, 140, 100);
        document.add(p13);
        
        // Display Transaction type
        Paragraph p14 = new Paragraph().setFont(font).setTextAlignment(TextAlignment.RIGHT);
        if(transactionType.equalsIgnoreCase("Deposit") || transactionType.equalsIgnoreCase("Withdraw")){
            p14.add("");
        } else {
            p14.add("Meralco");
        }
        p14.setFixedPosition(157, 140, 150);
        document.add(p14);
        
        Paragraph p15 = new Paragraph("Ref no. " + refNo).setFont(font).setTextAlignment(TextAlignment.LEFT).setFontSize(10);
        p15.setFixedPosition(43, 80, 150);
        document.add(p15);
        
        
        // Display account balance
        Paragraph p16 = new Paragraph(date).setFont(font).setTextAlignment(TextAlignment.RIGHT).setFontSize(10);
        p16.setFixedPosition(157, 80, 150);
        document.add(p16);
        
        Paragraph pA = new Paragraph("------------------------------------------------------").setFont(font).setTextAlignment(TextAlignment.CENTER).setBold().setFontSize(15);
        pA.setFixedPosition(-25, 56, 400);
        document.add(pA);
        
        Paragraph p17 = new Paragraph("THIS SERVES AS YOUR OFFICIAL TRANSACTION RECEIPT").setFont(font).setTextAlignment(TextAlignment.CENTER).setItalic().setFontSize(9);
        p17.setFixedPosition(-25, 37, 400);
        document.add(p17);


       
        document.close();
        openPDFFile(path1);
    }

    
    public static void openPDFFile(String filePath) {
        try {
            File file = new File(filePath);
            if (Desktop.isDesktopSupported() && file.exists()) {
                Desktop.getDesktop().open(file);
            } else {
                System.out.println("Desktop not supported or file does not exist");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[]args) throws FileNotFoundException, MalformedURLException, IOException {
        printReceipt("Pay bills", "Current", "123456789876", "12/12/2024 00:00", 500000, 9999999999.0);
    }
    
    
}

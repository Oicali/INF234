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
    public static final String path2 = "C:\\Users\\jairus\\Documents\\GitHub\\INF234\\FinalProject_ATM\\src\\main\\java\\PDF\\balanceReceipt.pdf";

    public static void printReceipt(String transactionType, String accountType, String refNo, String date, double amount, double balance) throws FileNotFoundException, MalformedURLException, IOException {
        PdfWriter writer = new PdfWriter(path1);
        PdfDocument pdf = new PdfDocument(writer);
        PageSize ps = new PageSize(350, 475);
        Document document = new Document(pdf, ps);

        PdfFont font = PdfFontFactory.createFont(FontConstants.COURIER);

        document.add(new Paragraph("BANK OF INCLUSIVE TRANSACTIONS").setTextAlignment(TextAlignment.CENTER).setFontSize(20).setFont(font).setBold());
        document.add(new Paragraph("Pasay, Metro Manila").setTextAlignment(TextAlignment.CENTER).setFontSize(10).setFont(font));
      
        Paragraph p = new Paragraph("-------------------------------").setFont(font).setTextAlignment(TextAlignment.CENTER).setBold().setFontSize(15);
        p.setFixedPosition(-25, 340, 400);
        document.add(p);
        
        Paragraph pB = new Paragraph("Transaction Receipt").setFont(font).setTextAlignment(TextAlignment.CENTER).setBold().setFontSize(13);
        pB.setFixedPosition(-25, 325, 400);
        document.add(pB);
        
        Paragraph pC = new Paragraph("-------------------------------").setFont(font).setTextAlignment(TextAlignment.CENTER).setBold().setFontSize(15);
        pC.setFixedPosition(-25, 310, 400);
        document.add(pC);
        
        
        Paragraph p1 = new Paragraph("Username : ").setFont(font).setTextAlignment(TextAlignment.LEFT);
        p1.setFixedPosition(35, 285, 200);
        document.add(p1);
        
        // Display name
        Paragraph p2 = new Paragraph(account.user.getName()).setFont(font).setTextAlignment(TextAlignment.RIGHT);
        p2.setFixedPosition(165, 285, 150);
        document.add(p2);
        
        Paragraph p3 = new Paragraph("Account number : ").setFont(font).setTextAlignment(TextAlignment.LEFT);
        p3.setFixedPosition(35, 260, 200);
        document.add(p3);
        
        // Display censored UID
        Paragraph p4 = new Paragraph(viewBalance.maskedStr1 + viewBalance.str2).setFont(font).setTextAlignment(TextAlignment.RIGHT);
        p4.setFixedPosition(165, 260, 150);
        document.add(p4);
        
        Paragraph p5 = new Paragraph("Transaction type : ").setFont(font).setTextAlignment(TextAlignment.LEFT);
        p5.setFixedPosition(35, 235, 150);
        document.add(p5);
        
        // Display Transaction type
        Paragraph p6 = new Paragraph(transactionType).setFont(font).setTextAlignment(TextAlignment.RIGHT);
        p6.setFixedPosition(165, 235, 150);
        document.add(p6);
        
        Paragraph p7 = new Paragraph("Account type : ").setFont(font).setTextAlignment(TextAlignment.LEFT);
        p7.setFixedPosition(35, 210, 150);
        document.add(p7);
        
        // Display accountType used
        Paragraph p8 = new Paragraph(accountType).setFont(font).setTextAlignment(TextAlignment.RIGHT);
        p8.setFixedPosition(165, 210, 150);
        document.add(p8);
        
        Paragraph p9 = new Paragraph("Amount : ").setFont(font).setTextAlignment(TextAlignment.LEFT);
        p9.setFixedPosition(35, 185, 100);
        document.add(p9);
        
        // Display amount to transact
        Paragraph p10 = new Paragraph().setFont(font).setTextAlignment(TextAlignment.RIGHT);
        if(transactionType.equalsIgnoreCase("Deposit")){
            p10.add("+ PHP " + format.format(amount));
        } else {
            p10.add("- PHP " + format.format(amount));
        }
        p10.setFixedPosition(165, 185, 150);
        document.add(p10);
        
        Paragraph p11 = new Paragraph("Balance : ").setFont(font).setTextAlignment(TextAlignment.LEFT);
        p11.setFixedPosition(35, 160, 150);
        document.add(p11);
        
        
        // Display account balance
        Paragraph p12 = new Paragraph("PHP " + format.format(balance)).setFont(font).setTextAlignment(TextAlignment.RIGHT);
        p12.setFixedPosition(115, 160, 200);
        document.add(p12);
        
        Paragraph p13 = new Paragraph().setFont(font).setTextAlignment(TextAlignment.LEFT);
        if(transactionType.equalsIgnoreCase("Deposit") || transactionType.equalsIgnoreCase("Withdraw")){
            p13.add("");
        } else if  (transactionType.equalsIgnoreCase("Bank Transfer")){
            p13.add("Sent to :");
        } else if (transactionType.equalsIgnoreCase("Pay Bills")){
            p13.add("Payment to :");
        }
        p13.setFixedPosition(35, 135, 100);
        document.add(p13);
        
        // Display Recipient
        Paragraph p14 = new Paragraph().setFont(font).setTextAlignment(TextAlignment.RIGHT);
        if(transactionType.equalsIgnoreCase("Deposit") || transactionType.equalsIgnoreCase("Withdraw")){
            p14.add("");
        } else if (transaction.transactionType.equalsIgnoreCase("Bank Transfer")){
            p14.add(typeAmount2.rCensoredUID + " via " + transactBank.bankName);
        } else if (transactionType.equalsIgnoreCase("Pay Bills")){
            p14.add(typeAmount3.rCensoredCustomer + " via " + transactBills.serviceName);
        }
        p14.setFixedPosition(145, 135, 170);
        document.add(p14);
        
        Paragraph p15 = new Paragraph("Ref no. " + refNo).setFont(font).setTextAlignment(TextAlignment.LEFT).setFontSize(10);
        p15.setFixedPosition(35, 90, 150);
        document.add(p15);
        
        
        // Display date
        Paragraph p16 = new Paragraph(date).setFont(font).setTextAlignment(TextAlignment.RIGHT).setFontSize(10);
        p16.setFixedPosition(165, 90, 150);
        document.add(p16);
        
        Paragraph pA = new Paragraph("-------------------------------").setFont(font).setTextAlignment(TextAlignment.CENTER).setBold().setFontSize(15);
        pA.setFixedPosition(-25, 60, 400);
        document.add(pA);
        
        Paragraph p17 = new Paragraph("THANK YOU FOR CHOOSING BIT!").setFont(font).setTextAlignment(TextAlignment.CENTER).setItalic().setFontSize(12);
        p17.setFixedPosition(-25, 30, 400);
        document.add(p17);

        document.close();
        openPDFFile(path1);
    }

    public static void printBalance(String accountType, String date) throws FileNotFoundException, MalformedURLException, IOException {
        PdfWriter writer = new PdfWriter(path2);
        PdfDocument pdf = new PdfDocument(writer);
        PageSize ps = new PageSize(350, 400);
        Document document = new Document(pdf, ps);

        PdfFont font = PdfFontFactory.createFont(FontConstants.COURIER);

        Paragraph p = new Paragraph("BANK OF INCLUSIVE\nTRANSACTIONS").setTextAlignment(TextAlignment.CENTER).setFontSize(20).setFont(font).setBold();
        p.setFixedPosition(-25, 320, 400);
        document.add(p);
        
        Paragraph p1 = new Paragraph("Pasay, Metro Manila").setTextAlignment(TextAlignment.CENTER).setFontSize(10).setFont(font);
         p1.setFixedPosition(-25, 305, 400);
        document.add(p1);
        
        Paragraph p2 = new Paragraph("-------------------------------").setFont(font).setTextAlignment(TextAlignment.CENTER).setBold().setFontSize(15);
        p2.setFixedPosition(-25, 280, 400);
        document.add(p2);
        
        Paragraph p3 = new Paragraph("Balance Receipt").setFont(font).setTextAlignment(TextAlignment.CENTER).setBold().setFontSize(13);
        p3.setFixedPosition(-25, 265, 400);
        document.add(p3);
        
        Paragraph p4 = new Paragraph("-------------------------------").setFont(font).setTextAlignment(TextAlignment.CENTER).setBold().setFontSize(15);
        p4.setFixedPosition(-25, 250, 400);
        document.add(p4);
        
        Paragraph p5 = new Paragraph("Username : ").setFont(font).setTextAlignment(TextAlignment.LEFT);
        p5.setFixedPosition(35, 225, 200);
        document.add(p5);
        
        // Display name
        Paragraph p6 = new Paragraph(account.user.getName()).setFont(font).setTextAlignment(TextAlignment.RIGHT);
        p6.setFixedPosition(165, 225, 150);
        document.add(p6);
        
        Paragraph p7 = new Paragraph("Account number : ").setFont(font).setTextAlignment(TextAlignment.LEFT);
        p7.setFixedPosition(35, 200, 200);
        document.add(p7);
        
        // Display censored UID
        Paragraph p8 = new Paragraph(viewBalance.maskedStr1 + viewBalance.str2).setFont(font).setTextAlignment(TextAlignment.RIGHT);
        p8.setFixedPosition(165, 200, 150);
        document.add(p8);
        
        Paragraph p9 = new Paragraph("Account type : ").setFont(font).setTextAlignment(TextAlignment.LEFT);
        p9.setFixedPosition(35, 175, 150);
        document.add(p9);
        
        // Display accountType used
        Paragraph p10 = new Paragraph(accountType).setFont(font).setTextAlignment(TextAlignment.RIGHT);
        p10.setFixedPosition(165, 175, 150);
        document.add(p10);
        
        Paragraph p11 = new Paragraph("Balance : ").setFont(font).setTextAlignment(TextAlignment.LEFT).setBold();
        p11.setFixedPosition(35, 150, 150);
        document.add(p11);
        
        
        // Display account balance
        Paragraph p12 = new Paragraph().setFont(font).setTextAlignment(TextAlignment.RIGHT).setBold();
        if(accountType.equalsIgnoreCase("Current")){
            p12.add("PHP " + format.format(account.user.getCurrent()));
        } else if (accountType.equalsIgnoreCase("Savings")) {
            p12.add("PHP " + format.format(account.user.getSavings()));
        }
        p12.setFixedPosition(115, 150, 200);
        document.add(p12);
        
        // Display date
        Paragraph p13 = new Paragraph(date).setFont(font).setTextAlignment(TextAlignment.RIGHT).setFontSize(10);
        p13.setFixedPosition(165, 90, 150);
        document.add(p13);
        
        Paragraph p14 = new Paragraph("-------------------------------").setFont(font).setTextAlignment(TextAlignment.CENTER).setBold().setFontSize(15);
        p14.setFixedPosition(-25, 60, 400);
        document.add(p14);
        
        Paragraph p15 = new Paragraph("THIS SERVES AS YOUR OFFICIAL RECEIPT").setFont(font).setTextAlignment(TextAlignment.CENTER).setItalic().setFontSize(12);
        p15.setFixedPosition(-25, 30, 400);
        document.add(p15);
        
        
        document.close();
        openPDFFile(path2);
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
        //printReceipt("Pay bills", "Current", "123456789876", "12/12/2024 00:00", 500000, 99999999999999.0);
        printBalance("Current", "12/12/2024 00:00");
    }
    
    
}

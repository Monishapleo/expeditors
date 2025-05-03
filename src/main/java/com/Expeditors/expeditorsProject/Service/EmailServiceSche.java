package com.Expeditors.expeditorsProject.Service;

import com.Expeditors.expeditorsProject.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceSche {

    @Autowired
    private JavaMailSender emailSender;
    public void sendInvoiceEmail(Document document) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("mmohamedraja26gmail.com"); // Fetch customer's email properly
        message.setSubject("Avalon_AIP_27.04.25");
        message.setText("Dear Customer, Please find the attached invoice. we have expecting your payment:\n"
                + "Shipment Ref: " + document.getShipmentRefNumber() + "\n"
                + "Date: " + document.getInvoiceDate() + "\n"
                + "Amount: " + document.getInvoiceAmount());
        emailSender.send(message);
    }
}
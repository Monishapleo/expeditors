package com.Expeditors.expeditorsProject.Service;

import com.Expeditors.expeditorsProject.Document;
import com.Expeditors.expeditorsProject.Repository.DocumentRepository;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.logging.Logger;

@Service
public class EmailService {

    private static final Logger logger = Logger.getLogger(EmailService.class.getName());

    @Autowired
    private DocumentRepository documentRepository;

    @Autowired
    private EmailServiceSche emailServiceSche;

    @Transactional
    public List<Document> saveInvoices(List<Document> documents) {
        logger.info("Saving invoices...");
        return documentRepository.saveAll(documents);
    }


    @Transactional(readOnly = true)
    public List<Document> getInvoices() {
        logger.info("Fetching all invoices from the database...");
        return documentRepository.findAll();
    }

    @Scheduled(cron = "0 0 9 * * ?") // Adjust the schedule as needed (Every day at 9 AM IST if time zone is configured)
    public void sendInvoicesDaily() throws MessagingException {
        LocalDate today = LocalDate.now();
        List<Document> Documents = documentRepository.findByInvoiceDate(today);
        // Assuming a method to send emails to customers with their invoices.
        for (Document document : Documents) {
            emailServiceSche.sendInvoiceEmail(document);
        }
    }
}
//
//    @Transactional
//    public Document updateInvoice(Long id, String shipmentRefNumber, LocalDate invoiceDate, BigDecimal invoiceAmount) {
//        logger.info("Updating invoice with ID: " + id);
//        Document existingDocument = documentRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Document not found with id: " + id));
//
//        existingDocument.setShipmentRefNumber(shipmentRefNumber);
//        existingDocument.setInvoiceDate(invoiceDate);
//        existingDocument.setInvoiceAmount(invoiceAmount);
//
//        return documentRepository.save(existingDocument); // Hibernate will handle version check
//    }
//
//    @Transactional(readOnly = true)
//    public Document getInvoiceById(Long id) {
//        logger.info("Fetching invoice with ID: " + id);
//        return documentRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Document not found with id: " + id));
//    }
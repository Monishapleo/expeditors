package com.Expeditors.expeditorsProject.Controller;

import com.Expeditors.expeditorsProject.Document;
import com.Expeditors.expeditorsProject.Service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/comments")
public class InvoiceProcessor {

    private static final Logger logger = Logger.getLogger(InvoiceProcessor.class.getName());

    @Autowired
    private EmailService emailService;

    @PostMapping("/addInvoices/way")
    public List<Document> addInvoices(@RequestBody List<Document> document){
        logger.info("Start the process to add the invoices");
        return emailService.saveInvoices(document);
    }

    @GetMapping("/documents")
    public List<Document> findAllInvoices(){
        logger.info("The process to get the All invoices from the Database");
        return emailService.getInvoices();
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(Exception ex) {
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("message", "Something went wrong.");
        modelAndView.addObject("exception", ex.getMessage());
        return modelAndView;
    }
}


//    LocalDate today = LocalDate.now();
//    LocalDate yesterday = today.minusDays(1);
//
//    List<Document> documents = documentRepo.findByInvoiceDateBetween(yesterday, today);
//
//        for (Document doc : documents) {
//        String customerEmail = getCustomerEmailByShipmentRef(doc.getShipmentRefNumber());
//        emailService.sendInvoiceEmail(customerEmail, doc);
//    }
//}
//
//private String getCustomerEmailByShipmentRef(String shipmentRef) {
//    // You can replace this with DB fetch logic
//    return "mmohamedraja26@gmail.com";
//}
package com.Expeditors.expeditorsProject;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "inovice_list") // Table name in the database
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-increment ID

    @Column(name = "id")
    private Long id;

    @Column(name = "shipref_num")  // Specifies column name if it differs
    private String shipmentRefNumber;

    @Column(name = "inv_date")  // Specifies column name if needed
    private LocalDate invoiceDate;

    @Column(name = "inv_amount")  // Specifies column name if needed
    private BigDecimal invoiceAmount;

    @Version
    private Integer version; //

    // Default constructor
    public Document() {
    }

    // Constructor with all fields
    public Document(String shipmentRefNumber, LocalDate invoiceDate, BigDecimal invoiceAmount) {
        this.shipmentRefNumber = shipmentRefNumber;
        this.invoiceDate = invoiceDate;
        this.invoiceAmount = invoiceAmount;
    }

     //Getter and Setter Methods
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShipmentRefNumber() {
        return shipmentRefNumber;
    }

    public void setShipmentRefNumber(String shipmentRefNumber) {
        this.shipmentRefNumber = shipmentRefNumber;
    }

    public LocalDate getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(LocalDate invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public BigDecimal getInvoiceAmount() {
        return invoiceAmount;
    }

    public void setInvoiceAmount(BigDecimal invoiceAmount) {
        this.invoiceAmount = invoiceAmount;
    }
}


package com.Expeditors.expeditorsProject.Repository;

import com.Expeditors.expeditorsProject.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> {
    List<Document> findByInvoiceDateBetween(LocalDate start, LocalDate end);

    List<Document> findByInvoiceDate(LocalDate today);
}



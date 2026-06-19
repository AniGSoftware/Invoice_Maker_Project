package com.invoice;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data

public class InvoiceItem {

    @Id
    @GeneratedValue
    private Long id;

    private String productName;
    private int gsm;
    private int quantity;
    private double price;
    private double total;

    @ManyToOne
    private Invoice invoice;

    public void setInvoice(Invoice invoice) { this.invoice = invoice; }

    public int getQuantity() { return quantity; }
    public double getPrice() { return price; }

    public void setTotal(double total) { this.total = total; }
}

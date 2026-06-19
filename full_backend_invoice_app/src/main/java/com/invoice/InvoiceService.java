package com.invoice;

import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class InvoiceService {

    private final InvoiceRepository repo;

    public InvoiceService(InvoiceRepository repo) {
        this.repo = repo;
    }

    public Invoice save(Invoice invoice) {

        double total = 0;

        for (InvoiceItem item : invoice.getItems()) {
            item.setInvoice(invoice); // 🔥 FIX
            item.setTotal(item.getPrice() * item.getQuantity());
            total += item.getPrice() * item.getQuantity();
        }

        invoice.setTotal(total);

        return repo.save(invoice);
    }

	public List<Invoice> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
}

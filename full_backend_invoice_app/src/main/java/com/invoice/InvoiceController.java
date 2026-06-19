package com.invoice;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3005")

@RestController
@RequestMapping("/invoices")
//@CrossOrigin("*")
public class InvoiceController {

    private final InvoiceService service;

    public InvoiceController(InvoiceService service) {
        this.service = service;
    }

    @PostMapping
    public Invoice create(@RequestBody Invoice invoice) {
        return service.save(invoice);
    }

    @GetMapping
    public List<Invoice> getAll() {
        return service.getAll();
    }
}

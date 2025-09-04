package com.cts.productapp.api;

import com.cts.productapp.model.Supplier;
import com.cts.productapp.repository.SupplierRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/suppliers")
public class SupplierApi {

    private SupplierRepository supplierRepo;

    public SupplierApi(SupplierRepository supplierRepo) {
        this.supplierRepo = supplierRepo;
    }

    @GetMapping
    public List<Supplier> getAllSuppliers(){
        return supplierRepo.findAll();
    }

    @GetMapping("/{id}")
    public Supplier getSupplierById(@PathVariable int id){
        return supplierRepo.findById(id).get();
    }


}

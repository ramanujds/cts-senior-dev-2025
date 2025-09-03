package com.cts.productapp.api;

import com.cts.productapp.exception.RecordNotFoundException;
import com.cts.productapp.model.Product;
import com.cts.productapp.repository.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductApi {

    private ProductRepository productRepo;

    public ProductApi(ProductRepository productRepo) {
        this.productRepo = productRepo;
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Product saveProduct(@RequestBody Product product){
        if(productRepo.existsById(product.getId())){
            throw new ResponseStatusException(HttpStatus.CONFLICT,"Product with id "+product.getId()+ " already exists");
        }
        return productRepo.save(product);
    }

    @GetMapping
    public List<Product> getAllProducts(){
        return productRepo.findAll();
    }


    @GetMapping("/{id}")
    public Product getProductById(@PathVariable int id){
        return productRepo.findById(id).orElseThrow(
                ()->new RecordNotFoundException("Product with id "+id+ " not found")
        );
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteProductById(@PathVariable int id){
        if(!productRepo.existsById(id)){
            throw new RecordNotFoundException("Product with id "+id+ " not found");
        }
        productRepo.deleteById(id);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public Product updateProduct(@PathVariable int id, @RequestBody Product product){
        if(!productRepo.existsById(id)){
            throw new RecordNotFoundException("Product with id "+id+ " not found");
        }
        Product productToUpdate = getProductById(id);
       if(product.getName()!=null){
           productToUpdate.setName(product.getName());
       }
        if(product.getDescription()!=null){
            productToUpdate.setDescription(product.getName());
        }
        if (product.getPrice()!=0){
            productToUpdate.setPrice(product.getPrice());
        }

        return productRepo.save(productToUpdate);
    }

    @GetMapping("/search")
    public Product searchProduct(@RequestParam("name") String name, @RequestParam("price") double price){
       return productRepo.findByNameIgnoreCase(name).orElseThrow(()->new RecordNotFoundException("Product with name "+name+ " not found"));
    }

}

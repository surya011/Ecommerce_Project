package dev.surya.productservice.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    @GetMapping
    public void getAllProducts() {

    }
    @GetMapping("/{id}")
    public String getProductById(@PathVariable("id") Long id) {
        return " Here is product id: " +id;

    }
    @DeleteMapping("/{id}")
    public void deleteProductById() {

    }
    @PostMapping
    public void createProductById() {

    }
    @PutMapping("/{id}")
    public void updateProductById() {

    }
}

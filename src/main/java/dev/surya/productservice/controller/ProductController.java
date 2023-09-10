package dev.surya.productservice.controller;

import dev.surya.productservice.dtos.GenericProductDto;
import dev.surya.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
//Di with only autowired will also work
    //@Autowired(not recommended field injection
    private ProductService productService;

    // constructor injection
    public ProductController(@Qualifier("fakeProductService")ProductService productService) {
        this.productService = productService;
    }

    //Injecting via setter(not recommended)
//    @Autowired
//    public void setProductService(ProductService productService){
//        this.productService = productService;
//    }
    @GetMapping
    public void getAllProducts() {

    }
    @GetMapping("/{id}")
    public GenericProductDto getProductById(@PathVariable("id") Long id) {
        return productService.getProductById(id);

    }
    @DeleteMapping("/{id}")
    public void deleteProductById() {

    }
    @PostMapping
    public GenericProductDto createProduct(@RequestBody GenericProductDto product) {
        return productService.createProduct(product);

    }
    @PutMapping("/{id}")
    public void updateProductById() {

    }
}

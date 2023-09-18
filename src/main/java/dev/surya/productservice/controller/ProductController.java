package dev.surya.productservice.controller;

import dev.surya.productservice.dtos.ExceptionDto;
import dev.surya.productservice.dtos.FakeStoreProductDto;
import dev.surya.productservice.dtos.GenericProductDto;
import dev.surya.productservice.exceptions.NotFoundException;
import dev.surya.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
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
    public List<GenericProductDto> getAllProducts() {
        return productService.getAllProducts();

    }
    @GetMapping("/{id}")
    public GenericProductDto getProductById(@PathVariable("id") Long id) throws NotFoundException {
        return productService.getProductById(id);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GenericProductDto> deleteProductById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(
                productService.deleteProduct(id),
                HttpStatus.OK
        );
      //  return productService.deleteProduct(id);

    }
    @PostMapping
    public GenericProductDto createProduct(@RequestBody GenericProductDto product) {
        return productService.createProduct(product);

    }
    @PutMapping("/{id}")
    public GenericProductDto updateProductById(@RequestBody GenericProductDto product) {
        return  productService.updateProduct(product);

    }
}

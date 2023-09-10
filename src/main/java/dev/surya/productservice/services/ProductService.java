package dev.surya.productservice.services;

import dev.surya.productservice.dtos.GenericProductDto;
import dev.surya.productservice.models.Product;

public interface ProductService {
    GenericProductDto createProduct(GenericProductDto product);

    //Product getProductById(Long Id);
    GenericProductDto getProductById(Long Id);
}

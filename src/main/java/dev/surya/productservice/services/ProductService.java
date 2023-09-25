package dev.surya.productservice.services;

import dev.surya.productservice.dtos.GenericProductDto;
import dev.surya.productservice.exceptions.NotFoundException;
import dev.surya.productservice.models.Product;

import java.util.List;

public interface ProductService {
    GenericProductDto createProduct(GenericProductDto product);

    GenericProductDto updateProduct(Long id);

    //Product getProductById(Long Id);
    GenericProductDto getProductById(Long id) throws NotFoundException;

    List<GenericProductDto> getAllProducts();

    GenericProductDto deleteProduct(Long id);
}

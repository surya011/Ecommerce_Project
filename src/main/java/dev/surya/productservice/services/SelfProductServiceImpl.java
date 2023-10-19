package dev.surya.productservice.services;

import dev.surya.productservice.dtos.GenericProductDto;
import dev.surya.productservice.models.Product;
import dev.surya.productservice.repositories.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.security.ProtectionDomain;
import java.util.List;

@Service("selfProductServiceImpl")
@Primary
public class SelfProductServiceImpl implements ProductService {
    private ProductRepository productRepository;

    public SelfProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @Override
    public GenericProductDto createProduct(GenericProductDto product) {
        return null;
    }

    @Override
    public GenericProductDto getProductById(Long Id){
      return null;
 }

    @Override
    public GenericProductDto updateProduct(Long id) {
        return null;
    }

    @Override
    public List<GenericProductDto> getAllProducts() {
        return null;
    }

    @Override
    public GenericProductDto deleteProduct(Long id) {
        return null;
    }
}

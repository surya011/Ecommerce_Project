package dev.surya.productservice.repositories;

import dev.surya.productservice.ProductserviceApplication;
import dev.surya.productservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductRepository
extends JpaRepository<Product, UUID> {
}

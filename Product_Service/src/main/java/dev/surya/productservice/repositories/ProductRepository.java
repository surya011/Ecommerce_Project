package dev.surya.productservice.repositories;

import dev.surya.productservice.ProductserviceApplication;
import dev.surya.productservice.models.Product;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
import java.util.function.Function;

@Repository
public interface ProductRepository
extends JpaRepository<Product, UUID> {

    Product findByTitleEquals(String title);

    Product findByTitleEqualsAndPrice_Price(String title, double price );

    List<Product> findAllByPrice_Currency(String currency);

    //count all products with currency rupee
    long countAllByPrice_Currency(String currency);

    // writing your own native query
//    @Query( value = "select * from product where title =:surya",nativeQuery = true)
//    List<Product> findAllByName(String surya);

    @Query( value = "select * from product join product_orders "+
            "on product.id = product_orders.product_id where title = :surya",
            nativeQuery = true)
    List<Product> findAllByName(String surya);

    // hql queries
    // Writing in terms of classes
    @Query( value = "select Product from Product where Product.price.currency = :currency and Product.title = :surya",
            nativeQuery = true)
    List<Product> readAllByName(String surya, String currency);
}

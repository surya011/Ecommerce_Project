package dev.surya.productservice.models;

import jakarta.persistence.Entity;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "orders")
public class Order extends BaseModel {
    @ManyToMany
    @JoinTable(
            name = "product_orders",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> product;
}

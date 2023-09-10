package dev.surya.productservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FakeStoreProductDto {
    private Long Id;
    private String title;
    private double price;
    private String category;
    private String description;
    private String image;
}

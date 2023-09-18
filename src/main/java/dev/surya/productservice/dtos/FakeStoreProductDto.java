package dev.surya.productservice.dtos;

import lombok.Getter;

@Getter
public class FakeStoreProductDto {
    private Long Id;
    private String title;
    private double price;
    private String category;
    private String description;
    private String image;

    public void setId(Long Id) {
        this.Id = Id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImage(String image) {
        this.image = image;
    }
}

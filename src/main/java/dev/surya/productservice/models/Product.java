package dev.surya.productservice.models;

import lombok.Getter;

@Getter

//for Delombok press ctrl + shift+ a
public class Product extends BaseModel {
    private String title;
    private String description;
    private String image;
    private Category category;
    private double price;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

package dev.surya.productservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


//for Delombok press ctrl + shift+ a
//checking git remote
@Entity
@Builder
@Setter
public class Product extends BaseModel {
    private String title;
    private String description;
    private String image;
    @ManyToOne
    private Category category;
    private double price;

    public Product(String title, String description, String image, Category category, double price) {
        this.title = title;
    }
    public Product(){

    }
    public static ProductBuilder builder(){
        return new ProductBuilder();
    }

    public double getPrice() {
        return price;
    }

    public Category getCategory() {
        return category;
    }

    public String getImage() {
        return image;
    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

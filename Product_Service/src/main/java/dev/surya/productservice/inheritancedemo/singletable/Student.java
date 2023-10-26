package dev.surya.productservice.inheritancedemo.singletable;

import dev.surya.productservice.inheritancedemo.mappedsuperclass.User;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "st_Student")
public class Student extends User {
    private double psp;
    private double attendance;


}

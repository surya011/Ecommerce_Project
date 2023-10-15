package dev.surya.productservice;


import dev.surya.productservice.inheritancedemo.joinedtable.MentorRepository;
import dev.surya.productservice.inheritancedemo.joinedtable.UserRepository;
import dev.surya.productservice.models.Category;
import dev.surya.productservice.models.Product;
import dev.surya.productservice.repositories.CategoryRepository;
import dev.surya.productservice.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;

@SpringBootApplication
public class ProductserviceApplication implements CommandLineRunner {
    private MentorRepository mentorRepository;
    private UserRepository userRepository;

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;


    public ProductserviceApplication(@Qualifier("jt_mr") MentorRepository mentorRepository,
                                     @Qualifier("jt_ur") UserRepository userRepository,
                                     ProductRepository productRepository,
                                     CategoryRepository categoryRepository) {
        this.mentorRepository = mentorRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;

    }

    public static void main(String[] args) {
        SpringApplication.run(ProductserviceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

//        Mentor mentor = new Mentor();
//        mentor.setName("Surya");
//        mentor.setEmail("surya@gmail.com");
//        mentor.setAverageRating(4.65);
//        mentorRepository.save(mentor);
//
//        User user = new User();
//        user.setName("Aman");
//        user.setEmail("amancool@gmail.com");
//        userRepository.save(user);

        Category category = new Category();
        category.setName("Apple devices");
        Category savedCategory = categoryRepository.save(category);

        Product product = new Product();
        product.setTitle("Iphone 15 Pro");
        product.setDescription("The Best Iphone Ever");
        product.setCategory(savedCategory);

        productRepository.save(product);

        // After saving this product i got category id from the category table

        Category category1 = categoryRepository.findById(UUID.fromString("130bf2f8-bbf4-4d5e-b3b3-820edcad37d4")).get();

        System.out.println("Category name is: " + category1.getName());
        System.out.println("Printing all products in the category");
        Thread.sleep(1000);


//        for (Product product1 : category1.getProducts()) {
//            try {
//                System.out.println(product1.getTitle());
//            } catch (Exception e) {
//                System.out.println(e.getMessage());
//            }
//        }


    }
}


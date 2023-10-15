package dev.surya.productservice;

import dev.surya.productservice.inheritancedemo.singletable.Mentor;
import dev.surya.productservice.inheritancedemo.singletable.MentorRepository;
import dev.surya.productservice.inheritancedemo.singletable.User;
import dev.surya.productservice.inheritancedemo.singletable.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductserviceApplication implements CommandLineRunner {
    private MentorRepository mentorRepository;
    private UserRepository userRepository;

    public ProductserviceApplication(MentorRepository mentorRepository,
                                     UserRepository userRepository) {
        this.mentorRepository = mentorRepository;
        this.userRepository = userRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(ProductserviceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Mentor mentor = new Mentor();
        mentor.setName("Surya");
        mentor.setEmail("surya@gmail.com");
        mentor.setAverageRating(4.65);
        mentorRepository.save(mentor);

        User user = new User();
        user.setName("Aman");
        user.setEmail("amancool@gmail.com");
        userRepository.save(user);
    }

}

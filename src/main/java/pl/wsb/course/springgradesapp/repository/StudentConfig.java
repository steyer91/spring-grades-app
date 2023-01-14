package pl.wsb.course.springgradesapp.repository;

import org.hibernate.boot.model.process.internal.UserTypeResolution;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.wsb.course.springgradesapp.model.Student;
import pl.wsb.course.springgradesapp.model.User;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class StudentConfig {
    private PasswordEncoder passwordEncoder;

    public StudentConfig(PasswordEncoder encoder)
    {
        this.passwordEncoder = encoder;
    }
    @Bean
    CommandLineRunner runner(StudentRepository studentRepository, UserRepository userRepository){
        return args -> {
            Student bartek = new Student("Bartłomiej", "Korbanek", LocalDate.of(1991,9,9), "91090912332");
            Student ania = new Student("Anna", "Wleklińska-Korbanek",  LocalDate.of(1991,12,10), "91121012332");

            studentRepository.saveAll(List.of(bartek, ania));

            User user = new User();
            user.setFirstName("Bartłomiej");
            user.setLastName("Korbanek");
            user.setEmail("a@a.pl");

            user.setPassword(passwordEncoder.encode("1234"));

            userRepository.save(user);
        };
    }
}



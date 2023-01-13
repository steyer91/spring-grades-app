package pl.wsb.course.springgradesapp.repository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.wsb.course.springgradesapp.model.Student;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class StudentConfig {
    //private StudentRepository repository;

    @Bean
    CommandLineRunner runner(StudentRepository repository){
        //this.repository = repository;
        return args -> {
            Student bartek = new Student("Bartłomiej", "Korbanek", LocalDate.of(1991,9,9));
            Student ania = new Student("Anna", "Wleklińska-Korbanek",  LocalDate.of(1991,12,10));

            repository.saveAll(List.of(bartek, ania));
        };
    }
}

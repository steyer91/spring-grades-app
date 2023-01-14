package pl.wsb.course.springgradesapp.model.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {

    private Long id;

    private String firstName;

    private String LastName;

    private LocalDate birth;

    private String pesel;

    private Integer age;
}

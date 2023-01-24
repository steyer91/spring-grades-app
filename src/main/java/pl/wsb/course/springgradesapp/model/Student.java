package pl.wsb.course.springgradesapp.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table
public class Student {
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;
    @Column(
            name = "first_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String firstName;
    @Column(
            name = "last_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String LastName;
    private LocalDate birth;

    @Column(
            name = "pesel",
            nullable = false,
            columnDefinition = "TEXT",
            unique = true
    )
    private String pesel;

    @OneToMany(mappedBy = "student")
    Set<Grade> grades;


    @Transient
    private Integer age;

    public Student(String firstName, String lastName, LocalDate birth, String pesel) {
        this.firstName = firstName;
        this.LastName = lastName;
        this.birth = birth;
        this.pesel = pesel;
    }
    public Student() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public Integer getAge() {

        return Period.between(birth, LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {

        this.age = age;
    }

}

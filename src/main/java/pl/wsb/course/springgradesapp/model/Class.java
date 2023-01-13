package pl.wsb.course.springgradesapp.model;

import jakarta.persistence.*;

@Entity
public class Class {
    @Id
    @SequenceGenerator(
            name = "class_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "class_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;
    @Column(
            name = "grade",
            nullable = false
    )
    private Integer grade;

    @Column(
            name = "letter",
            nullable = false
    )
    private Character letter;

    public Class(Integer grade, Character letter) {
        this.grade = grade;
        this.letter = letter;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Character getLetter() {
        return letter;
    }

    public void setLetter(Character letter) {
        this.letter = letter;
    }

    @Override
    public String toString() {
        return "Class{" +
                "id=" + id +
                ", grade=" + grade +
                ", letter=" + letter +
                '}';
    }
}

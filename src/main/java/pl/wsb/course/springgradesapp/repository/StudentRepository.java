package pl.wsb.course.springgradesapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.wsb.course.springgradesapp.model.Student;

import java.util.Optional;

@Repository
public interface StudentRepository
        extends JpaRepository<Student, Long> {

    @Query("SELECT s FROM Student s WHERE s.pesel = ?1")
    Optional<Student> findStudentByPesel(String pesel);
}

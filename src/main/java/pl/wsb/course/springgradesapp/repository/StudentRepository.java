package pl.wsb.course.springgradesapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.wsb.course.springgradesapp.model.Student;

@Repository
public interface StudentRepository
        extends JpaRepository<Student, Long> {

}

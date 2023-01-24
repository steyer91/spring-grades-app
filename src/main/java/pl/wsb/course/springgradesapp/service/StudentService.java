package pl.wsb.course.springgradesapp.service;
import pl.wsb.course.springgradesapp.model.dto.StudentDto;

import java.util.List;


public interface StudentService {

    StudentDto get(Long id);

    List<StudentDto> getAll();

    void add(StudentDto studentDto);

    void delete(Long id);
    void update(Long id, String firstName, String lastName);
}

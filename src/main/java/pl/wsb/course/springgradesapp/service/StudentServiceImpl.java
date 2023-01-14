package pl.wsb.course.springgradesapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.wsb.course.springgradesapp.model.Student;
import pl.wsb.course.springgradesapp.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService<Student> {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAll()
    {
        return studentRepository.findAll();
    }

    public void add(Student student) {
        Optional<Student> optionalStudent = studentRepository.findStudentByPesel(student.getPesel());
        if(optionalStudent.isPresent()) {
            throw new IllegalStateException("Pesel is taken");
        }
        studentRepository.save(student);
    }

    public void delete(Long id) {

        if(!studentRepository.existsById(id)) {
            throw new IllegalStateException("User with id" + id + " doesn't exists.");
        }
        studentRepository.deleteById(id);
    }

    public Student get(Long id) {
        if(!studentRepository.existsById(id)) {
            throw new IllegalStateException("User with id" + id + " doesn't exists.");
        }
        return studentRepository.findById(id).get();
    }

    public void update(Long id, String firstName, String lastName) {
    }
}

package pl.wsb.course.springgradesapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.wsb.course.springgradesapp.model.Student;
import pl.wsb.course.springgradesapp.repository.StudentRepository;
import pl.wsb.course.springgradesapp.model.dto.StudentDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<StudentDto> getAll()
    {
        var list = studentRepository.findAll();
        List<StudentDto> dtoList = new ArrayList<>();

        for (Student student:list) {
            StudentDto studentDto = new StudentDto();
            studentDto.setFirstName(student.getFirstName());
            studentDto.setLastName(student.getLastName());
            studentDto.setBirth(student.getBirth());
            studentDto.setPesel(student.getPesel());
            studentDto.setId(student.getId());
            studentDto.setAge(student.getAge());

            dtoList.add(studentDto);
        }
        return dtoList;
    }

    public void add(StudentDto studentDto) {
        Optional<Student> optionalStudent = studentRepository.findStudentByPesel(studentDto.getPesel());
        if(optionalStudent.isPresent())
            throw new IllegalStateException("Pesel is taken");

        Student student = new Student();
        student.setFirstName(studentDto.getFirstName());
        student.setLastName(studentDto.getLastName());
        student.setBirth(studentDto.getBirth());
        student.setPesel(student.getPesel());

        studentRepository.save(student);
    }

    public void delete(Long id) {

        if(!studentRepository.existsById(id)) {
            throw new IllegalStateException("User with id" + id + " doesn't exists.");
        }
        studentRepository.deleteById(id);
    }

    public StudentDto get(Long id) {
        if(!studentRepository.existsById(id)) {
            throw new IllegalStateException("User with id" + id + " doesn't exists.");
        }
        var student = studentRepository.findById(id).get();

        StudentDto studentDto = new StudentDto();
        studentDto.setFirstName(student.getFirstName());
        studentDto.setLastName(student.getLastName());
        studentDto.setBirth(student.getBirth());
        studentDto.setPesel(student.getPesel());
        studentDto.setId(student.getId());
        studentDto.setAge(student.getAge());

        return studentDto;
    }

    public void update(Long id, String firstName, String lastName) {
    }
}

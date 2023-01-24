package pl.wsb.course.springgradesapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.wsb.course.springgradesapp.model.Student;
import pl.wsb.course.springgradesapp.service.StudentService;
import pl.wsb.course.springgradesapp.model.dto.StudentDto;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

    private final String route = "api/v1/student";
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping(path="/students")
    //@
    public List<StudentDto> getStudents(){
        return studentService.getAll();
    }
    @GetMapping(path=route + "{studentId}")
    public StudentDto get(@PathVariable("studentId") Long id){

        return studentService.get(id);
    }

    @PostMapping
    @GetMapping(path=route)
    public void registerNewStudent(@RequestBody StudentDto student){
        studentService.add(student);
    }

    @DeleteMapping(path=route + "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long id){
        studentService.delete(id);
    }

    @PutMapping(path=route + "{studentId}")
    public void updateStudent(@PathVariable("studentId") Long id,
                              @RequestParam(required = false) String firstName,
                              @RequestParam(required = false) String lastName){
        studentService.update(id, firstName, lastName);
    }

}

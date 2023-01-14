package pl.wsb.course.springgradesapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.wsb.course.springgradesapp.model.Student;
import pl.wsb.course.springgradesapp.service.StudentServiceImpl;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

    private final StudentServiceImpl studentService;

    @Autowired
    public StudentController(StudentServiceImpl studentService) {
        this.studentService = studentService;
    }


    @GetMapping
    //@ResponseBody
    public List<Student> getStudents(){
        return studentService.getAll();
    }
    @GetMapping(path="{studentId}")
    //@ResponseBody
    public Student get(@PathVariable("studentId") Long id){

        return studentService.get(id);
    }

    @PostMapping
    public void registerNewStudent(@RequestBody Student student){
        studentService.add(student);
    }

    @DeleteMapping(path="{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long id){
        studentService.delete(id);
    }

    @PutMapping(path="{studentId}")
    public void updateStudent(@PathVariable("studentId") Long id,
                              @RequestParam(required = false) String firstName,
                              @RequestParam(required = false) String lastName){
        studentService.update(id, firstName, lastName);
    }

}

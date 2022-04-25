package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1.student")
public class StudentController {

    private  final StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService) {

        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getstudents() {
        return studentService.getstudents();

    }
    @PostMapping
    public void registernewstudent(@RequestBody Student student){
        studentService.addNewstudent(student);
    }


    @DeleteMapping("/{id}")
    public void deletestudent(@PathVariable("id") Long id){
        studentService.deleteStudent(id);

    }
    @PutMapping("/update/{id}")
    public void updatestudent(@PathVariable("id") Long id,@RequestParam(required = false) String name,@RequestParam(required = false) String email){
        studentService.updatestudent(id,name,email);


    }

}


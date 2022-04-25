package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    @Autowired
    public StudentService(StudentRepository studentReposiory) {
        this.studentRepository = studentReposiory;
    }

    public List<Student> getstudents() {

        return studentRepository.findAll();
    }

    public void addNewstudent(Student student) {
        Optional<Student> optionalStudent=studentRepository.findByemail(student.getEmail());
        if (optionalStudent.isPresent()){
            throw new IllegalStateException("email already taken");
        }
        studentRepository.save(student);

    }

    public void deleteStudent(Long id) {
        boolean exist=studentRepository.existsById(id);
        if(!exist) {
            throw new IllegalStateException("student doesnt exist");
        }
        studentRepository.deleteById(id);
    }
    @Transactional
    public void updatestudent(Long id, String name, String email) {
        Student student=studentRepository.findById(id).orElseThrow(()->new IllegalStateException("student does not existss"));

        if (name!=null && !Objects.equals(name,student.getName()) && name.length()>0 ){
            student.setName(name);
        }
        if (email!=null && !Objects.equals(email,student.getEmail()) && email.length()>0 ){
            Optional<Student> checkingemail=studentRepository.findByemail(email);
            if (checkingemail.isPresent()){
                throw new IllegalStateException("updating student-ut email already exists");
            }
            student.setEmail(email);
        }
}
}



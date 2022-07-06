package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/*@Component  //to say that this is bean class*/
@Service  // for more readability spring provides this annotation ;same as @Component
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping                //inorder for this method to serve as restful endpoint.for we want to get something out from our server.
    public List<Student> getStudents(){

//		ArrayList<String> friends =  new ArrayList<>(Arrays.asList("Peter", "Paul"));
        return studentRepository.findAll();                //this returns a list to us
    }

    public void addNewStudent(Student student) {
        Optional<Student>studentOptional= studentRepository.findStudentByEmail(student.getEmail());
        if(studentOptional.isPresent()){
            throw new IllegalStateException("Email taken");
        }
        else{
            studentRepository.save(student);
        }

        System.out.println(student);
    }
}

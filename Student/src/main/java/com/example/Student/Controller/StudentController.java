package com.example.Student.Controller;

import com.example.Student.Entity.Student;
import com.example.Student.Model.StudentModel;
import com.example.Student.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/Students")
    public ResponseEntity<?> addStudent(@RequestBody StudentModel studentModel){
        studentService.addStudent(studentModel);
        return new ResponseEntity<>("Saved Successfully!!!", HttpStatus.OK);

    }
    @GetMapping("/Students")
    public ResponseEntity<?> getStudent(){
        List<Student> studentList = studentService.getStudent();
        return new ResponseEntity<>(studentList,HttpStatus.OK);
    }
    @DeleteMapping("/Students/{id}")
    public ResponseEntity<?> deleteByID(@PathVariable Long id){
        studentService.deleteByID(id);
        return new ResponseEntity<>("Deleted Successfully",HttpStatus.OK);

    }

    @PutMapping("Students/{id}")
    public ResponseEntity<?> updateById(@PathVariable Long id,@RequestBody Student student){
        studentService.updateById(id,student);
        return new ResponseEntity<>("Updated Successfully",HttpStatus.OK);
    }

}

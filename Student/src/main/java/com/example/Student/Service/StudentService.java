package com.example.Student.Service;

import com.example.Student.Entity.Student;
import com.example.Student.Model.StudentModel;
import com.example.Student.Repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepo studentRepo;
    public void addStudent(StudentModel studentModel) {
        Student student = new Student();
        student.setUsername(studentModel.getUsername());
        student.setDepartment(studentModel.getDepartment());
        student.setEmail(studentModel.getEmail());
        studentRepo.save(student);
    }

    public List<Student> getStudent() {
        List<Student> studentList = studentRepo.findAll();
        return studentList;
    }

    public void deleteByID(Long id) {
        if (id!=null) {
            studentRepo.deleteById(id);
        }

    }


    public void updateById(Long id, Student student ) {
        if(id!=null) {
            Student student1 = studentRepo.getReferenceById(id);
            student1.setEmail(student.getEmail());
            student1.setDepartment(student.getDepartment());
            student1.setUsername(student.getUsername());
            studentRepo.save(student1);
        }

    }
}

package com.example.myapp.service;

import com.example.myapp.dao.StudentDaoImpl;
import com.example.myapp.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Collection;
@Service
public class StudentService {
    @Autowired
    private StudentDaoImpl studentDao;

    public Collection<Student> getAllStudents() {
        return studentDao.getAllStudents();
    }
    public Student getStudentById(int id){
        return studentDao.getStudentById(id);
    }
    public void removeStudentById(int id) {
        this.studentDao.removeStudentById(id);
    }
    public void updateStudent(Student student){
        this.studentDao.updateStudent(student);
    }

    public void insertStudent(Student student) {
        this.studentDao.insertStudentToDb(student);
    }
}

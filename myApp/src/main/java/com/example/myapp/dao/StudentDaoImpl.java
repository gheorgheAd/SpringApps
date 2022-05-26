package com.example.myapp.dao;

import com.example.myapp.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class StudentDaoImpl implements StudentDao {
    private static Map<Integer, Student> students;

    static {
        students = new HashMap<Integer, Student>() {
            {
                put(1, new Student(1, "Adina", "Java Development"));
                put(2, new Student(2, "Maria", "CAD"));
                put(3, new Student(3, "Ioana", "Math"));
            }
        };
    }
    @Override
    public Collection<Student> getAllStudents() {
        return this.students.values();
    }

    @Override
    public Student getStudentById(int id){
        return this.students.get(id);
    }
    @Override
    public void removeStudentById(int id) {
        this.students.remove(id);
    }

    @Override
    public void updateStudent(Student student){
        Student student1 = students.get(student.getId());
        student1.setCourse(student.getCourse());
        student1.setName(student.getName());
        students.put(student.getId(),student);
    }

    @Override
    public void insertStudentToDb(Student student) {
        this.students.put(student.getId(),student);
    }
}

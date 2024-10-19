package ru.ushkalov.MySpringBoot3Dbase.service;

import org.springframework.stereotype.Service;
import ru.ushkalov.MySpringBoot3Dbase.entity.Student;

import java.util.List;

@Service
public interface StudentService {
    List<Student> getAllStudents();
    Student saveStudent(Student student);
    Student getStudent(int id);
    void deleteStudent(int id);
}

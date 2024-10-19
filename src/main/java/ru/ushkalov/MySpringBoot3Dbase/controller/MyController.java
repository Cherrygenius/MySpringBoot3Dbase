package ru.ushkalov.MySpringBoot3Dbase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ushkalov.MySpringBoot3Dbase.entity.Student;
import ru.ushkalov.MySpringBoot3Dbase.service.StudentService;
import ru.ushkalov.MySpringBoot3Dbase.model.Responce;
import ru.ushkalov.MySpringBoot3Dbase.model.Codes;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyController {
    @Autowired
    private StudentService studentService;
    @GetMapping("/students")
    public List<Student> allStudent()
    {
        List<Student> studentList = studentService.getAllStudents();
        return studentList;
    }
    @GetMapping("/students/{id}")
    public ResponseEntity<Responce> getStudent(@PathVariable("id") int id)
    {
        Responce response = Responce.builder().build();
        response.setCode(Codes.SUCCESS);
        try
        {
            response.setStudent(studentService.getStudent(id));
            if (response.getStudent() == null)
            {
                response.setCode(Codes.ERROR);
                response.setErrorMessage("Такого студента нет");
            }
        } catch (Exception e)
        {
            response.setCode(Codes.ERROR);
            response.setErrorMessage(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @PostMapping("/students")
    public ResponseEntity<Responce> saveStudent(@RequestBody Student student)
    {
        Responce response = Responce.builder().build();
        response.setCode(Codes.SUCCESS);
        try
        {
            response.setStudent(studentService.saveStudent(student));
        } catch (Exception e)
        {
            response.setCode(Codes.ERROR);
            response.setErrorMessage(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @PutMapping("/students")
    public ResponseEntity<Responce> updateStudent(@RequestBody Student student)
    {
        Responce response = Responce.builder().build();
        response.setCode(Codes.SUCCESS);
        try
        {
            response.setStudent(studentService.saveStudent(student));
        } catch (Exception e)
        {
            response.setCode(Codes.ERROR);
            response.setErrorMessage(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @DeleteMapping("/students/{id}")
    public ResponseEntity<Responce> deleteStudent(@PathVariable("id") int id)
    {
        Responce response = Responce.builder().build();
        response.setCode(Codes.ERROR);
        try
        {
            Student student = studentService.getStudent(id);
            if (student == null)
            {
                response.setCode(Codes.ERROR);
                response.setErrorMessage("Такого студента нет");
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
            studentService.deleteStudent(id);
        } catch (Exception e)
        {
            response.setCode(Codes.ERROR);
            response.setErrorMessage(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}

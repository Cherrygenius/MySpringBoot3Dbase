package ru.ushkalov.MySpringBoot3Dbase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.ushkalov.MySpringBoot3Dbase.entity.AcademicDiscipline;
import ru.ushkalov.MySpringBoot3Dbase.service.AcademicDisciplineService;

import java.util.List;

@RestController
@RequestMapping("/api_ad")
public class MyController2 {
    @Autowired
    private AcademicDisciplineService academicDisciplineService;
    @GetMapping("/Disciplines")
    public List<AcademicDiscipline> allDisciplines()
    {
        return academicDisciplineService.getAllDisciplines();
    }
    @GetMapping("/Disciplines/{id}")
    public AcademicDiscipline getDiscipline(@PathVariable("id") int id)
    {
        return academicDisciplineService.getDiscipline(id);
    }
    @PostMapping("/Disciplines")
    public AcademicDiscipline saveStudent(@RequestBody AcademicDiscipline academicDiscipline)
    {
        return academicDisciplineService.saveDiscipline(academicDiscipline);
    }
    @PutMapping("/Disciplines")
    public AcademicDiscipline updateStudent(@RequestBody AcademicDiscipline academicDiscipline)
    {
        return academicDisciplineService.saveDiscipline(academicDiscipline);
    }
    @DeleteMapping("/Disciplines/{id}")
    public void deleteStudent(@PathVariable("id") int id)
    {
        academicDisciplineService.deleteDiscipline(id);
    }
}

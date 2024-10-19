package ru.ushkalov.MySpringBoot3Dbase.service;


import org.springframework.stereotype.Service;
import ru.ushkalov.MySpringBoot3Dbase.entity.AcademicDiscipline;

import java.util.List;

@Service
public interface AcademicDisciplineService {

    List<AcademicDiscipline> getAllDisciplines();
    AcademicDiscipline saveDiscipline(AcademicDiscipline student);
    AcademicDiscipline getDiscipline(int id);
    void deleteDiscipline(int id);
}

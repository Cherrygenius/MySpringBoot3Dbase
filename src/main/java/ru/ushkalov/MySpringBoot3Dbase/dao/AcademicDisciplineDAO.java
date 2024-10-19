package ru.ushkalov.MySpringBoot3Dbase.dao;

import ru.ushkalov.MySpringBoot3Dbase.entity.AcademicDiscipline;

import java.util.List;

public interface AcademicDisciplineDAO {
    List<AcademicDiscipline> getAllDisciplines();
    AcademicDiscipline saveDiscipline(AcademicDiscipline discipline);
    AcademicDiscipline getDiscipline(int id);
    void deleteDiscipline(int id);
}

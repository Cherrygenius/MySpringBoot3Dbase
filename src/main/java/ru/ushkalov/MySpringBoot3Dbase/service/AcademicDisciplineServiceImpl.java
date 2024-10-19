package ru.ushkalov.MySpringBoot3Dbase.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ushkalov.MySpringBoot3Dbase.dao.AcademicDisciplineDAO;
import ru.ushkalov.MySpringBoot3Dbase.entity.AcademicDiscipline;

import java.util.List;

@Service
public class AcademicDisciplineServiceImp implements AcademicDisciplineService {
    @Autowired
    private AcademicDisciplineDAO academicDisciplineDao;
    @Override
    @Transactional
    public List<AcademicDiscipline> getAllDisciplines()
    {
        return academicDisciplineDao.getAllDisciplines();
    }
    @Override
    @Transactional
    public AcademicDiscipline saveDiscipline(AcademicDiscipline academicDiscipline)
    {
        return academicDisciplineDao.saveDiscipline(academicDiscipline);
    }
    @Override
    @Transactional
    public AcademicDiscipline getDiscipline(int id)
    {
        return academicDisciplineDao.getDiscipline(id);
    }
    @Override
    @Transactional
    public void deleteDiscipline(int id)
    {
        academicDisciplineDao.deleteDiscipline(id);
    }
}

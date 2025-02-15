package ru.ushkalov.MySpringBoot3Dbase.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.ushkalov.MySpringBoot3Dbase.entity.AcademicDiscipline;

import java.util.List;

@Slf4j
@Repository
public class AcademicDisciplineDAOImpl implements AcademicDisciplineDAO {
    @Autowired
    private EntityManager entityManager;
    @Override
    public List<AcademicDiscipline> getAllDisciplines()
    {
        Query query = entityManager.createQuery("from AcademicDiscipline");
        List<AcademicDiscipline> allDiscipline = query.getResultList();
        log.info("getAllDiscipline" + allDiscipline);
        return allDiscipline;
    }
    @Override
    public AcademicDiscipline saveDiscipline(AcademicDiscipline discipline)
    {
        entityManager.merge(discipline);
        return discipline;
    }
    @Override
    public AcademicDiscipline getDiscipline(int id)
    {
        return entityManager.find(AcademicDiscipline.class, id);
    }
    @Override
    public void deleteDiscipline(int id)
    {
        Query query = entityManager.createQuery("delete from AcademicDiscipline " +
                " where id =:DisciplineId");
        query.setParameter("DisciplineId", id);
        query.executeUpdate();
    }
}

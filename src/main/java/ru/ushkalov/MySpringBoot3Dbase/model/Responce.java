package ru.ushkalov.MySpringBoot3Dbase.model;

import lombok.Builder;
import lombok.Data;
import ru.ushkalov.MySpringBoot3Dbase.entity.Student;

@Data
@Builder
public class Responce {
    private Codes code;
    private String errorMessage;
    private Student student;
    @Override
    public String toString()
    {
        return "{" +
                ", code'" + code.toString() + '\'' +
                ", errorMessage'" + errorMessage + '\'' +
                ", errorMessage'" + student.toString() + '}';
    }
}

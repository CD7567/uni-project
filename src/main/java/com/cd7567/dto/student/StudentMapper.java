package com.cd7567.dto.student;

import com.cd7567.dto.scoreboard.ScoreMapper;
import com.cd7567.entities.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.Set;

@Mapper(
        componentModel = "jakarta",
        uses = ScoreMapper.class
)
public interface StudentMapper {
    @Mapping(target = "id", source = "student.id")
    @Mapping(target = "name", expression = "java(student.getFirstName() + ' ' + student.getLastName())")
    StudentBriefGetDTO toBriefDTO(Student student);

    List<StudentBriefGetDTO> toBriefDTO(List<Student> students);
    Set<StudentBriefGetDTO> toBriefDTO(Set<Student> students);

    @Mapping(target = "id", source = "student.id")
    @Mapping(target = "firstName", source = "student.firstName")
    @Mapping(target = "lastName", source = "student.lastName")
    @Mapping(target = "group", source = "student.group.number")
    StudentInfoGetDTO toInfoDTO(Student student);

    List<StudentInfoGetDTO> toInfoDTO(List<Student> students);
    Set<StudentInfoGetDTO> toInfoDTO(Set<Student> students);

    @Mapping(target = "id", source = "student.id")
    @Mapping(target = "name", expression = "java(student.getFirstName() + ' ' + student.getLastName())")
    @Mapping(target = "marks", source = "student.marks")
    StudentMarkGetDTO toMarkDTO(Student student);

    List<StudentMarkGetDTO> toMarkDTO(List<Student> students);
    Set<StudentMarkGetDTO> toMarkDTO(Set<Student> students);
}

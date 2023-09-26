package com.cd7567.dto.student;

import com.cd7567.dto.professor.ProfessorPutDTO;
import com.cd7567.dto.scoreboard.ScoreMapper;
import com.cd7567.entities.Professor;
import com.cd7567.entities.Student;
import com.cd7567.repositories.ReferenceLoader;
import jakarta.transaction.Transactional;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.Set;

@Mapper(
        componentModel = "jakarta",
        uses = {
                ScoreMapper.class,
                ReferenceLoader.class
        }
)
@Transactional(Transactional.TxType.MANDATORY)
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

    @Mapping(target = "id", source = "dto.id")
    @Mapping(target = "firstName", source = "dto.firstName")
    @Mapping(target = "lastName", source = "dto.lastName")
    @Mapping(
            target = "group",
            source = "dto.groupId",
            qualifiedByName = {"ReferenceLoader", "getGroupReferenceById"}
    )
    @Mapping(
            target = "courses",
            source = "dto.courseIds",
            qualifiedByName = {"ReferenceLoader", "getCourseReferenceById"}
    )
    @Mapping(
            target = "planItems",
            source = "dto.studentPlanIds",
            qualifiedByName = {"ReferenceLoader", "getPlanReferenceById"}
    )
    @Mapping(
            target = "marks",
            source = "dto.markIds",
            qualifiedByName = {"ReferenceLoader", "getScoreReferenceById"}
    )
    Student fromPutDTO(StudentPutDTO dto);

    List<Student> fromPutDTO(List<StudentPutDTO> dto);
    Set<Student> fromPutDTO(Set<StudentPutDTO> dto);
}

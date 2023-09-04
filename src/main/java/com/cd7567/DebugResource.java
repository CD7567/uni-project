package com.cd7567;

import com.cd7567.dto.course.CourseBriefGetDTO;
import com.cd7567.dto.course.CourseMapper;
import com.cd7567.dto.direction.DirectionBriefGetDTO;
import com.cd7567.dto.direction.DirectionMapper;
import com.cd7567.dto.faculty.FacultyBriefGetDTO;
import com.cd7567.dto.faculty.FacultyMapper;
import com.cd7567.dto.group.GroupBriefGetDTO;
import com.cd7567.dto.group.GroupMapper;
import com.cd7567.dto.person.PersonBriefGetDTO;
import com.cd7567.dto.person.PersonMapper;
import com.cd7567.dto.professor.ProfessorBriefGetDTO;
import com.cd7567.dto.professor.ProfessorMapper;
import com.cd7567.dto.student.StudentBriefGetDTO;
import com.cd7567.dto.student.StudentMapper;
import com.cd7567.dto.subject.SubjectBriefGetDTO;
import com.cd7567.dto.subject.SubjectMapper;
import com.cd7567.repositories.*;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/debug")
public class DebugResource {
    @Inject
    CourseMapper courseMapper;

    @Inject
    DirectionMapper directionMapper;

    @Inject
    FacultyMapper facultyMapper;

    @Inject
    GroupMapper groupMapper;

    @Inject
    PersonMapper personMapper;

    @Inject
    ProfessorMapper professorMapper;

    @Inject
    StudentMapper studentMapper;

    @Inject
    SubjectMapper subjectMapper;

    @Inject
    CourseRepo courseRepo;

    @Inject
    DirectionRepo directionRepo;

    @Inject
    FacultyRepo facultyRepo;

    @Inject
    GroupRepo groupRepo;

    @Inject
    PersonRepo personRepo;

    @Inject
    ProfessorRepo professorRepo;

    @Inject
    StudentRepo studentRepo;

    @Inject
    SubjectRepo subjectRepo;

    @GET
    @Path("/course")
    @Produces(MediaType.APPLICATION_JSON)
    public List<CourseBriefGetDTO> getBriefCourses() {
        return courseRepo.streamAll()
                .map(it -> courseMapper.toBriefDTO(it))
                .toList();
    }

    @GET
    @Path("/direction")
    @Produces(MediaType.APPLICATION_JSON)
    public List<DirectionBriefGetDTO> getBriefDirections() {
        return directionRepo.streamAll()
                .map(it -> directionMapper.toBriefDTO(it))
                .toList();
    }

    @GET
    @Path("/faculty")
    @Produces(MediaType.APPLICATION_JSON)
    public List<FacultyBriefGetDTO> getBriefFaculties() {
        return facultyRepo.streamAll()
                .map(it -> facultyMapper.toBriefDTO(it))
                .toList();
    }

    @GET
    @Path("/group")
    @Produces(MediaType.APPLICATION_JSON)
    public List<GroupBriefGetDTO> getBriefGroups() {
        return groupRepo.streamAll()
                .map(it -> groupMapper.toBriefDTO(it))
                .toList();
    }

    @GET
    @Path("/person")
    @Produces(MediaType.APPLICATION_JSON)
    public List<PersonBriefGetDTO> getBriefPeople() {
        return personRepo.streamAll()
                .map(it -> personMapper.toBriefDTO(it))
                .toList();
    }

    @GET
    @Path("/professor")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProfessorBriefGetDTO> getBriefProfessors() {
        return professorRepo.streamAll()
                .map(it -> professorMapper.toBriefDTO(it))
                .toList();
    }

    @GET
    @Path("/student")
    @Produces(MediaType.APPLICATION_JSON)
    public List<StudentBriefGetDTO> getBriefStudent() {
        return studentRepo.streamAll()
                .map(it -> studentMapper.toBriefDTO(it))
                .toList();
    }

    @GET
    @Path("/subject")
    @Produces(MediaType.APPLICATION_JSON)
    public List<SubjectBriefGetDTO> getBriefSubjects() {
        return subjectRepo.streamAll()
                .map(it -> subjectMapper.toBriefDTO(it))
                .toList();
    }
}

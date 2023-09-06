package com.cd7567;

import com.cd7567.dto.group.GroupPutDTO;
import com.cd7567.dto.person.PersonBriefGetDTO;
import com.cd7567.dto.person.PersonInfoGetDTO;
import com.cd7567.dto.professor.ProfessorBriefGetDTO;
import com.cd7567.dto.professor.ProfessorPutDTO;
import com.cd7567.dto.scoreboard.ScorePutDTO;
import com.cd7567.dto.student.StudentBriefGetDTO;
import com.cd7567.dto.student.StudentInfoGetDTO;
import com.cd7567.dto.student.StudentPutDTO;
import com.cd7567.services.GroupService;
import com.cd7567.services.PersonService;
import com.cd7567.services.ProfessorService;
import com.cd7567.services.StudentService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/people")
public class PeopleResource {
    @Inject
    PersonService personService;

    @Inject
    ProfessorService professorService;

    @Inject
    StudentService studentService;

    @Inject
    GroupService groupService;

    @GET
    @Path("/person/brief")
    public List<PersonBriefGetDTO> getPeopleBrief() {
        return personService.getPeopleBrief();
    }

    @GET
    @Path("/person/info")
    public List<PersonInfoGetDTO> getPeopleInfo() {
        return personService.getPeopleInfo();
    }

    @GET
    @Path("/professor/brief")
    public List<ProfessorBriefGetDTO> getProfessorInfo() {
        return professorService.getBrief();
    }

    @GET
    @Path("/student/brief")
    public List<StudentBriefGetDTO> getStudentInfo() {
        return studentService.getBrief();
    }

    @GET
    @Path("/student/group")
    public List<StudentInfoGetDTO> getStudentByGroupId(
            @QueryParam("id") Long groupId
    ) {
        return studentService.getByGroupId(groupId);
    }

    @GET
    @Path("/course/students")
    public List<StudentInfoGetDTO> getStudentByCourseId(
            @QueryParam("id") Long courseId
    ) {
        return studentService.getByCourseId(courseId);
    }

    @GET
    @Path("/subject/students")
    public List<StudentInfoGetDTO> getStudentBySubjectId(
            @QueryParam("id") Long subjectId
    ) {
        return studentService.getBySubjectId(subjectId);
    }

    @GET
    @Path("/term/students")
    public List<StudentInfoGetDTO> getStudentByGroupId(
            @QueryParam("term") Integer term
    ) {
        return studentService.getByTerm(term);
    }

    @PUT
    @Path("/professor")
    @Produces(MediaType.TEXT_PLAIN)
    public Long persistProfessor(ProfessorPutDTO dto) {
        return professorService.persistFromDTO(dto);
    }

    @PUT
    @Path("/student")
    @Produces(MediaType.TEXT_PLAIN)
    public Long persistStudent(StudentPutDTO dto) {
        return studentService.persistFromDTO(dto);
    }

    @PUT
    @Path("/group")
    @Produces(MediaType.TEXT_PLAIN)
    public Long persistGroup(GroupPutDTO dto) {
        return groupService.persistFromDTO(dto);
    }
}

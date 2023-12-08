package com.cd7567.uni;

import com.cd7567.uni.model.api.group.GroupPutDTO;
import com.cd7567.uni.model.api.person.PersonBriefGetDTO;
import com.cd7567.uni.model.api.person.PersonInfoGetDTO;
import com.cd7567.uni.model.api.professor.ProfessorBriefGetDTO;
import com.cd7567.uni.model.api.professor.ProfessorPutDTO;
import com.cd7567.uni.model.api.student.StudentBriefGetDTO;
import com.cd7567.uni.model.api.student.StudentInfoGetDTO;
import com.cd7567.uni.model.api.student.StudentPutDTO;
import com.cd7567.uni.service.GroupService;
import com.cd7567.uni.service.PersonService;
import com.cd7567.uni.service.ProfessorService;
import com.cd7567.uni.service.StudentService;
import io.quarkus.security.Authenticated;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/people")
@Authenticated
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
    @RolesAllowed("user")
    public List<PersonBriefGetDTO> getPeopleBrief() {
        return personService.getPeopleBrief();
    }

    @GET
    @Path("/person/info")
    @RolesAllowed("user")
    public List<PersonInfoGetDTO> getPeopleInfo() {
        return personService.getPeopleInfo();
    }

    @GET
    @Path("/professor/brief")
    @RolesAllowed("user")
    public List<ProfessorBriefGetDTO> getProfessorInfo() {
        return professorService.getBrief();
    }

    @GET
    @Path("/student/brief")
    @RolesAllowed("user")
    public List<StudentBriefGetDTO> getStudentInfo() {
        return studentService.getBrief();
    }

    @GET
    @Path("/student/group")
    @RolesAllowed("user")
    public List<StudentInfoGetDTO> getStudentByGroupId(
            @QueryParam("id") Long groupId
    ) {
        return studentService.getByGroupId(groupId);
    }

    @GET
    @Path("/course/students")
    @RolesAllowed("user")
    public List<StudentInfoGetDTO> getStudentByCourseId(
            @QueryParam("id") Long courseId
    ) {
        return studentService.getByCourseId(courseId);
    }

    @GET
    @Path("/subject/students")
    @RolesAllowed("user")
    public List<StudentInfoGetDTO> getStudentBySubjectId(
            @QueryParam("id") Long subjectId
    ) {
        return studentService.getBySubjectId(subjectId);
    }

    @GET
    @Path("/term/students")
    @RolesAllowed("user")
    public List<StudentInfoGetDTO> getStudentByGroupId(
            @QueryParam("term") Integer term
    ) {
        return studentService.getByTerm(term);
    }

    @POST
    @Path("/professor")
    @RolesAllowed("hr")
    @Produces(MediaType.TEXT_PLAIN)
    public Long persistProfessor(ProfessorPutDTO dto) {
        return professorService.persistFromDTO(dto);
    }

    @POST
    @Path("/student")
    @RolesAllowed("hr")
    @Produces(MediaType.TEXT_PLAIN)
    public Long persistStudent(StudentPutDTO dto) {
        return studentService.persistFromDTO(dto);
    }

    @POST
    @Path("/group")
    @RolesAllowed("hr")
    @Produces(MediaType.TEXT_PLAIN)
    public Long persistGroup(GroupPutDTO dto) {
        return groupService.persistFromDTO(dto);
    }
}

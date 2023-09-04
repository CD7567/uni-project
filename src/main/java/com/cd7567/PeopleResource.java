package com.cd7567;

import com.cd7567.dto.person.PersonBriefGetDTO;
import com.cd7567.dto.person.PersonInfoGetDTO;
import com.cd7567.dto.professor.ProfessorBriefGetDTO;
import com.cd7567.dto.student.StudentBriefGetDTO;
import com.cd7567.dto.student.StudentInfoGetDTO;
import com.cd7567.services.PersonService;
import com.cd7567.services.ProfessorService;
import com.cd7567.services.StudentService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;

import java.util.List;

@Path("/people")
public class PeopleResource {
    @Inject
    PersonService personService;

    @Inject
    ProfessorService professorService;

    @Inject
    StudentService studentService;

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
    @Path("/student/course")
    public List<StudentInfoGetDTO> getStudentByCourseId(
            @QueryParam("id") Long courseId
    ) {
        return studentService.getByCourseId(courseId);
    }

    @GET
    @Path("/student/subject")
    public List<StudentInfoGetDTO> getStudentBySubjectId(
            @QueryParam("id") Long subjectId
    ) {
        return studentService.getBySubjectId(subjectId);
    }

    @GET
    @Path("/student/term")
    public List<StudentInfoGetDTO> getStudentByGroupId(
            @QueryParam("term") Integer term
    ) {
        return studentService.getByTerm(term);
    }
}

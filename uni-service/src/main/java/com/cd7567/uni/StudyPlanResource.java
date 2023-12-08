package com.cd7567.uni;

import com.cd7567.uni.model.api.professor.ProfessorBriefGetDTO;
import com.cd7567.uni.model.api.studentplan.StudentPlanPutDTO;
import com.cd7567.uni.model.api.subject.SubjectInfoGetDTO;
import com.cd7567.uni.model.api.subject.SubjectPutDTO;
import com.cd7567.uni.service.ProfessorService;
import com.cd7567.uni.service.StudentPlanService;
import com.cd7567.uni.service.SubjectService;
import io.quarkus.security.Authenticated;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/plan")
@Authenticated
public class StudyPlanResource {
    @Inject
    SubjectService subjectService;

    @Inject
    ProfessorService professorService;

    @Inject
    StudentPlanService studentPlanService;

    @GET
    @Path("/subject/faculty")
    @RolesAllowed("user")
    @Produces(MediaType.APPLICATION_JSON)
    public List<SubjectInfoGetDTO> getSubjectByFacultyId(
            @QueryParam("id") Long id
    ) {
        return subjectService.getByFacultyId(id);
    }

    @GET
    @Path("/subject/direction")
    @RolesAllowed("user")
    @Produces(MediaType.APPLICATION_JSON)
    public List<SubjectInfoGetDTO> getSubjectByDirectionId(
            @QueryParam("id") Long id
    ) {
        return subjectService.getByDirectionId(id);
    }

    @GET
    @Path("/subject/course")
    @RolesAllowed("user")
    @Produces(MediaType.APPLICATION_JSON)
    public List<SubjectInfoGetDTO> getSubjectByCourseId(
            @QueryParam("id") Long id
    ) {
        return subjectService.getByCourseId(id);
    }

    @GET
    @Path("/seminarist/subject")
    @RolesAllowed("user")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProfessorBriefGetDTO> getSeminaristBySubjectId(
            @QueryParam("id") Long id
    ) {
        return professorService.getSeminaristsBySubjectId(id);
    }

    @GET
    @Path("/lecturer/subject")
    @RolesAllowed("user")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProfessorBriefGetDTO> getLecturerBySubjectId(
            @QueryParam("id") Long id
    ) {
        return professorService.getLecturersBySubjectId(id);
    }

    @POST
    @Path("/student/plan")
    @RolesAllowed("user")
    @Produces(MediaType.TEXT_PLAIN)
    public Long persistStudentPlan(StudentPlanPutDTO dto) {
        return studentPlanService.persistFromDTO(dto);
    }

    @POST
    @Path("/subject")
    @RolesAllowed("rectorate")
    @Produces(MediaType.TEXT_PLAIN)
    public Long persistScoreRecord(SubjectPutDTO dto) {
        return subjectService.persistFromDTO(dto);
    }
}

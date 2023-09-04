package com.cd7567;

import com.cd7567.dto.professor.ProfessorBriefGetDTO;
import com.cd7567.dto.subject.SubjectInfoGetDTO;
import com.cd7567.services.ProfessorService;
import com.cd7567.services.SubjectService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/plan")
public class StudyPlanResource {
    @Inject
    SubjectService subjectService;

    @Inject
    ProfessorService professorService;

    @GET
    @Path("/subject/faculty")
    @Produces(MediaType.APPLICATION_JSON)
    public List<SubjectInfoGetDTO> getSubjectByFacultyId(
            @QueryParam("id") Long id
    ) {
        return subjectService.getByFacultyId(id);
    }

    @GET
    @Path("/subject/direction")
    @Produces(MediaType.APPLICATION_JSON)
    public List<SubjectInfoGetDTO> getSubjectByDirectionId(
            @QueryParam("id") Long id
    ) {
        return subjectService.getByDirectionId(id);
    }

    @GET
    @Path("/subject/course")
    @Produces(MediaType.APPLICATION_JSON)
    public List<SubjectInfoGetDTO> getSubjectByCourseId(
            @QueryParam("id") Long id
    ) {
        return subjectService.getByCourseId(id);
    }

    @GET
    @Path("/seminarist/subject")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProfessorBriefGetDTO> getSeminaristBySubjectId(
            @QueryParam("id") Long id
    ) {
        return professorService.getSeminaristsBySubjectId(id);
    }

    @GET
    @Path("/lecturer/subject")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProfessorBriefGetDTO> getLecturerBySubjectId(
            @QueryParam("id") Long id
    ) {
        return professorService.getLecturersBySubjectId(id);
    }
}

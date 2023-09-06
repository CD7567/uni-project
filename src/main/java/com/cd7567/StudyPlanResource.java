package com.cd7567;

import com.cd7567.dto.professor.ProfessorBriefGetDTO;
import com.cd7567.dto.scoreboard.ScorePutDTO;
import com.cd7567.dto.studentplan.StudentPlanPutDTO;
import com.cd7567.dto.subject.SubjectInfoGetDTO;
import com.cd7567.dto.subject.SubjectPutDTO;
import com.cd7567.services.ProfessorService;
import com.cd7567.services.StudentPlanService;
import com.cd7567.services.SubjectService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/plan")
public class StudyPlanResource {
    @Inject
    SubjectService subjectService;

    @Inject
    ProfessorService professorService;

    @Inject
    StudentPlanService studentPlanService;

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

    @PUT
    @Path("/student/plan")
    @Produces(MediaType.TEXT_PLAIN)
    public Long persistStudentPlan(StudentPlanPutDTO dto) {
        return studentPlanService.persistFromDTO(dto);
    }

    @PUT
    @Path("/subject")
    @Produces(MediaType.TEXT_PLAIN)
    public Long persistScoreRecord(SubjectPutDTO dto) {
        return subjectService.persistFromDTO(dto);
    }
}

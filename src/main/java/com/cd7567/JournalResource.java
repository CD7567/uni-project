package com.cd7567;

import com.cd7567.dto.scoreboard.ScoreBriefGetDTO;
import com.cd7567.dto.scoreboard.ScorePutDTO;
import com.cd7567.dto.scoreboard.ScoreStudentGetDTO;
import com.cd7567.dto.student.StudentMarkGetDTO;
import com.cd7567.services.ScoreBoardService;
import com.cd7567.services.StudentService;
import io.quarkus.security.Authenticated;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/journal")
@Authenticated
public class JournalResource {
    @Inject
    StudentService studentService;

    @Inject
    ScoreBoardService scoreBoardService;

    @GET
    @Path("/seminarist/students")
    @RolesAllowed("user")
    @Produces(MediaType.APPLICATION_JSON)
    public List<StudentMarkGetDTO> getStudentsBySeminaristId(
            @QueryParam("id") Long id
    ) {
        return studentService.getBySeminaristId(id);
    }

    @GET
    @Path("/lecturer/students")
    @RolesAllowed("user")
    @Produces(MediaType.APPLICATION_JSON)
    public List<StudentMarkGetDTO> getStudentsByLecturerId(
            @QueryParam("id") Long id
    ) {
        return studentService.getByLecturerId(id);
    }

    @GET
    @Path("/student/mark")
    @RolesAllowed({"lecturer", "seminarist", "admin"})
    @Produces(MediaType.APPLICATION_JSON)
    public List<ScoreBriefGetDTO> getMarkByStudentId(
            @QueryParam("id") Long id
    ) {
        return scoreBoardService.getByStudentId(id);
    }

    @GET
    @Path("/group/mark")
    @RolesAllowed({"lecturer", "seminarist", "admin"})
    @Produces(MediaType.APPLICATION_JSON)
    public List<ScoreStudentGetDTO> getMarkByGroupId(
            @QueryParam("id") Long id
    ) {
        return scoreBoardService.getByGroupId(id);
    }

    @PUT
    @Path("/mark")
    @RolesAllowed({"lecturer", "seminarist", "admin"})
    @Produces(MediaType.TEXT_PLAIN)
    public Long persistScoreRecord(ScorePutDTO dto) {
        return scoreBoardService.persistFromDTO(dto);
    }
}

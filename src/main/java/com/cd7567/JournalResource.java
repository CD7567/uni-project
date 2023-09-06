package com.cd7567;

import com.cd7567.dto.scoreboard.ScoreBriefGetDTO;
import com.cd7567.dto.scoreboard.ScorePutDTO;
import com.cd7567.dto.scoreboard.ScoreStudentGetDTO;
import com.cd7567.dto.student.StudentMarkGetDTO;
import com.cd7567.services.ScoreBoardService;
import com.cd7567.services.StudentService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/journal")
public class JournalResource {
    @Inject
    StudentService studentService;

    @Inject
    ScoreBoardService scoreBoardService;

    @GET
    @Path("/seminarist/students")
    @Produces(MediaType.APPLICATION_JSON)
    public List<StudentMarkGetDTO> getStudentsBySeminaristId(
            @QueryParam("id") Long id
    ) {
        return studentService.getBySeminaristId(id);
    }

    @GET
    @Path("/lecturer/students")
    @Produces(MediaType.APPLICATION_JSON)
    public List<StudentMarkGetDTO> getStudentsByLecturerId(
            @QueryParam("id") Long id
    ) {
        return studentService.getByLecturerId(id);
    }

    @GET
    @Path("/student/mark")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ScoreBriefGetDTO> getMarkByStudentId(
            @QueryParam("id") Long id
    ) {
        return scoreBoardService.getByStudentId(id);
    }

    @GET
    @Path("/group/mark")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ScoreStudentGetDTO> getMarkByGroupId(
            @QueryParam("id") Long id
    ) {
        return scoreBoardService.getByGroupId(id);
    }

    @PUT
    @Path("/mark")
    @Produces(MediaType.TEXT_PLAIN)
    public Long persistScoreRecord(ScorePutDTO dto) {
        return scoreBoardService.persistFromDTO(dto);
    }
}

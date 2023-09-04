package com.cd7567;

import com.cd7567.dto.scoreboard.ScoreBriefGetDTO;
import com.cd7567.dto.scoreboard.ScoreStudentGetDTO;
import com.cd7567.dto.student.StudentMarkGetDTO;
import com.cd7567.services.ScoreBoardService;
import com.cd7567.services.StudentService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/journal")
public class JournalResource {
    @Inject
    StudentService studentService;

    @Inject
    ScoreBoardService scoreBoardService;

    @GET
    @Path("/student/seminarist")
    @Produces(MediaType.APPLICATION_JSON)
    public List<StudentMarkGetDTO> getStudentsBySeminaristId(
            @QueryParam("id") Long id
    ) {
        return studentService.getBySeminaristId(id);
    }

    @GET
    @Path("/student/lecturer")
    @Produces(MediaType.APPLICATION_JSON)
    public List<StudentMarkGetDTO> getStudentsByLecturerId(
            @QueryParam("id") Long id
    ) {
        return studentService.getByLecturerId(id);
    }

    @GET
    @Path("/mark/student")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ScoreBriefGetDTO> getMarkByStudentId(
            @QueryParam("id") Long id
    ) {
        return scoreBoardService.getByStudentId(id);
    }

    @GET
    @Path("/mark/group")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ScoreStudentGetDTO> getMarkByGroupId(
            @QueryParam("id") Long id
    ) {
        return scoreBoardService.getByGroupId(id);
    }
}

package com.cd7567;

import com.cd7567.dto.course.CoursePutDTO;
import com.cd7567.dto.direction.DirectionPutDTO;
import com.cd7567.dto.faculty.*;
import com.cd7567.dto.scoreboard.ScorePutDTO;
import com.cd7567.services.CourseService;
import com.cd7567.services.DirectionService;
import com.cd7567.services.FacultyService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/structure")
public class StructureResource {
    @Inject
    FacultyService facultyService;

    @Inject
    DirectionService directionService;

    @Inject
    CourseService courseService;

    @GET
    @Path("/faculty")
    @Produces(MediaType.APPLICATION_JSON)
    public List<FacultyBriefGetDTO> getBrief() {
        return facultyService.getFacultiesBriefDTO();
    }

    @GET
    @Path("/direction")
    @Produces(MediaType.APPLICATION_JSON)
    public List<FacultyDirGetDTO> getDownToDirection() {
        return facultyService.getFacultiesDirDTO();
    }

    @GET
    @Path("/course")
    @Produces(MediaType.APPLICATION_JSON)
    public List<FacultyCourseGetDTO> getDownToCourse() {
        return facultyService.getFacultiesCourseDTO();
    }

    @GET
    @Path("/subject")
    @Produces(MediaType.APPLICATION_JSON)
    public List<FacultySubjectGetDTO> getDownToSubject() {
        return facultyService.getFacultiesSubjectDTO();
    }

    @PUT
    @Path("/faculty")
    @Produces(MediaType.TEXT_PLAIN)
    public Long persistFaculty(FacultyPutDTO dto) {
        return facultyService.persistFromDTO(dto);
    }

    @PUT
    @Path("/direction")
    @Produces(MediaType.TEXT_PLAIN)
    public Long persistDirection(DirectionPutDTO dto) {
        return directionService.persistFromDTO(dto);
    }

    @PUT
    @Path("/course")
    @Produces(MediaType.TEXT_PLAIN)
    public Long persistCourse(CoursePutDTO dto) {
        return courseService.persistFromDTO(dto);
    }
}

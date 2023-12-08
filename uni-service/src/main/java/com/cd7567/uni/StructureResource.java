package com.cd7567.uni;

import com.cd7567.uni.model.api.course.CoursePutDTO;
import com.cd7567.uni.model.api.direction.DirectionPutDTO;
import com.cd7567.uni.model.api.faculty.*;
import com.cd7567.uni.service.CourseService;
import com.cd7567.uni.service.DirectionService;
import com.cd7567.uni.service.FacultyService;
import io.quarkus.security.Authenticated;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/structure")
@Authenticated
public class StructureResource {
    @Inject
    FacultyService facultyService;

    @Inject
    DirectionService directionService;

    @Inject
    CourseService courseService;

    @GET
    @Path("/faculty")
    @RolesAllowed("user")
    @Produces(MediaType.APPLICATION_JSON)
    public List<FacultyBriefGetDTO> getBrief() {
        return facultyService.getFacultiesBriefDTO();
    }

    @GET
    @Path("/direction")
    @RolesAllowed("user")
    @Produces(MediaType.APPLICATION_JSON)
    public List<FacultyDirGetDTO> getDownToDirection() {
        return facultyService.getFacultiesDirDTO();
    }

    @GET
    @Path("/course")
    @RolesAllowed("user")
    @Produces(MediaType.APPLICATION_JSON)
    public List<FacultyCourseGetDTO> getDownToCourse() {
        return facultyService.getFacultiesCourseDTO();
    }

    @GET
    @Path("/subject")
    @RolesAllowed("user")
    @Produces(MediaType.APPLICATION_JSON)
    public List<FacultySubjectGetDTO> getDownToSubject() {
        return facultyService.getFacultiesSubjectDTO();
    }

    @POST
    @Path("/faculty")
    @RolesAllowed("rectorate")
    @Produces(MediaType.TEXT_PLAIN)
    public Long persistFaculty(FacultyPutDTO dto) {
        return facultyService.persistFromDTO(dto);
    }

    @POST
    @Path("/direction")
    @RolesAllowed("rectorate")
    @Produces(MediaType.TEXT_PLAIN)
    public Long persistDirection(DirectionPutDTO dto) {
        return directionService.persistFromDTO(dto);
    }

    @POST
    @Path("/course")
    @RolesAllowed("rectorate")
    @Produces(MediaType.TEXT_PLAIN)
    public Long persistCourse(CoursePutDTO dto) {
        return courseService.persistFromDTO(dto);
    }
}

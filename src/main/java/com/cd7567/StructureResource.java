package com.cd7567;

import com.cd7567.dto.faculty.FacultyBriefGetDTO;
import com.cd7567.dto.faculty.FacultyCourseGetDTO;
import com.cd7567.dto.faculty.FacultyDirGetDTO;
import com.cd7567.dto.faculty.FacultySubjectGetDTO;
import com.cd7567.services.FacultyService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/structure")
public class StructureResource {
    @Inject
    FacultyService facultyService;

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
}

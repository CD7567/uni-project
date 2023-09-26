package com.cd7567;

import com.cd7567.dto.course.CourseBriefGetDTO;
import com.cd7567.dto.course.CourseMapper;
import com.cd7567.dto.direction.DirectionBriefGetDTO;
import com.cd7567.dto.direction.DirectionMapper;
import com.cd7567.dto.faculty.FacultyBriefGetDTO;
import com.cd7567.dto.faculty.FacultyMapper;
import com.cd7567.dto.group.GroupBriefGetDTO;
import com.cd7567.dto.group.GroupMapper;
import com.cd7567.dto.person.PersonBriefGetDTO;
import com.cd7567.dto.person.PersonMapper;
import com.cd7567.dto.professor.ProfessorBriefGetDTO;
import com.cd7567.dto.professor.ProfessorMapper;
import com.cd7567.dto.scoreboard.ScoreTableDTO;
import com.cd7567.dto.student.StudentBriefGetDTO;
import com.cd7567.dto.student.StudentMapper;
import com.cd7567.dto.subject.SubjectBriefGetDTO;
import com.cd7567.dto.subject.SubjectMapper;
import com.cd7567.entities.*;
import com.cd7567.repositories.*;
import io.quarkus.arc.profile.IfBuildProfile;
import jakarta.enterprise.inject.Typed;
import jakarta.inject.Inject;
import jakarta.inject.Scope;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Tuple;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Fetch;
import jakarta.persistence.criteria.Root;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import org.hibernate.query.Query;

import java.lang.reflect.Type;
import java.util.List;

@Path("/debug")
@IfBuildProfile("dev")
public class DebugResource {
    @Inject
    EntityManager entityManager;

    @Inject
    CourseMapper courseMapper;

    @Inject
    DirectionMapper directionMapper;

    @Inject
    FacultyMapper facultyMapper;

    @Inject
    GroupMapper groupMapper;

    @Inject
    PersonMapper personMapper;

    @Inject
    ProfessorMapper professorMapper;

    @Inject
    StudentMapper studentMapper;

    @Inject
    SubjectMapper subjectMapper;

    @Inject
    CourseRepo courseRepo;

    @Inject
    DirectionRepo directionRepo;

    @Inject
    FacultyRepo facultyRepo;

    @Inject
    GroupRepo groupRepo;

    @Inject
    PersonRepo personRepo;

    @Inject
    ProfessorRepo professorRepo;

    @Inject
    StudentRepo studentRepo;

    @Inject
    SubjectRepo subjectRepo;

    @GET
    @Path("/course")
    @Produces(MediaType.APPLICATION_JSON)
    public List<CourseBriefGetDTO> getBriefCourses() {
        return courseRepo.streamAll()
                .map(it -> courseMapper.toBriefDTO(it))
                .toList();
    }

    @GET
    @Path("/direction")
    @Produces(MediaType.APPLICATION_JSON)
    public List<DirectionBriefGetDTO> getBriefDirections() {
        return directionRepo.streamAll()
                .map(it -> directionMapper.toBriefDTO(it))
                .toList();
    }

    @GET
    @Path("/faculty")
    @Produces(MediaType.APPLICATION_JSON)
    public List<FacultyBriefGetDTO> getBriefFaculties() {
        return facultyRepo.streamAll()
                .map(it -> facultyMapper.toBriefDTO(it))
                .toList();
    }

    @GET
    @Path("/group")
    @Produces(MediaType.APPLICATION_JSON)
    public List<GroupBriefGetDTO> getBriefGroups() {
        return groupRepo.streamAll()
                .map(it -> groupMapper.toBriefDTO(it))
                .toList();
    }

    @GET
    @Path("/person")
    @Produces(MediaType.APPLICATION_JSON)
    public List<PersonBriefGetDTO> getBriefPeople() {
        return personRepo.streamAll()
                .map(it -> personMapper.toBriefDTO(it))
                .toList();
    }

    @GET
    @Path("/professor")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProfessorBriefGetDTO> getBriefProfessors() {
        return professorRepo.streamAll()
                .map(it -> professorMapper.toBriefDTO(it))
                .toList();
    }

    @GET
    @Path("/student")
    @Produces(MediaType.APPLICATION_JSON)
    public List<StudentBriefGetDTO> getBriefStudent() {
        return studentRepo.streamAll()
                .map(it -> studentMapper.toBriefDTO(it))
                .toList();
    }

    @GET
    @Path("/subject")
    @Produces(MediaType.APPLICATION_JSON)
    public List<SubjectBriefGetDTO> getBriefSubjects() {
        return subjectRepo.streamAll()
                .map(it -> subjectMapper.toBriefDTO(it))
                .toList();
    }

    @GET
    @Path("/sample")
    @Produces(MediaType.APPLICATION_JSON)
    @SuppressWarnings("unchecked")
    public List<ScoreTableDTO> execute(
            @QueryParam("studentIds") List<Long> studentIds,
            @QueryParam("groupIds") List<Long> groupIds,
            @QueryParam("subjectIds") List<Long> subjectIds,
            @QueryParam("avgSource") String source
    ) {
        String filteringClause = "";

        String partitionClause = switch (source == null ? "" : source) {
            case "SUBJECT" -> "subj.id";
            case "GROUP" -> "g.id";
            default -> "s.id";
        };

        if (!studentIds.isEmpty()) {
            filteringClause += " s.id IN :students AND";
        }

        if (!groupIds.isEmpty()) {
            filteringClause += " g.id IN :groups AND";
        }

        if (!subjectIds.isEmpty()) {
            filteringClause += " subj.id IN :subjects AND";
        }

        if (!filteringClause.isEmpty()) {
            filteringClause = filteringClause.substring(0, filteringClause.length() - 4);
        }

        TypedQuery<ScoreTableDTO> query = entityManager.createQuery(
                    """
                        SELECT
                            s.id,
                            s.firstName,
                            s.lastName,
                            g.number,
                            subj.name,
                            m.mark,
                            avg(
                                m.mark
                            ) over (
                                partition by
                    """
                        +
                    partitionClause
                        +
                    """
                            )
                            
                        FROM
                        
                        Student s
                        JOIN
                        s.group g
                        JOIN
                        s.marks m
                        JOIN
                        m.subject subj
                    """
                       +
                    (filteringClause.isEmpty() ? "" : "WHERE" + filteringClause),
                    ScoreTableDTO.class
                )
                .unwrap(Query.class)
                .setTupleTransformer(
                        (Object[] tuple, String[] aliases) ->
                            new ScoreTableDTO(
                                    (Long) tuple[0],
                                    (String) tuple[1],
                                    (String) tuple[2],
                                    (String) tuple[3],
                                    (String) tuple[4],
                                    (Integer) tuple[5],
                                    (Double) tuple[6]
                            )
                );

        if (!studentIds.isEmpty()) {
            query.setParameter("students", studentIds);

        }

        if (!groupIds.isEmpty()) {
            query.setParameter("groups", groupIds);
        }

        if (!subjectIds.isEmpty()) {
            query.setParameter("subjects", subjectIds);
        }

        return query.getResultList();
    }

    @GET
    @Path("/sample/criteria")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ScoreTableDTO> executeCriteria(
            @QueryParam("studentIds") List<Long> studentIds,
            @QueryParam("groupIds") List<Long> groupIds,
            @QueryParam("subjectIds") List<Long> subjectIds,
            @QueryParam("avgSource") String source
    ) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ScoreTableDTO> query = builder.createQuery(ScoreTableDTO.class);

        Root<Student> studentRoot = query.from(Student.class);
        Root<ScoreBoardRecord> recordRoot = query.from(ScoreBoardRecord.class);

        query.select(
                builder.construct(
                        ScoreTableDTO.class,
                        studentRoot.get(Student_.ID),
                        studentRoot.get(Student_.FIRST_NAME),
                        studentRoot.get(Student_.LAST_NAME),
                        studentRoot.get(Student_.group).get(Group_.number),
                        recordRoot.get(ScoreBoardRecord_.subject).get(Subject_.name),
                        recordRoot.get(ScoreBoardRecord_.mark),
                        builder.literal(10.0)
                        //builder.avg(recordRoot.get(ScoreBoardRecord_.mark))
                )
        );



        return entityManager.createQuery(query).getResultList();
    }
}

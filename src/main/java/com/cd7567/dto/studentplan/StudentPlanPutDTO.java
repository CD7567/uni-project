package com.cd7567.dto.studentplan;

public class StudentPlanPutDTO {
    private Long id;
    private Long lecturerId;
    private Long seminaristId;
    private Long studentId;
    private Long subjectId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLecturerId() {
        return lecturerId;
    }

    public void setLecturerId(Long lecturerId) {
        this.lecturerId = lecturerId;
    }

    public Long getSeminaristId() {
        return seminaristId;
    }

    public void setSeminaristId(Long seminaristId) {
        this.seminaristId = seminaristId;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }
}

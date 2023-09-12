package com.cd7567.dto.scoreboard;

public class ScoreTableDTO {
    private Long studentId;
    private String firstName;
    private String lastName;
    private String group;
    private String subjectName;
    private Integer mark;
    private Double avgMark;

    public ScoreTableDTO(Long studentId, String firstName, String lastName, String group, String subjectName, Integer mark, Double avgMark) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.group = group;
        this.subjectName = subjectName;
        this.mark = mark;
        this.avgMark = avgMark;
    }

    public ScoreTableDTO() {
    }


    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    public Double getAvgMark() {
        return avgMark;
    }

    public void setAvgMark(Double avgMark) {
        this.avgMark = avgMark;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }
}

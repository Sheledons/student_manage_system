package cn.sheledon.pojo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * 课程班级
 * 开设课程的教学班
 *
 * @author sheledon
 */
@Setter
@Getter
@Builder
@ToString
public class CourseClass implements Serializable {
    private String courseClassId;
    private LocalDate teachingStartDate;
    private LocalDate teachingEndDate;
    private Integer qualifyNumber;
    private Course course;
    private Classroom classroom;
    private TeachingCase teachingCase;
    private Teacher teacher;
}

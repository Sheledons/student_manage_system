package cn.sheledon.pojo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDate;

/**
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
    private Course course;
    private Integer qualifyNumber;
    private Classroom classroom;
    private TeachingCase teachingCase;
    private Teacher teacher;
}

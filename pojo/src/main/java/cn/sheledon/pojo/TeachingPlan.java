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
public class TeachingPlan implements Serializable {
    private String planId;
    private String planName;
    private Integer classHours;
    private LocalDate makeDate;
    private Integer requiredCourseCredit;
    private Integer selectiveCourseCredit;
}

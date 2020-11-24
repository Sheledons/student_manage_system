package cn.sheledon.pojo;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * @author sheledon
 */
@Setter
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TeachingPlan implements Serializable {
    private String planId;
    private String planName;
    private Integer classHours;
    private LocalDate makeDate;
    private Integer requiredCourseCredit;
    private Integer selectiveCourseCredit;
}

package cn.sheledon.pojo;

import lombok.*;

import java.io.Serializable;

/**
 * @author sheledon
 */
@Setter
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Course implements Serializable {
    private String courseId;
    private String courseName;
    private Department department;
    private String introduce;
    private TeachingDetails teachingDetails;
}

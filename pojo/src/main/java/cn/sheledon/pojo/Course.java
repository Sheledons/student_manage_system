package cn.sheledon.pojo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author sheledon
 */
@Setter
@Getter
@Builder
@ToString
public class Course implements Serializable {
    private String courseId;
    private String courseName;
    private Department department;
    private String text;
    private TeachingDetails teachingDetails;
}

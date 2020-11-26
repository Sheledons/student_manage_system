package cn.sheledon.pojo;

import lombok.*;

import java.io.Serializable;

/**
 * @author sheledon
 */
@Setter
@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentCourse implements Serializable {
    private String courseClassId;
    private String studentId;
    private Integer score;
}

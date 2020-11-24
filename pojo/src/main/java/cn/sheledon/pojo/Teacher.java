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
public class Teacher implements Serializable {
    private String teacherId;
    private String userId;
    private String gender;
    private String name;
    private String phoneNumber;
    private TeacherArchive archive;
    private Department department;
}

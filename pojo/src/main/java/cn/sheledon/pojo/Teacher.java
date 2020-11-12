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
public class Teacher implements Serializable {
    private String teacherId;
    private String gender;
    private String name;
    private String phoneNumber;
    private TeacherArchive archive;
    private Department department;
}

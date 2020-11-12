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
public class Student implements Serializable {
    private String studentId;
    private String name;
    private String gender;
    private String birthday;
    private String phoneNumber;
    private StudentInfo studentInfo;
}

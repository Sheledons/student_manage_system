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
public class Student implements Serializable {
    private String studentId;
    private String userId;
    private String name;
    private String gender;
    private LocalDate birthday;
    private String phoneNumber;
    private StudentInfo studentInfo;
}

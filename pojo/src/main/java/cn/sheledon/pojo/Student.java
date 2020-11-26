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
public class Student implements Serializable {
    private String studentId;
    private String userId;
    private String name;
    private String gender;
    private LocalDate birthday;
    private String phoneNumber;
    private StudentInfo studentInfo;
    private User user;
}

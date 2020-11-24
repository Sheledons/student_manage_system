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
public class StudentInfo implements Serializable {
    private String infoId;
    private Major major;
    private StudentType studentType;
    private StudentArchive studentArchive;
    private Dormitory dormitory;
    private Address address;
    private StudentClass studentClass;
}

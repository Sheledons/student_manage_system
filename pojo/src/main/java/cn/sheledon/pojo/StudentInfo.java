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
public class StudentInfo implements Serializable {
    private String infoId;
    private Major major;
    private StudentType studentType;
    private StudentArchive studentArchive;
    private Dormitory dormitory;
    private Address address;
    private StudentClass studentClass;
}

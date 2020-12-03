package cn.sheledon.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties(ignoreUnknown = true)
public class StudentInfo implements Serializable {
    private String infoId;
    private Major major;
    private StudentType studentType;
    private StudentArchive studentArchive;
    private Dormitory dormitory;
    private Address address;
    private StudentClass studentClass;
}

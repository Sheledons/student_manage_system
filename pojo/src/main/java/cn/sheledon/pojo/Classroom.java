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
public class Classroom implements Serializable {
    private String classroomId;
    private int capacity;
    private String location;
    private String classroomNum;
}

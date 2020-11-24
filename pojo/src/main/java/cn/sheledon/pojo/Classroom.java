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
public class Classroom implements Serializable {
    private String classroomId;
    private int capacity;
    private String location;
    private String classroomNum;
}

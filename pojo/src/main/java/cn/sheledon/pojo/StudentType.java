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
public class StudentType implements Serializable {
    private String studentTypeId;
    private String typeName;
}

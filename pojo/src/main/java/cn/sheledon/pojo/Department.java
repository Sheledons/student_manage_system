package cn.sheledon.pojo;

import lombok.*;

import java.io.Serializable;
import java.util.List;

/**
 * 系
 * @author sheledon
 */
@Setter
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Department implements Serializable {
    private String departmentId;
    private String name;
    private Academy academy;
}

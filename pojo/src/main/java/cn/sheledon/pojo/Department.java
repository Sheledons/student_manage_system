package cn.sheledon.pojo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * @author sheledon
 */
@Setter
@Getter
@Builder
@ToString
public class Department implements Serializable {
    private String departmentId;
    private String name;
    private List<Academy> academies;
}

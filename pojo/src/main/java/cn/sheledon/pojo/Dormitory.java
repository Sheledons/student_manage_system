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
public class Dormitory implements Serializable {
    private String dorId;
    private Integer buildingNum;
    private Integer dormitoryNum;
}

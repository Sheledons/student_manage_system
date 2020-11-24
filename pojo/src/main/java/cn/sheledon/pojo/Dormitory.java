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
public class Dormitory implements Serializable {
    private String dorId;
    private Integer buildingNum;
    private Integer dormitoryNum;
}

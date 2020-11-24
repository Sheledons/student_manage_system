package cn.sheledon.pojo;

import lombok.*;

import java.io.Serializable;

/**
 * 学院
 * @author sheledon
 */
@Setter
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Academy  implements Serializable {
    private String academyId;
    private String name;
}

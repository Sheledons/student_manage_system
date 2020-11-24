package cn.sheledon.pojo;
import lombok.*;

import java.io.Serializable;

/**
 * 教学细节
 * @author sheledon
 */
@Setter
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TeachingDetails  implements Serializable {
    private String detailId;
    private Integer credit;
    private String semester;
    private TeachingPlan teachingPlan;
}

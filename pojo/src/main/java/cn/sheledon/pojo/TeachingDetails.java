package cn.sheledon.pojo;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 教学细节
 * @author sheledon
 */
@Setter
@Getter
@Builder
@ToString
public class TeachingDetails  implements Serializable {
    private String detailId;
    private Integer credit;
    private String semester;
    private TeachingPlan teachingPlan;
}

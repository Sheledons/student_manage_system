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
public class TeachingCase implements Serializable {
    private String caseId;
    /**
     *教学评价
     */
    private Integer assessmentScore;
    private String teachingSchedule;
}

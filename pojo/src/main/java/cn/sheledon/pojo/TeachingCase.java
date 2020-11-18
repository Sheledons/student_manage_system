package cn.sheledon.pojo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 教学评价
 * @author sheledon
 */
@Setter
@Getter
@Builder
@ToString
public class TeachingCase implements Serializable {
    private String caseId;
    private Integer assessmentScore;
    private String teachingSchedule;
}

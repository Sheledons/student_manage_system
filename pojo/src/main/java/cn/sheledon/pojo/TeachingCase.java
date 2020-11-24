package cn.sheledon.pojo;

import lombok.*;

import java.io.Serializable;

/**
 * 教学评价
 * @author sheledon
 */
@Setter
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TeachingCase implements Serializable {
    private String caseId;
    private Integer assessmentScore;
    private String teachingSchedule;
}

package cn.sheledon.pojo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * @author sheledon
 */
@Setter
@Getter
@Builder
@ToString
public class TeacherArchive implements Serializable {
    private String archiveId;
    private LocalDate inductionDate;
    private String professionalGrade;
}

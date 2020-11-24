package cn.sheledon.pojo;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * @author sheledon
 */
@Setter
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TeacherArchive implements Serializable {
    private String archiveId;
    private LocalDate inductionDate;
    private String professionalGrade;
}

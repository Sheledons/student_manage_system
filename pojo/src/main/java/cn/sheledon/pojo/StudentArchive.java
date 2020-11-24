package cn.sheledon.pojo;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

/**
 * @author sheledon
 */
@Setter
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class StudentArchive implements Serializable {
    private String archiveId;
    private String origin;
    private LocalDate startSchoolDate;
    private List<Punishment> punishments;
    private List<Certificate> certificates;
}

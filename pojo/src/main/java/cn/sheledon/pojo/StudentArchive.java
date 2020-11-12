package cn.sheledon.pojo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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
public class StudentArchive implements Serializable {
    private String archiveId;
    private String origin;
    private LocalDate startSchoolDate;
    private List<Punishment> punishments;
    private List<Certificate> certificates;
}

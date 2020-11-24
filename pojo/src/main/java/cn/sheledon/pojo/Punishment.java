package cn.sheledon.pojo;

import lombok.*;

import java.io.Serializable;

/**
 * @author sheledon
 */
@Setter
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Punishment implements Serializable {
    private String punishmentId;
    private String content;
    private String category;
}

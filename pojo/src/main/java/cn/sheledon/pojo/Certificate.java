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
public class Certificate implements Serializable {
    private String certificateId;
    private String content;
}

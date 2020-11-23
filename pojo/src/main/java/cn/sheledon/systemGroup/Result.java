package cn.sheledon.systemGroup;

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
@ToString
@Builder
public class Result implements Serializable {
    private Integer code;
    private String message;
    private Object data;
}

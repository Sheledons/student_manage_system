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
public class ResponseResult implements Serializable {
    private String message;
    private Integer code;
    private Object data;
}

package cn.sheledon.utils;

import cn.sheledon.systemGroup.ResponseResult;
import cn.sheledon.systemGroup.ResponseStatus;

/**
 * @author sheledon
 */
public class ResponseUtils {

    public static ResponseResult buildResponseResult(ResponseStatus status, Object data){
        return ResponseResult.builder()
                .code(status.getCode())
                .message(status.getMessage())
                .data(data)
                .build();
    }
    public static ResponseResult buildResponseResult(ResponseStatus status){
        return ResponseResult.builder()
                .code(status.getCode())
                .message(status.getMessage())
                .build();
    }

}

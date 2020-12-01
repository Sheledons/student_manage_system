package cn.sheledon.utils;

import cn.sheledon.systemGroup.ResponseResult;
import cn.sheledon.systemGroup.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Objects;

/**
 * @author sheledon
 */
public class ControllerUtils {

    public static Object getObjectFromSession(HttpServletRequest request,String key){
        if (request==null || key==null){
            throw new NullPointerException();
        }
        HttpSession session=request.getSession();
        Object o=session.getAttribute(key);
        return Objects.requireNonNull(o);
    }
    public static String buildLogInfo(Object... objects){
        StringBuilder builder=new StringBuilder();
        for (Object o: objects){
            builder.append(o);
        }
        return builder.toString();
    }

    public static ResponseResult buildResponseResult(ResponseStatus status,Object data){
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

    public static void setAttributeToSession(HttpServletRequest request,String key,Object value){
        HttpSession session=request.getSession();
        session.setAttribute(key,value);
    }
}

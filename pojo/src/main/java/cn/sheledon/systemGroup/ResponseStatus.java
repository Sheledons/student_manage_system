package cn.sheledon.systemGroup;

/**
 * @author sheledon
 */

public enum ResponseStatus {
    RESPONSE_OK(2000,"response ok"),
    SUCCESS_LOGIN(2001,"success_login"),
    USERINFO_ERROR(4000,"error: userinfo"),
    PARAMETER_ERROR(4001,"error: parameter");
    private int code;
    private String message;
    ResponseStatus(int code, String message) {
        this.code=code;
        this.message=message;
    }
}

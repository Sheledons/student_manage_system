package cn.sheledon.systemGroup;

/**
 * @author sheledon
 */

public enum ResponseStatus {
    SUCCESS_LOGIN(2000,"success_login"),
    USERINFO_ERROR(4000,"error: userinfo"),
    PARAMETER_ERROR(4001,"error: parameter");
    private int code;
    private String message;
    ResponseStatus(int code, String message) {
        this.code=code;
        this.message=message;
    }
}

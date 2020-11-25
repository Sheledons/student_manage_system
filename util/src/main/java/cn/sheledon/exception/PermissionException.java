package cn.sheledon.exception;

/**
 * @author sheledon
 */
public class PermissionException extends RuntimeException {
    public PermissionException() {
    }

    public PermissionException(String message) {
        super(message);
    }
}

package cn.sheledon.exception;

/**
 * @author sheledon
 */
public class UpdateException extends RuntimeException {
    public UpdateException() {
    }

    public UpdateException(String message) {
        super(message);
    }
}

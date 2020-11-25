package cn.sheledon.exception;

/**
 * @author sheledon
 */
public class ErrorParameterException extends RuntimeException {
    public ErrorParameterException() {
    }

    public ErrorParameterException(String message) {
        super(message);
    }
}

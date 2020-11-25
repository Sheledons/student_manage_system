package cn.sheledon.exception;

/**
 * @author sheledon
 */
public class UserNotFoundException extends NullPointerException{
    public UserNotFoundException() {
    }

    public UserNotFoundException(String message) {
        super(message);
    }
}

package co.borucki.EasyKanbanPortalBackend.security.exceptions;

import org.springframework.security.core.AuthenticationException;

public class InactiveUserException extends AuthenticationException {

    public InactiveUserException(String message) {
        super(message);
    }

}

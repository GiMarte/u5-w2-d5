package gianmarte.u5w2d5.exceptions;

public class ValidationException extends RuntimeException {
    public ValidationException(String message) {
        super("Errori nel payload");
    }
}

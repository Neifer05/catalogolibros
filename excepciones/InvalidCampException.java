package excepciones;

public class InvalidCampException extends RuntimeException {
    public InvalidCampException(String message) {
        super(message);
    }
}
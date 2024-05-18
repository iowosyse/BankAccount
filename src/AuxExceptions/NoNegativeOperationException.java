package AuxExceptions;

public class NoNegativeOperationException extends RuntimeException{
    public NoNegativeOperationException() {
    }

    public NoNegativeOperationException(String message) {
        super(message);
    }
}

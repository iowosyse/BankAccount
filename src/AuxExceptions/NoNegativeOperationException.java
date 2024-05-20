package AuxExceptions;

public class NoNegativeOperationException extends RuntimeException{
    public NoNegativeOperationException() {
        super();
    }

    public NoNegativeOperationException(String message) {
        super(message);
    }
}

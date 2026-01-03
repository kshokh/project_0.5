package uz.abc.Store.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException( String message ) {
        super( message );
    }
}
package teatech.contactmanagement.handler;

public class ApiExceptionHandler extends RuntimeException{
    public ApiExceptionHandler(String message) {
        super(message);
    }
}

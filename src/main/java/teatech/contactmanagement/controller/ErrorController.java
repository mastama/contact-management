package teatech.contactmanagement.controller;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;
import teatech.contactmanagement.dto.WebResponse;
import teatech.contactmanagement.util.Constant;

@RestControllerAdvice
public class ErrorController {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<WebResponse<String>> constrainViolationException(ConstraintViolationException exception) {
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
//                .body(WebResponse.<String>builder().responseDesc(exception.getMessage()).build());

        String responseCode = Constant.RESPONSE.HTTP_INTERNAL_ERROR.getCode();
        String responseDesc = Constant.RESPONSE.HTTP_INTERNAL_ERROR.getDescription();
        String data = exception.getMessage();

        WebResponse<String> response = new WebResponse<>();
        response.setResponseCode(responseCode);
        response.setResponseDesc(responseDesc);
        response.setData(data);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<WebResponse<String>> apiException(ResponseStatusException exception) {
//        return ResponseEntity.status(exception.getStatusCode())
//                .body(WebResponse.<String>builder().responseDesc(exception.getReason()).build());
        String responseCode = Constant.RESPONSE.HTTP_INTERNAL_ERROR.getCode();
        String responseDesc = Constant.RESPONSE.HTTP_INTERNAL_ERROR.getDescription();
        String data = exception.getMessage();

        WebResponse<String> response = new WebResponse<>();
        response.setResponseCode(responseCode);
        response.setResponseDesc(responseDesc);
        response.setData(data);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
}

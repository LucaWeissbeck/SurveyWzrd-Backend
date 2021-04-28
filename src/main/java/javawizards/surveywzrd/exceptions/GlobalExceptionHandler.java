package javawizards.surveywzrd.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Locale;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

        @ExceptionHandler(ResourceNotFoundException.class)
        protected ResponseEntity handleNotFoundException (ResourceNotFoundException e) {
            return new ResponseEntity<Object>("{\"error\": \"" +  e.getMessage() + "\"}", HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(ForbiddenException.class)
    protected ResponseEntity handleForbiddenException (ForbiddenException e) {
        return new ResponseEntity<Object>("{\"error\": \"" +  e.getMessage() + "\"}", HttpStatus.FORBIDDEN);
    }
    @ExceptionHandler(GeneralException.class)
    protected ResponseEntity handleGeneralException (GeneralException e) {
        return new ResponseEntity<Object>("{\"error\": \"" +  e.getMessage() + "\"}", HttpStatus.BAD_REQUEST);
    }
}

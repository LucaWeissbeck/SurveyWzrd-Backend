package javawizards.surveywzrd.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class GeneralException extends RuntimeException {

    public GeneralException() {
        super();
    }

    public GeneralException(String message) {
        super(message);
    }

}

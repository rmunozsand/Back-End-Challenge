package backend.challenge.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class UnexpectedException extends RuntimeException{

    public UnexpectedException(String message) {
        super(message);
    }
}

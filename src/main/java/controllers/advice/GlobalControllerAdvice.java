package controllers.advice;

import jakarta.validation.constraints.NotNull;
import org.jspecify.annotations.NonNull;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalControllerAdvice {

  @ExceptionHandler(NotFoundException.class)
  public ResponseEntity<String> handleNotFound( @NonNull NotFoundException exception) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
  }

  @ExceptionHandler(RuntimeException.class)
  public ResponseEntity<String> handleRuntimeException (@NonNull RuntimeException exception) {
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body((exception.getMessage()));
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<String> handleException(@NonNull Exception exception){
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.getMessage());
  }

  @ExceptionHandler(Throwable.class)
  public ResponseEntity<String> handleThrowable(@NonNull Throwable exception) {
    return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(exception.getMessage());
  }
}

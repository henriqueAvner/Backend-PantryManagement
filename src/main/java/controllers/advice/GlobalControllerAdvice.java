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
  public ResponseEntity<String> handleNotFound(@NotNull NotFoundException exception) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
  }
}

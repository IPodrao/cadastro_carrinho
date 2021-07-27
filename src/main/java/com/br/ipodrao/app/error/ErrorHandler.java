package com.br.ipodrao.app.error;

import com.br.ipodrao.app.exception.AlreadyExistsException;
import com.br.ipodrao.app.exception.NotFoundException;
import org.aspectj.weaver.ast.Not;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = AlreadyExistsException.class)
    public ResponseEntity handleAlreadyExistsException(AlreadyExistsException ex) {
        return new ResponseEntity(ex.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity handleNotFoundException(NotFoundException ex) {
        return new ResponseEntity(ex.getMessage(), HttpStatus.NOT_FOUND);
    }


}
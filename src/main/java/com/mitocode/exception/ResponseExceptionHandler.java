package com.mitocode.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@ControllerAdvice //con esto indica que se debe usar lo de abajo para gestionar los errores
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler { //esta clase controlara los errores, aca se gestionara los errores

    //esta sera el mensaje por default
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponse> handleException(ModelNotFoundException ex, WebRequest request){

     ExceptionResponse er = new ExceptionResponse(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
     return new ResponseEntity<>(er, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ModelNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleModelNotFoundException(ModelNotFoundException ex, WebRequest request){

//lo de abajo devolvera la fecha, el mensaje, la descripcion del error (el getmessage si es en produccion poner algo escrito fijo para no mostrar al cliente)
        ExceptionResponse er = new ExceptionResponse(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(er, HttpStatus.NOT_FOUND);
    }


    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,HttpStatus status, WebRequest request){
     String msg =  ex.getBindingResult().getAllErrors().stream().map(
                e -> e.getCode().concat(":").concat(e.getDefaultMessage())
        ).collect(Collectors.joining());
        ExceptionResponse er = new ExceptionResponse(LocalDateTime.now(), msg, request.getDescription(false));
        return new ResponseEntity<>(er, HttpStatus.BAD_REQUEST);
    }

}

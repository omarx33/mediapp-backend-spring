package com.mitocode.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;



public class ModelNotFoundException extends RuntimeException { //con la extención es para excepciones en tiempo de ejecución(controla los mensajes)

    public ModelNotFoundException(String message){ //recibe el mensaje
        super(message); //devolvemos el mensaje al constructor padre
    }
}

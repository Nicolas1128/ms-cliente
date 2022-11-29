package br.com.mscliente.config.exceptions;

import lombok.Getter;

@Getter
public class EmailCadastradoException extends RuntimeException {

    public EmailCadastradoException(String message){
        super(message);
    }
}

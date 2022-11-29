package br.com.mscliente.config.exceptions;

import lombok.Getter;

@Getter
public class CpfCadastradoException extends RuntimeException{
    public CpfCadastradoException(String message){
        super(message);
    }
}

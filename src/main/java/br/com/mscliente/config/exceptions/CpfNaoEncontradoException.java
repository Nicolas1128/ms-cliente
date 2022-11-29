package br.com.mscliente.config.exceptions;

import lombok.Getter;

@Getter
public class CpfNaoEncontradoException extends RuntimeException {
    public CpfNaoEncontradoException(String message){
        super(message);
    }
}

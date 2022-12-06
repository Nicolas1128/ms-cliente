package br.com.mscliente.config.exceptions;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class EmailCadastradoException extends ResourceException {

    @Builder
    public EmailCadastradoException(HttpStatus code, String message, String developerMessage) {
        super(code,message, developerMessage);
    }
}

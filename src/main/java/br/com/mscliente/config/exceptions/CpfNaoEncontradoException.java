package br.com.mscliente.config.exceptions;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@NoArgsConstructor
@Getter
public class CpfNaoEncontradoException extends ResourceException {

    @Builder
    public CpfNaoEncontradoException(HttpStatus code, String message, String developerMessage) {
        super(code, message, developerMessage);
    }
}

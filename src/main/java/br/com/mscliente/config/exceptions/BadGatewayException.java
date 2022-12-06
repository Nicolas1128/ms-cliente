package br.com.mscliente.config.exceptions;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@NoArgsConstructor
public class BadGatewayException extends ResourceException {

    @Builder
    public BadGatewayException(HttpStatus code, String message, String developerMessage){
        super(code, message, developerMessage);
    }
}

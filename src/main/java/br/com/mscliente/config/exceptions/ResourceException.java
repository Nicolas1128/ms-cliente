package br.com.mscliente.config.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ResourceException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private HttpStatus code;
    private String message;
    private String developerMessage;

}
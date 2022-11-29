package br.com.mscliente.config.exceptions.lib;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
@AllArgsConstructor
public class PadraoException {

    private HttpStatus status;
    private String message;
    private String developerMessage;
    private List<String> errors;
}
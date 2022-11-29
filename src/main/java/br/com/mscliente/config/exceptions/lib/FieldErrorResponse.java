package br.com.mscliente.config.exceptions.lib;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class FieldErrorResponse {

    private String message;
    private int code;
    private String status;
    private String object;
    private List<FieldErrorObject> errors;
}

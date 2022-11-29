package br.com.mscliente.config.exceptions.lib;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FieldErrorObject {

    private String developerMessage;
    private String field;
    private Object parameter;
}
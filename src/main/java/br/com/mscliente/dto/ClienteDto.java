package br.com.mscliente.dto;

import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class ClienteDto {

    @NotBlank
    private String nome;

    @NotBlank
    private String sobrenome;

    @NotBlank
    @Email(message = "O campo EMAIL não está no formato esperado - @dominio.com")
    private String email;

    @NotBlank
    @CPF
    private String cpf;

}

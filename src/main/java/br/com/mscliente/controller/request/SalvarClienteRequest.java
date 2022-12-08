package br.com.mscliente.controller.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SalvarClienteRequest {

    @NotBlank (message = "O campo NOME não deve ser nulo ou vazio")
    @Pattern(regexp = "[A-Z]+(.)*", message = "O campo NOME deve iniciar com letra maiuscula.")
    @Pattern(regexp = "([0-9]*[a-zA-Z]+)|([a-zA-Z]+[0-9]*)", message = "O campo NOME não pode receber caracteres especiais.")
    private String nome;

    @NotBlank(message = "O campo SOBRENOME não deve ser nulo ou vazio")
    @Pattern(regexp = "[A-Z]+(.)*", message = "O campo SOBRENOME deve iniciar com letra maiúscula.")
    @Pattern(regexp = "([0-9]*[a-zA-Z]+)|([a-zA-Z]+[0-9]*)", message = "O campo SOBRENOME não pode receber caracteres especiais.")
    private String sobrenome;

    @NotBlank(message = "O campo EMAIL não deve ser nulo ou vazio")
    @Email(message = "O campo EMAIL não está no formato esperado - @dominio.com")
    private String email;

    @NotBlank(message = "O campo CPF não deve ser nulo ou vazio")
    @CPF(message = "CPF inválido")
    private String cpf;

}

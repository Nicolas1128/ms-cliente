package br.com.mscliente.controller.response;

import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AtualizarClienteResponse {

    private String nome;
    private String sobrenome;
    private String email;
    private String cpf;
}


package br.com.mscliente.controller.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CriarClienteResponse {

    private String nome;
    private String sobrenome;
    private String email;
    private String cpf;
    private boolean clienteAtivo;
    private LocalDateTime dataCriacao;
}

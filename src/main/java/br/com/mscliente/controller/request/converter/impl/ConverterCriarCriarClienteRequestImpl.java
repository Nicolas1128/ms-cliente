package br.com.mscliente.controller.request.converter.impl;

import br.com.mscliente.controller.request.converter.IConverterCriarClienteRequest;
import br.com.mscliente.controller.request.SalvarClienteRequest;
import br.com.mscliente.entity.ClienteEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;

@RequiredArgsConstructor
@Component
public class ConverterCriarCriarClienteRequestImpl implements IConverterCriarClienteRequest {

    @Override
    public ClienteEntity requestToEntity(SalvarClienteRequest salvarClienteRequest) {

        return ClienteEntity.builder()
                .clienteAtivo(true)
                .dataCriacao(LocalDateTime.now(ZoneId.of("UTC")))
                .cpf(salvarClienteRequest.getCpf())
                .nome(salvarClienteRequest.getNome())
                .sobrenome(salvarClienteRequest.getSobrenome())
                .email(salvarClienteRequest.getEmail())
                .build();
    }
}

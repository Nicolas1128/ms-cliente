package br.com.mscliente.controller.request.converter.impl;

import br.com.mscliente.controller.request.converter.IConverterAtualizarClienteRequest;
import br.com.mscliente.controller.request.AtualizarClienteRequest;
import br.com.mscliente.entity.ClienteEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;

@RequiredArgsConstructor
@Component
public class ConverterAtualizarClienteRequestImpl implements IConverterAtualizarClienteRequest {

    @Override
    public ClienteEntity requestToEntity (AtualizarClienteRequest atualizarClienteRequest) {

        return ClienteEntity.builder()
                .clienteAtivo(true)
                .dataCriacao(LocalDateTime.now(ZoneId.of("UTC")))
                .cpf(atualizarClienteRequest.getCpf())
                .nome(atualizarClienteRequest.getNome())
                .sobrenome(atualizarClienteRequest.getSobrenome())
                .email(atualizarClienteRequest.getEmail())
                .build();
    }
}

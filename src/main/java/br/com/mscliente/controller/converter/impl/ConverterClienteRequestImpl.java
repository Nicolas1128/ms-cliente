package br.com.mscliente.controller.converter.impl;

import br.com.mscliente.controller.converter.IConverterClienteRequest;
import br.com.mscliente.controller.request.ClienteRequest;
import br.com.mscliente.entity.ClienteEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ConverterClienteRequestImpl implements IConverterClienteRequest {

    @Override
    public ClienteEntity requestToEntity(ClienteRequest clienteRequest) {

        return ClienteEntity.builder()
                .clienteAtivo(true)
                .cpf(clienteRequest.getCpf())
                .nome(clienteRequest.getNome())
                .sobrenome(clienteRequest.getSobrenome())
                .email(clienteRequest.getEmail())
                .build();
    }
}

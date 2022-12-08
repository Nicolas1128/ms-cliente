package br.com.mscliente.controller.response.converter.impl;

import br.com.mscliente.controller.response.CriarClienteResponse;
import br.com.mscliente.controller.response.converter.IConverterCriarClienteResponse;
import br.com.mscliente.entity.ClienteEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ConverterCriarClienteResponseImpl implements IConverterCriarClienteResponse {

    @Override
    public CriarClienteResponse entityToResponse(ClienteEntity clienteEntity) {

        return CriarClienteResponse.builder()
                .cpf(clienteEntity.getCpf())
                .email(clienteEntity.getEmail())
                .sobrenome(clienteEntity.getSobrenome())
                .nome(clienteEntity.getNome())
                .clienteAtivo(clienteEntity.isClienteAtivo())
                .dataCriacao(clienteEntity.getDataCriacao())
                .build();
    }
}

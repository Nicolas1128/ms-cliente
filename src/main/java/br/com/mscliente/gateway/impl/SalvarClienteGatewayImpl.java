package br.com.mscliente.gateway.impl;

import br.com.mscliente.config.exceptions.BadGatewayException;
import br.com.mscliente.entity.ClienteEntity;
import br.com.mscliente.gateway.ISalvarClienteGateway;
import br.com.mscliente.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SalvarClienteGatewayImpl implements ISalvarClienteGateway {

    private final ClienteRepository clienteRepository;

    @Override
    public ClienteEntity salvarCliente(ClienteEntity clienteEntity) {

        try {
            clienteRepository.save(clienteEntity);
        } catch (BadGatewayException e){
            throw new BadGatewayException(HttpStatus.BAD_GATEWAY, "Erro ao salvar dados na base","Erro ao salvar dados na base");
        }
        return clienteEntity;
    }
}
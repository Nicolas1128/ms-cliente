package br.com.mscliente.usecase.impl;

import br.com.mscliente.config.exceptions.CpfNaoEncontradoException;
import br.com.mscliente.entity.ClienteEntity;
import br.com.mscliente.gateway.IConsultarClienteGateway;
import br.com.mscliente.gateway.ISalvarClienteGateway;
import br.com.mscliente.usecase.IAtualizarClienteUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class AtualizarClienteUseCaseImpl implements IAtualizarClienteUseCase {

    private final IConsultarClienteGateway iConsultarClienteGateway;
    private final ISalvarClienteGateway iSalvarClienteGateway;

    @Override
    public ClienteEntity executar(ClienteEntity clienteEntity) {

        Optional<ClienteEntity> cliente = iConsultarClienteGateway.buscarClientePorCpf(clienteEntity.getCpf());
            if (!cliente.isPresent()){
                throw new CpfNaoEncontradoException(HttpStatus.NOT_FOUND, "CPF não encontrado." , "CPF não encontrado");
            }

        clienteEntity.setId(cliente.get().getId());
        return iSalvarClienteGateway.salvarCliente(clienteEntity);
    }
}

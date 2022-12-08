package br.com.mscliente.usecase.impl;

import br.com.mscliente.entity.ClienteEntity;
import br.com.mscliente.gateway.IConsultarClienteGateway;
import br.com.mscliente.usecase.IBuscarTodosUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class BuscarTodosUseCaseImpl implements IBuscarTodosUseCase {

    private final IConsultarClienteGateway iConsultarClienteGateway;

    @Override
    public Page<ClienteEntity> executar(Pageable pageable) {
        return iConsultarClienteGateway.listarTodosClientes(pageable);
    }
}

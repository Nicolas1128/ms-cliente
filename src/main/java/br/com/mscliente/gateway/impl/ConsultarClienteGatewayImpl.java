package br.com.mscliente.gateway.impl;

import br.com.mscliente.entity.ClienteEntity;
import br.com.mscliente.gateway.IConsultarClienteGateway;
import br.com.mscliente.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ConsultarClienteGatewayImpl implements IConsultarClienteGateway {

    private final ClienteRepository clienteRepository;

    @Override
    public Page<ClienteEntity> listarTodosClientes(Pageable pageable) {
        return clienteRepository.findAll(pageable);
    }

    @Override
    public Optional<ClienteEntity> buscarPorCpf(String cpf) {
        return clienteRepository.findByCpf(cpf);
    }
}

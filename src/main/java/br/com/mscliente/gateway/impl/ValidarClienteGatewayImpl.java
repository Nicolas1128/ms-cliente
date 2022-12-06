package br.com.mscliente.gateway.impl;

import br.com.mscliente.gateway.IValidarClienteGateway;
import br.com.mscliente.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ValidarClienteGatewayImpl implements IValidarClienteGateway {

    private final ClienteRepository clienteRepository;

    @Override
    public boolean validarEmailExistente(String email) {
        return clienteRepository.existsByEmail(email);
    }

    @Override
    public boolean validarCpfExistente(String cpf) {
        return clienteRepository.existsByCpf(cpf);
    }
}

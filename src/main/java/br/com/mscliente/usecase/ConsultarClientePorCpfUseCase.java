package br.com.mscliente.usecase;

import br.com.mscliente.config.exceptions.CpfNaoEncontradoException;
import br.com.mscliente.entity.ClienteEntity;
import br.com.mscliente.gateway.IConsultarClienteGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class ConsultarClientePorCpfUseCase {

    private final IConsultarClienteGateway iConsultarClienteGateway;

    public Optional<ClienteEntity> executar(String cpf) {
        Optional<ClienteEntity> obj = iConsultarClienteGateway.buscarClientePorCpf(cpf);
        if (!obj.isPresent()) {
            throw new CpfNaoEncontradoException(HttpStatus.NOT_FOUND, "CPF não encontrado." , "CPF não encontrado");
        }
        return iConsultarClienteGateway.buscarClientePorCpf(cpf);
    }
}
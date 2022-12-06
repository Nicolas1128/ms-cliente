package br.com.mscliente.usecase;

import br.com.mscliente.config.exceptions.CpfCadastradoException;
import br.com.mscliente.config.exceptions.CpfNaoEncontradoException;
import br.com.mscliente.config.exceptions.EmailCadastradoException;
import br.com.mscliente.entity.ClienteEntity;
import br.com.mscliente.gateway.IConsultarClienteGateway;
import br.com.mscliente.gateway.ISalvarClienteGateway;
import br.com.mscliente.gateway.IValidarClienteGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class ClienteUseCase {

    private final ISalvarClienteGateway iSalvarClienteGateway;
    private final IValidarClienteGateway iValidarClienteGateway;
    private final IConsultarClienteGateway iConsultarClienteGateway;

    public ClienteEntity save(ClienteEntity clienteEntity) {

        if (iValidarClienteGateway.validarCpfExistente(clienteEntity.getCpf())){
            throw new CpfCadastradoException(HttpStatus.UNPROCESSABLE_ENTITY, "erro ao consultar CPF.", "erro ao consultar CPF.");
        }
        if (iValidarClienteGateway.validarEmailExistente(clienteEntity.getEmail())){
            throw new EmailCadastradoException(HttpStatus.UNPROCESSABLE_ENTITY, "email ja cadastrado.", "email ja cadastrado.");
        }

        return iSalvarClienteGateway.salvarCliente(clienteEntity);
    }

    public Optional<ClienteEntity> findByCpf(String cpf) {
        Optional<ClienteEntity> obj = iConsultarClienteGateway.buscarPorCpf(cpf);
        if (!obj.isPresent()) {
            throw new CpfNaoEncontradoException(HttpStatus.NOT_FOUND, "CPF não encontrado." , "CPF não encontrado");
        }
        return iConsultarClienteGateway.buscarPorCpf(cpf);
    }
}
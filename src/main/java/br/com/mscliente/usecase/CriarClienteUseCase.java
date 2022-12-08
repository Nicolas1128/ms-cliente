package br.com.mscliente.usecase;

import br.com.mscliente.config.exceptions.CpfCadastradoException;
import br.com.mscliente.config.exceptions.EmailCadastradoException;
import br.com.mscliente.entity.ClienteEntity;
import br.com.mscliente.gateway.ISalvarClienteGateway;
import br.com.mscliente.gateway.IValidarClienteGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CriarClienteUseCase {

    private final ISalvarClienteGateway iSalvarClienteGateway;
    private final IValidarClienteGateway iValidarClienteGateway;

    public ClienteEntity executar(ClienteEntity clienteEntity) {

        if (iValidarClienteGateway.validarCpfExistente(clienteEntity.getCpf())){
            throw new CpfCadastradoException(HttpStatus.UNPROCESSABLE_ENTITY, "erro ao consultar CPF.", "erro ao consultar CPF.");
        }
        if (iValidarClienteGateway.validarEmailExistente(clienteEntity.getEmail())){
            throw new EmailCadastradoException(HttpStatus.UNPROCESSABLE_ENTITY, "email ja cadastrado.", "email ja cadastrado.");
        }

        return iSalvarClienteGateway.salvarCliente(clienteEntity);
    }
}
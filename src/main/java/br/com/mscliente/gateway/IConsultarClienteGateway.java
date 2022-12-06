package br.com.mscliente.gateway;

import br.com.mscliente.entity.ClienteEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IConsultarClienteGateway {

    Page<ClienteEntity> listarTodosClientes(Pageable pageable);

    Optional<ClienteEntity> buscarPorCpf(String cpf);
}

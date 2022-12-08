package br.com.mscliente.usecase;

import br.com.mscliente.entity.ClienteEntity;

public interface IAtualizarClienteUseCase {

    ClienteEntity executar(ClienteEntity clienteEntity);
}

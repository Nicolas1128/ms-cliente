package br.com.mscliente.gateway;

import br.com.mscliente.entity.ClienteEntity;

public interface ISalvarClienteGateway {

    ClienteEntity salvarCliente(ClienteEntity clienteEntity);

}

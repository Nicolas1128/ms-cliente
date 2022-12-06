package br.com.mscliente.controller.converter;

import br.com.mscliente.controller.request.ClienteRequest;
import br.com.mscliente.entity.ClienteEntity;

public interface IConverterClienteRequest {

    ClienteEntity requestToEntity(ClienteRequest clienteRequest);
}
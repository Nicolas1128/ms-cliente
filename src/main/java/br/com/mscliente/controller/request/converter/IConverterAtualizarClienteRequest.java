package br.com.mscliente.controller.request.converter;

import br.com.mscliente.controller.request.AtualizarClienteRequest;
import br.com.mscliente.entity.ClienteEntity;

public interface IConverterAtualizarClienteRequest {

    ClienteEntity requestToEntity(AtualizarClienteRequest atualizarClienteRequest);
}

package br.com.mscliente.controller.request.converter;

import br.com.mscliente.controller.request.SalvarClienteRequest;
import br.com.mscliente.entity.ClienteEntity;

public interface IConverterCriarClienteRequest {

    ClienteEntity requestToEntity(SalvarClienteRequest salvarClienteRequest);
}
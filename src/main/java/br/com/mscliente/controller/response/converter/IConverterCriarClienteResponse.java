package br.com.mscliente.controller.response.converter;

import br.com.mscliente.controller.response.CriarClienteResponse;
import br.com.mscliente.entity.ClienteEntity;

public interface IConverterCriarClienteResponse {

    CriarClienteResponse entityToResponse(ClienteEntity clienteEntity);
}

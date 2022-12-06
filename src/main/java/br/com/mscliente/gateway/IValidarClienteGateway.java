package br.com.mscliente.gateway;

public interface IValidarClienteGateway {

    boolean validarEmailExistente(String email);

    boolean validarCpfExistente(String cpf);
}

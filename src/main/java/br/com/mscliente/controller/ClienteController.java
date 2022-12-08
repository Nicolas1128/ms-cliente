package br.com.mscliente.controller;

import br.com.mscliente.config.exceptions.CpfCadastradoException;
import br.com.mscliente.config.exceptions.CpfNaoEncontradoException;
import br.com.mscliente.config.exceptions.EmailCadastradoException;
import br.com.mscliente.controller.request.AtualizarClienteRequest;
import br.com.mscliente.controller.request.SalvarClienteRequest;
import br.com.mscliente.controller.request.converter.IConverterAtualizarClienteRequest;
import br.com.mscliente.controller.request.converter.IConverterCriarClienteRequest;
import br.com.mscliente.controller.response.CriarClienteResponse;
import br.com.mscliente.controller.response.converter.IConverterCriarClienteResponse;
import br.com.mscliente.entity.ClienteEntity;
import br.com.mscliente.gateway.IConsultarClienteGateway;
import br.com.mscliente.usecase.ConsultarClientePorCpfUseCase;
import br.com.mscliente.usecase.CriarClienteUseCase;
import br.com.mscliente.usecase.IAtualizarClienteUseCase;
import br.com.mscliente.usecase.IBuscarTodosUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cliente")
public class ClienteController {

    private final CriarClienteUseCase criarClienteUseCase;
    private final IConverterCriarClienteRequest iConverterCriarClienteRequest;
    private final IConsultarClienteGateway iConsultarClienteGateway;
    private final IConverterAtualizarClienteRequest iConverterAtualizarClienteRequest;
    private final IConverterCriarClienteResponse iConverterCriarClienteResponse;
    private final ConsultarClientePorCpfUseCase consultarClientePorCpfUseCase;
    private final IAtualizarClienteUseCase atualizarClienteUseCase;
    private final IBuscarTodosUseCase iBuscarTodosClienteUseCase;

    @PostMapping
    public ResponseEntity<CriarClienteResponse> cadastrarCLiente(@RequestBody @Valid SalvarClienteRequest salvarClienteRequest) {

        try {
            ClienteEntity clienteEntity = iConverterCriarClienteRequest.requestToEntity(salvarClienteRequest);
            ClienteEntity result = criarClienteUseCase.executar(clienteEntity);
            return ResponseEntity.status(HttpStatus.CREATED).body(iConverterCriarClienteResponse.entityToResponse(result));

        } catch (CpfCadastradoException exception) {
            throw new CpfCadastradoException(exception.getCode(),
                    exception.getMessage(),
                    exception.getDeveloperMessage());
        } catch (EmailCadastradoException exception) {
            throw new EmailCadastradoException(exception.getCode(),
                    exception.getMessage(),
                    exception.getDeveloperMessage());
        }
    }

    @GetMapping
    public ResponseEntity<Page<ClienteEntity>> buscarTodosClientes(@PageableDefault(page = 0, size = 10, sort = "nome",
            direction = Sort.Direction.ASC) Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(iBuscarTodosClienteUseCase.executar(pageable));
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<Object> buscarPorCpf(@PathVariable(value = "cpf") String cpf) {
        return ResponseEntity.status(HttpStatus.OK).body(consultarClientePorCpfUseCase.executar(cpf).get());
    }

    @PutMapping
    public ResponseEntity<Object> atualizarDadosCliente(@RequestBody @Valid AtualizarClienteRequest atualizarClienteRequest){

        try {
            ClienteEntity clienteEntity = iConverterAtualizarClienteRequest.requestToEntity(atualizarClienteRequest);
            return ResponseEntity.status(HttpStatus.OK).body(atualizarClienteUseCase.executar(clienteEntity));

        } catch (CpfNaoEncontradoException cpfNaoEncontradoException){
            throw new CpfNaoEncontradoException(cpfNaoEncontradoException.getCode(),
                    cpfNaoEncontradoException.getDeveloperMessage(),
                    cpfNaoEncontradoException.getMessage());

        }
    }

    //TODO implementar a exclusão lógica
//    @DeleteMapping
//    public ResponseEntity<Object> desativarCliente(@RequestParam String cpf) {
//
//
//
//    }

}
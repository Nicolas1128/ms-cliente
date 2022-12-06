package br.com.mscliente.controller;

import br.com.mscliente.config.exceptions.CpfCadastradoException;
import br.com.mscliente.config.exceptions.EmailCadastradoException;
import br.com.mscliente.controller.converter.IConverterClienteRequest;
import br.com.mscliente.controller.request.ClienteRequest;
import br.com.mscliente.entity.ClienteEntity;
import br.com.mscliente.gateway.IConsultarClienteGateway;
import br.com.mscliente.usecase.ClienteUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cliente")
public class ClienteController {

    private final ClienteUseCase clienteUseCase;
    private final IConverterClienteRequest iConverterClienteRequest;
    private final IConsultarClienteGateway iConsultarClienteGateway;

    @PostMapping
    public ResponseEntity<Object> cadastrarCLiente(@RequestBody @Valid ClienteRequest clienteRequest) {

        try {
            ClienteEntity clienteEntity = iConverterClienteRequest.requestToEntity(clienteRequest);
            return ResponseEntity.status(HttpStatus.CREATED).body(clienteUseCase.save(clienteEntity));

        } catch (CpfCadastradoException exception) {
            throw new CpfCadastradoException(exception.getCode(),
                    exception.getMessage(),
                    exception.getDeveloperMessage());
        } catch (EmailCadastradoException emailCadastradoException) {
            throw new EmailCadastradoException(emailCadastradoException.getCode(),
                    emailCadastradoException.getMessage(),
                    emailCadastradoException.getDeveloperMessage());
        }
    }

    //    @GetMapping
//    public ResponseEntity<Page<ClienteEntity>> buscarTodosClientes(@PageableDefault(page = 0,
//                                                                                    size = 10,
//                                                                                    sort = "nome",
//            direction = Sort.Direction.ASC) Pageable pageable) {
//        return ResponseEntity.status(HttpStatus.OK).body(clienteUseCase.findAll(pageable));
//    }

    @GetMapping("/{cpf}")
    public ResponseEntity<Object> buscarPorCpf(@PathVariable(value = "cpf") String cpf) {

        Optional<ClienteEntity> clienteEntity = iConsultarClienteGateway.buscarPorCpf(cpf);
        return ResponseEntity.status(HttpStatus.OK).body(clienteUseCase.findByCpf(cpf).get());

    }
}
package br.com.mscliente.controller;

import br.com.mscliente.dto.ClienteDto;
import br.com.mscliente.model.ClienteModel;
import br.com.mscliente.service.ClienteService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @PostMapping
    public ResponseEntity<Object> salvarCliente(@RequestBody @Valid ClienteDto clienteDto){
        if (clienteService.existsByCpf(clienteDto.getCpf())) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("Documento já cadastrado!");
        }

        var clienteModel = new ClienteModel();
        BeanUtils.copyProperties(clienteDto, clienteModel);
        clienteModel.setDataCriacao(LocalDateTime.now(ZoneId.of("UTC")));
        clienteModel.setClienteAtivo(true);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.save(clienteModel));
    }

    @GetMapping
    public ResponseEntity<Page<ClienteModel>> buscarTodosClientes(@PageableDefault(page = 0, size = 10, sort = "nome", direction = Sort.Direction.ASC) Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.findAll(pageable));
    }
    @GetMapping("/{cpf}")
    public ResponseEntity<Object> buscarPorCpf(@PathVariable(value = "cpf") String cpf) {
        Optional<ClienteModel> clienteModelOptional = clienteService.findByCpf(cpf);
        if (!clienteModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(clienteModelOptional.get());
    }

}

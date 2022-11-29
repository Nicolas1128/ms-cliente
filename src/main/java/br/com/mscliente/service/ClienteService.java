package br.com.mscliente.service;

import br.com.mscliente.model.ClienteModel;
import br.com.mscliente.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    public ClienteModel save(ClienteModel clienteModel) {
        return clienteRepository.save(clienteModel);
    }
    public boolean existsByCpf(String cpf) {
        return clienteRepository.existsByCpf(cpf);
    }
    public boolean existsByEmail(String email){
        return clienteRepository.existsByEmail(email);
    }
    public Page<ClienteModel> findAll(Pageable pageable) {
        return clienteRepository.findAll(pageable);
    }
    public Optional<ClienteModel> findByCpf(String cpf) {
        Optional<ClienteModel> obj = clienteRepository.findByCpf(cpf);
        return clienteRepository.findByCpf(cpf);
    }
}
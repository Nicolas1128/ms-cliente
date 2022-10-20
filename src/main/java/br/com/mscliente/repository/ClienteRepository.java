package br.com.mscliente.repository;


import br.com.mscliente.model.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteModel, UUID> {

    boolean existsByCpf(String cpf);

    Optional<ClienteModel> findByCpf (String cpf);

}
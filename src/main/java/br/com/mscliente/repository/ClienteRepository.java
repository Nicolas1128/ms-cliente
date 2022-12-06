package br.com.mscliente.repository;


import br.com.mscliente.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, UUID> {

    boolean existsByCpf(String cpf);

    boolean existsByEmail(String email);

    Optional<ClienteEntity> findByCpf (String cpf);

}
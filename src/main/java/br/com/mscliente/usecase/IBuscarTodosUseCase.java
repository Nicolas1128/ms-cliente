package br.com.mscliente.usecase;

import br.com.mscliente.entity.ClienteEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBuscarTodosUseCase {

    Page<ClienteEntity> executar(Pageable pageable);

}

package co.com.sofka.Biblioteca.usecase.recurso.interfaz;

import co.com.sofka.Biblioteca.dtos.RecursoDTO;
import reactor.core.publisher.Mono;

@FunctionalInterface
public interface ConsultarRecurso {
    Mono<RecursoDTO> findById(String id);
}

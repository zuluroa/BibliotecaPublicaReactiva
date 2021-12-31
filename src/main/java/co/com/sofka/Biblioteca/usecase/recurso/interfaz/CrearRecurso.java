package co.com.sofka.Biblioteca.usecase.recurso.interfaz;

import co.com.sofka.Biblioteca.dtos.RecursoDTO;
import reactor.core.publisher.Mono;

@FunctionalInterface
public interface CrearRecurso {
    public Mono<RecursoDTO> apply(RecursoDTO recursoDTO);
}

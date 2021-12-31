package co.com.sofka.Biblioteca.usecase.recurso.interfaz;

import co.com.sofka.Biblioteca.dtos.RecursoDTO;
import reactor.core.publisher.Flux;

@FunctionalInterface
public interface ListaRecurso {
    Flux<RecursoDTO> get();
}

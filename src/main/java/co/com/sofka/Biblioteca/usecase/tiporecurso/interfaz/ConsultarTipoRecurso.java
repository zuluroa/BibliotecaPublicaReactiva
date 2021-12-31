package co.com.sofka.Biblioteca.usecase.tiporecurso.interfaz;

import co.com.sofka.Biblioteca.dtos.TipoRecursoDTO;
import reactor.core.publisher.Flux;

@FunctionalInterface
public interface ConsultarTipoRecurso {
    Flux<TipoRecursoDTO> get();
}

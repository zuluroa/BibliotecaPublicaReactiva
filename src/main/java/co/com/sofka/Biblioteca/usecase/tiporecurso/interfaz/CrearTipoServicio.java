package co.com.sofka.Biblioteca.usecase.tiporecurso.interfaz;

import co.com.sofka.Biblioteca.dtos.TipoRecursoDTO;
import reactor.core.publisher.Mono;

public interface CrearTipoServicio {
    Mono<TipoRecursoDTO> save(TipoRecursoDTO tipoRecursoDTO);
}

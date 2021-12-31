package co.com.sofka.Biblioteca.usecase.tiporecurso.interfaz;

import reactor.core.publisher.Mono;

@FunctionalInterface
public interface EliminarTipoRecurso {
    Mono<Void> deleteByIdTipoRecurso(String id);
}

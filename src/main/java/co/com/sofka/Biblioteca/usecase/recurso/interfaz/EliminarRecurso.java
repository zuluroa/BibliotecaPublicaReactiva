package co.com.sofka.Biblioteca.usecase.recurso.interfaz;

import reactor.core.publisher.Mono;

@FunctionalInterface
public interface EliminarRecurso {
    Mono<Void> deleteById(String id);
}

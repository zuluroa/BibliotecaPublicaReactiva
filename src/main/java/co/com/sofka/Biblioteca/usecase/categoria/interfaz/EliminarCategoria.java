package co.com.sofka.Biblioteca.usecase.categoria.interfaz;

import reactor.core.publisher.Mono;

@FunctionalInterface
public interface EliminarCategoria {
    Mono<Void> deleteByIdCategoria(String id);
}

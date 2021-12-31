package co.com.sofka.Biblioteca.usecase.categoria.interfaz;

import co.com.sofka.Biblioteca.dtos.CategoriaDTO;
import reactor.core.publisher.Mono;

@FunctionalInterface
public interface GuardarCartegoria {
    Mono<CategoriaDTO> save(CategoriaDTO categoriaDTO);
}

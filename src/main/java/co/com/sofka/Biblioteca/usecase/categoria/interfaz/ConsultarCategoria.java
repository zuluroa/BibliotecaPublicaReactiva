package co.com.sofka.Biblioteca.usecase.categoria.interfaz;

import co.com.sofka.Biblioteca.dtos.CategoriaDTO;
import reactor.core.publisher.Flux;

@FunctionalInterface
public interface ConsultarCategoria {
    Flux<CategoriaDTO> get();
}

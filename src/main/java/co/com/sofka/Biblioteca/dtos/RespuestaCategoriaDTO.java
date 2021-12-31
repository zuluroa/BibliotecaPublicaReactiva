package co.com.sofka.Biblioteca.dtos;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public class RespuestaCategoriaDTO {

    private Mono<String> categoria;
    private Flux<RecursoDTO> recursosCategoria;

    public Mono<String> getCategoria() {
        return categoria;
    }

    public void setCategoria(Mono<String> categoria) {
        this.categoria = categoria;
    }

    public Flux<RecursoDTO> getRecursosCategoria() {
        return recursosCategoria;
    }

    public void setRecursosCategoria(Flux<RecursoDTO> recursosCategoria) {
        this.recursosCategoria = recursosCategoria;
    }
}

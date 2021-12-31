package co.com.sofka.Biblioteca.dtos;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public class RespuestaTipoRecursoDTO {
    private Mono<String> tipoRecurso;
    private Flux<RecursoDTO> listTipoRecurso;

    public Mono<String> getTipoRecurso() {
        return tipoRecurso;
    }

    public void setTipoRecurso(Mono<String> tipoRecurso) {
        this.tipoRecurso = tipoRecurso;
    }

    public Flux<RecursoDTO> getListTipoRecurso() {
        return listTipoRecurso;
    }

    public void setListTipoRecurso(Flux<RecursoDTO> listTipoRecurso) {
        this.listTipoRecurso = listTipoRecurso;
    }
}

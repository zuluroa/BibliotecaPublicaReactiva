package co.com.sofka.Biblioteca.mapper;

import co.com.sofka.Biblioteca.dtos.RecursoDTO;
import co.com.sofka.Biblioteca.dtos.RespuestaTipoRecursoDTO;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Component
public class RespuestaTipoRecursoMapper {

    public Function<Flux<RecursoDTO>, RespuestaTipoRecursoDTO> recursoToRespuestaTipo(Mono<String> nombre) {
        return recursoTipoFlux -> {
            RespuestaTipoRecursoDTO respuestaTipoRecursoDTO = new RespuestaTipoRecursoDTO();
            respuestaTipoRecursoDTO.setTipoRecurso(nombre);
            respuestaTipoRecursoDTO.setListTipoRecurso(recursoTipoFlux);
            return respuestaTipoRecursoDTO;
        };
    }

}

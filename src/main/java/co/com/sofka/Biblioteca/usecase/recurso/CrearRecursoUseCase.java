package co.com.sofka.Biblioteca.usecase.recurso;

import co.com.sofka.Biblioteca.dtos.RecursoDTO;
import co.com.sofka.Biblioteca.mapper.RecursoMapper;
import co.com.sofka.Biblioteca.repositorios.RepositorioRecurso;
import co.com.sofka.Biblioteca.usecase.recurso.interfaz.CrearRecurso;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class CrearRecursoUseCase implements CrearRecurso {

    private final RepositorioRecurso repositorioRecurso;
    private final RecursoMapper mapper;

    public CrearRecursoUseCase(RepositorioRecurso repositorioRecurso, RecursoMapper mapper) {
        this.repositorioRecurso = repositorioRecurso;
        this.mapper = mapper;
    }

    @Override
    public Mono<RecursoDTO> apply(RecursoDTO recursoDTO) {
        return repositorioRecurso.save(mapper.dtoToRecurso().apply(recursoDTO))
                .map(recurso -> mapper.RecursoToDTO().apply(recurso));
    }
}

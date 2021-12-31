package co.com.sofka.Biblioteca.usecase;

import co.com.sofka.Biblioteca.dtos.RecursoDTO;
import co.com.sofka.Biblioteca.mapper.RecursoMapper;
import co.com.sofka.Biblioteca.repositorios.RepositorioRecurso;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Flux;

@Service
@Validated
public class FiltrarTipoRecursoUseCase {

    private final RepositorioRecurso repositorioRecurso;
    private final RecursoMapper recursoMapper;

    public FiltrarTipoRecursoUseCase(RepositorioRecurso repositorioRecurso, RecursoMapper recursoMapper) {
        this.repositorioRecurso = repositorioRecurso;
        this.recursoMapper = recursoMapper;
    }

    public Flux<RecursoDTO> filtrarTipo(String id) {
        return repositorioRecurso.findRecursoBytipoRecursoId(id).map(recursoMapper.RecursoToDTO());
    }
}

package co.com.sofka.Biblioteca.usecase.recurso;

import co.com.sofka.Biblioteca.mapper.RecursoMapper;
import co.com.sofka.Biblioteca.repositorios.RepositorioRecurso;
import co.com.sofka.Biblioteca.usecase.recurso.interfaz.EliminarRecurso;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class EliminarRecursoUseCase implements EliminarRecurso {

    private final RepositorioRecurso repositorioRecurso;
    private final RecursoMapper recursoMapper;

    public EliminarRecursoUseCase(RepositorioRecurso repositorioRecurso, RecursoMapper recursoMapper) {
        this.repositorioRecurso = repositorioRecurso;
        this.recursoMapper = recursoMapper;
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return repositorioRecurso.deleteById(id);
    }
}

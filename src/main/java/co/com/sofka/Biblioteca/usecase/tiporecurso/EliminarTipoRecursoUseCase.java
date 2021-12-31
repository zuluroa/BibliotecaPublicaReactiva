package co.com.sofka.Biblioteca.usecase.tiporecurso;

import co.com.sofka.Biblioteca.mapper.TipoRecursoMapper;
import co.com.sofka.Biblioteca.repositorios.RepositorioTipoRecurso;
import co.com.sofka.Biblioteca.usecase.tiporecurso.interfaz.EliminarTipoRecurso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class EliminarTipoRecursoUseCase implements EliminarTipoRecurso {

    private final RepositorioTipoRecurso repositorioTipoRecurso;
    private final TipoRecursoMapper tipoRecursoMapper;

    @Autowired
    public EliminarTipoRecursoUseCase(RepositorioTipoRecurso repositorioTipoRecurso, TipoRecursoMapper tipoRecursoMapper) {
        this.repositorioTipoRecurso = repositorioTipoRecurso;
        this.tipoRecursoMapper = tipoRecursoMapper;
    }

    @Override
    public Mono<Void> deleteByIdTipoRecurso(String id) {
        return repositorioTipoRecurso.deleteById(id);
    }
}

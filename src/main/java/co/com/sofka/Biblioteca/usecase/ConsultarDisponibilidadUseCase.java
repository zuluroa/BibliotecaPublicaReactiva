package co.com.sofka.Biblioteca.usecase;

//import com.mongodb.Function;

import co.com.sofka.Biblioteca.dtos.RespuestaRecursoDTO;
import co.com.sofka.Biblioteca.mapper.RecursoMapper;
import co.com.sofka.Biblioteca.mapper.RespuestaRecursoMapper;
import co.com.sofka.Biblioteca.repositorios.RepositorioRecurso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Service
@Validated
public class ConsultarDisponibilidadUseCase implements Function<String, Mono<RespuestaRecursoDTO>> {

    private final RepositorioRecurso repositorioRecurso;
    private RecursoMapper recursoMapper = new RecursoMapper();
    private RespuestaRecursoMapper respuestaRecursoMapper = new RespuestaRecursoMapper();

    @Autowired
    public ConsultarDisponibilidadUseCase(RepositorioRecurso repositorioRecurso) {
        this.repositorioRecurso = repositorioRecurso;
    }

    @Override
    public Mono<RespuestaRecursoDTO> apply(String id) {
        var recurso = repositorioRecurso.findById(id).map(recursoMapper.RecursoToDTO());
        return recurso.map(respuestaRecursoMapper.consultarRecurso());
    }

}

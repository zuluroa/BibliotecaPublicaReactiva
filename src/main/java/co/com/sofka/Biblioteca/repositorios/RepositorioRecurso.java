package co.com.sofka.Biblioteca.repositorios;


import co.com.sofka.Biblioteca.model.Recurso;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface RepositorioRecurso extends ReactiveMongoRepository<Recurso, String> {
    Flux<Recurso> findRecursoBycategoriaId(String categoriaId);

    Flux<Recurso> findRecursoBytipoRecursoId(String tipoRecursoId);
}

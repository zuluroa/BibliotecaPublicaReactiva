package co.com.sofka.Biblioteca.repositorios;

import co.com.sofka.Biblioteca.model.TipoRecurso;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface RepositorioTipoRecurso extends ReactiveMongoRepository<TipoRecurso, String> {
}

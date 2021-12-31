package co.com.sofka.Biblioteca.repositorios;


import co.com.sofka.Biblioteca.model.Categoria;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface RepositorioCategoria extends ReactiveMongoRepository<Categoria, String> {
}

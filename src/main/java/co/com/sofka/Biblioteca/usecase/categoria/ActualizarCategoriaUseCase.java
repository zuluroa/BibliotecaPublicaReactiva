package co.com.sofka.Biblioteca.usecase.categoria;

import co.com.sofka.Biblioteca.dtos.CategoriaDTO;
import co.com.sofka.Biblioteca.mapper.CategoriaMapper;
import co.com.sofka.Biblioteca.repositorios.RepositorioCategoria;
import co.com.sofka.Biblioteca.usecase.categoria.interfaz.GuardarCartegoria;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class ActualizarCategoriaUseCase implements GuardarCartegoria {

    private final RepositorioCategoria repositorioCategoria;
    private final CategoriaMapper categoriaMapper;

    public ActualizarCategoriaUseCase(RepositorioCategoria repositorioCategoria, CategoriaMapper categoriaMapper) {
        this.repositorioCategoria = repositorioCategoria;
        this.categoriaMapper = categoriaMapper;
    }

    @Override
    public Mono<CategoriaDTO> save(CategoriaDTO categoriaDTO) {
        return repositorioCategoria.save(categoriaMapper.dtoToCategoria()
                        .apply(categoriaDTO))
                .map(categoriaMapper.CategoriaToDTO());
    }
}

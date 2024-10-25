package br.com.fiap.challenge.diner.core.application.services;

import br.com.fiap.challenge.diner.adapter.driven.infra.mappers.CategoriaMapper;
import br.com.fiap.challenge.diner.adapter.driver.exception.BusinessException;
import br.com.fiap.challenge.diner.adapter.driver.response.CategoriaResponse;
import br.com.fiap.challenge.diner.adapter.driver.response.PaginacaoResponse;
import br.com.fiap.challenge.diner.adapter.driver.response.ProdutoResponse;
import br.com.fiap.challenge.diner.core.application.ports.CategoriaRepository;
import br.com.fiap.challenge.diner.core.application.utils.Paginacao;
import br.com.fiap.challenge.diner.core.domain.dto.CategoriaDTO;
import br.com.fiap.challenge.diner.core.domain.entities.Categoria;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import java.util.List;

import static br.com.fiap.challenge.diner.core.application.errors.Errors.CATEGORIA_NAO_EXISTE;
import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY;

@Service
@RequiredArgsConstructor
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;
    private final CategoriaMapper categoriaMapper;

    public CategoriaResponse cadastrarCategoria(CategoriaDTO categoria) {
        var entidade = categoriaMapper.toCategoriaEntitie(categoria);
        var entityResponse = categoriaRepository.save(entidade);

        return categoriaMapper.toCategoriaResponse(entityResponse);

    }

    public CategoriaResponse atualizaCategoria(Long id, CategoriaDTO categoria) {
        var categoriaEntitie = getCategoria(id);
        categoriaEntitie.setId(id);
        categoriaEntitie.setDescricao(categoria.getDescricao());
        Categoria entityResponse = categoriaRepository.save(categoriaEntitie);
        return categoriaMapper.toCategoriaResponse(entityResponse);
    }

    public void deletarCategoria(Long id) {
        var categoria = getCategoria(id);
        categoriaRepository.delete(categoria);
    }

    public CategoriaResponse buscarCategoriaById(Long id) {
        return categoriaMapper.toCategoriaResponse(getCategoria(id));
    }

    public PaginacaoResponse<ProdutoResponse> listarCategorias(Integer page, Integer limit, String sort) {
        var pageable = Paginacao.getPageRequest(limit, page, sort, "id");
        var produtos = categoriaRepository.findAll(pageable);
        List<CategoriaResponse> categoriaResponses = categoriaMapper.toResponseList(produtos.getContent());
        return new PaginacaoResponse<ProdutoResponse>().convertToResponse(new PageImpl(categoriaResponses, produtos.getPageable(), 0L));
    }

    private Categoria getCategoria(Long id) {
        return categoriaRepository.findById(id)
                .orElseThrow(() -> new BusinessException(CATEGORIA_NAO_EXISTE, UNPROCESSABLE_ENTITY));
    }

}

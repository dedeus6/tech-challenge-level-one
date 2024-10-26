package br.com.fiap.challenge.diner.core.application.services;

import br.com.fiap.challenge.diner.adapter.driven.infra.mappers.PedidoMapper;
import br.com.fiap.challenge.diner.adapter.driver.response.CategoriaResponse;
import br.com.fiap.challenge.diner.core.application.ports.CategoriaRepository;
import br.com.fiap.challenge.diner.core.domain.dto.PedidoDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PedidoService {

    private final CategoriaRepository categoriaRepository;
    private final PedidoMapper pedidoMapper;

    public CategoriaResponse cadastrarPedido(PedidoDTO pedidoDTO) {
        //var entity = pedidoMapper.toEntity(pedidoDTO);
        //var entityResponse = categoriaRepository.save(entity);
        return null;
    }
}

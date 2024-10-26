package br.com.fiap.challenge.diner.adapter.driven.infra.mappers;

import br.com.fiap.challenge.diner.adapter.driver.request.CadastrarPedidoRequest;
import br.com.fiap.challenge.diner.core.domain.dto.PedidoDTO;
import br.com.fiap.challenge.diner.core.domain.entities.Pedido;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PedidoMapper {

    PedidoDTO toPedidoDTO(CadastrarPedidoRequest request);
    Pedido toPedidoEntidade(PedidoDTO pedidoDTO);
}

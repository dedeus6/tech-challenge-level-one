package br.com.fiap.challenge.diner.adapter.driven.infra.mappers;

import br.com.fiap.challenge.diner.adapter.driver.request.CadastrarPedidoRequest;
import br.com.fiap.challenge.diner.adapter.driver.response.PedidoItemResponse;
import br.com.fiap.challenge.diner.adapter.driver.response.PedidoResponse;
import br.com.fiap.challenge.diner.core.domain.dto.PedidoDTO;
import br.com.fiap.challenge.diner.core.domain.entities.Pedido;
import br.com.fiap.challenge.diner.core.domain.entities.PedidoItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PedidoMapper {

    PedidoDTO toPedidoDTO(CadastrarPedidoRequest request);

    PedidoResponse toPedidoResponse(Pedido pedido);

    @Mapping(source = "produto.id", target = "produtoId")
    PedidoItemResponse toPedidoItemResponse(PedidoItem pedidoItem);

    @Mapping(target = "itens", ignore = true)
    Pedido toPedidoEntidade(PedidoDTO pedidoDTO);

}

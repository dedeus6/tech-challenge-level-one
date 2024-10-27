package br.com.fiap.challenge.diner.adapter.driven.infra.mappers;

import br.com.fiap.challenge.diner.adapter.driver.request.CadastrarPedidoRequest;
import br.com.fiap.challenge.diner.adapter.driver.response.PedidoItemResponse;
import br.com.fiap.challenge.diner.adapter.driver.response.PedidoPagamentoResponse;
import br.com.fiap.challenge.diner.adapter.driver.response.PedidoResponse;
import br.com.fiap.challenge.diner.core.domain.dto.PedidoDTO;
import br.com.fiap.challenge.diner.core.domain.entities.Pedido;
import br.com.fiap.challenge.diner.core.domain.entities.PedidoItem;
import br.com.fiap.challenge.diner.core.domain.entities.PedidoPagamento;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface PedidoMapper {

    PedidoDTO toPedidoDTO(CadastrarPedidoRequest request);

    @Mapping(target = "status", source = "pedido", qualifiedByName = "statusPedidoStrMapper")
    PedidoResponse toPedidoResponse(Pedido pedido);

    @Mapping(source = "produto.id", target = "produtoId")
    PedidoItemResponse toPedidoItemResponse(PedidoItem pedidoItem);

    @Mapping(target = "status", source = "pedidoPagamento", qualifiedByName = "statusPedidoPagamentoStrMapper")
    PedidoPagamentoResponse toPedidoPagamentoResponse(PedidoPagamento pedidoPagamento);

    @Mapping(target = "itens", ignore = true)
    Pedido toPedidoEntidade(PedidoDTO pedidoDTO);

    @Named("statusPedidoStrMapper")
    default String mapPedidoStatusStr(Pedido pedido) {
        return pedido.getStatusStr();
    }

    @Named("statusPedidoPagamentoStrMapper")
    default String mapPedidoPagamentoStatusStr(PedidoPagamento pedidoPagamento) {
        return pedidoPagamento.getStatusStr();
    }


}

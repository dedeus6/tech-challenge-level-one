package br.com.fiap.challenge.diner.adapter.driven.infra.mappers;

import br.com.fiap.challenge.diner.adapter.driver.request.SolicitarPagamentoRequest;
import br.com.fiap.challenge.diner.core.domain.dto.SolicitarPagamentoDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PedidoPagamentoMapper {

    SolicitarPagamentoDTO toPedidoPagamentoDTO(SolicitarPagamentoRequest request);
}

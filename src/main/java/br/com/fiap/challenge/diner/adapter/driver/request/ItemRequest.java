package br.com.fiap.challenge.diner.adapter.driver.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemRequest {

    private Long produtoId;
    private Long qtdProduto;

}

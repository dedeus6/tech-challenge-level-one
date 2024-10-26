package br.com.fiap.challenge.diner.core.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum StatusPedido {

    RECEBIDO("R"),
    EM_PREPARACAO("E"),
    PRONTO("P"),
    FINALIZADO("F");

    private String valor;
}

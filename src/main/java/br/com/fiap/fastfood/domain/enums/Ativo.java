package br.com.fiap.fastfood.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum Ativo {

    SIM("S"), NAO("N");

    private String valor;
}

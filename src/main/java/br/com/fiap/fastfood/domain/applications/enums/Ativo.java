package br.com.fiap.fastfood.domain.applications.enums;

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

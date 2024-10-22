package br.com.fiap.challenge.diner.core.application.errors;

public class Errors {

    // Empresa
    public static final String CAMPO_REQUERIDO = "Campo é requerido";
    public static final String CNPJ_INVALIDO = "Cnpj informado é diferente de 14 carácteres";
    public static final String EMPRESA_JA_CADASTRADA = "Empresa já está cadastrada";

    // Produto
    public static final String DESCRICAO_REQUERIDO = "Campo descricao é requerido";
    public static final String VLR_UNITARIO_FORMATO_INVALIDO = "O valor unitário deve ter no máximo 10 dígitos inteiros e 2 casas decimais";
    public static final String VLR_UNITARIO_REQUERIDO = "Campo vlr_unitario é requerido";
    public static final String CATEGORIA_ID_REQUERIDO = "Campo categoria_id é requerido";
}

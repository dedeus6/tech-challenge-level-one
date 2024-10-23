package br.com.fiap.challenge.diner.core.application.errors;

public class Errors {

    // Empresa
    public static final String CAMPO_REQUERIDO = "Campo é requerido";
    public static final String CNPJ_INVALIDO = "Cnpj informado é diferente de 14 carácteres";
    public static final String EMPRESA_JA_CADASTRADA = "Empresa já cadastrada";
    public static final String EMPRESA_NAO_ENCONTRADA = "Empresa não encontrada";

    // Produto
    public static final String DESCRICAO_REQUERIDO = "Campo descricao é requerido";
    public static final String VLR_UNITARIO_FORMATO_INVALIDO = "O valor unitário deve ter no máximo 10 dígitos inteiros e 2 casas decimais";
    public static final String VLR_UNITARIO_REQUERIDO = "Campo vlr_unitario é requerido";
    public static final String CATEGORIA_ID_REQUERIDO = "Campo categoria_id é requerido";

    //Paginação
    public static final String PAGE_MINIMA = "Página miníma é 1";

    public static final String ENUM_ATIVO_INVALIDO = "O valor informado está invalido. Valores permitidos [S, N]";

}

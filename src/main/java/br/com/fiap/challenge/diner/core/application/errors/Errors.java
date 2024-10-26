package br.com.fiap.challenge.diner.core.application.errors;

public class Errors {

    //GENERICOS
    public static final String CAMPO_REQUERIDO = "Campo é requerido";
    public static final String QUERY_PARAMS_REQUERIDO = "Parâmetro é requerido";

    // Empresa
    public static final String CNPJ_INVALIDO = "Cnpj informado é diferente de 14 carácteres";
    public static final String EMPRESA_JA_CADASTRADA = "Empresa já cadastrada";
    public static final String EMPRESA_NAO_ENCONTRADA = "Empresa não encontrada";

    // Produto
    public static final String VLR_UNITARIO_FORMATO_INVALIDO = "O valor unitário deve ter no máximo 10 dígitos inteiros e 2 casas decimais";
    public static final String CATEGORIA_NAO_EXISTE = "A categoria informada não existe";
    public static final String CLIENTE_EXISTE = "O CPF informado já existe cadastrado";
    public static final String CLIENTE_NAO_EXISTE = "Cliente não encontrado";
    public static final String PRODUTO_NAO_ENCONTRADO = "Produto não encontrado";

    //Paginação
    public static final String PAGE_MINIMA = "Página miníma é 1";

    // Cliente
    public static final String CLIENTE_NAO_ENCONTRADO = "Cliente não encontrado";

    public static final String ENUM_ATIVO_INVALIDO = "O valor informado está invalido. Valores permitidos [S, N]";

}

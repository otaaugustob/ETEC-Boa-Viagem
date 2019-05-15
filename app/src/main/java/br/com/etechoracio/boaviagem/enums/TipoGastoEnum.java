package br.com.etechoracio.boaviagem.enums;

public enum TipoGastoEnum {
    ALIMENTECAO("Alimentação"),
    COMBUSTIVEL("Combustível"),
    TRANSPORTE("Transporte"),
    HOSPEDAGEM("Hospedagem"),
    OUTROS("Outros");
    private String descricao;

    TipoGastoEnum(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return descricao;

    }
}

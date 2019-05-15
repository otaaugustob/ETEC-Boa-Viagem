package br.com.etechoracio.boaviagem.enums;

public enum TipoViagemEnum {
    LAZER("Lazer"),
    NEGOCIOS("Negocios");

    private String desc;

    TipoViagemEnum(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return desc;

    }
}

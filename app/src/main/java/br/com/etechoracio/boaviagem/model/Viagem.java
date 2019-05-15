package br.com.etechoracio.boaviagem.model;

import java.util.Date;

import br.com.etechoracio.boaviagem.enums.TipoViagemEnum;

public class Viagem {

    private String id;
    private String destinoo;

    public String getDestinoo() {
        return destinoo;
    }

    public void setDestinoo(String destinoo) {
        this.destinoo = destinoo;
    }

    private TipoViagemEnum tipoViagem;
    private Date dataChegada;
    private Date dataSaida;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public TipoViagemEnum getTipoViagem() {
        return tipoViagem;
    }

    public void setTipoViagem(TipoViagemEnum tipoViagem) {
        this.tipoViagem = tipoViagem;
    }

    public Date getDataChegada() {
        return dataChegada;
    }

    public void setDataChegada(Date dataChegada) {
        this.dataChegada = dataChegada;
    }

    public Date getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(Date dataSaida) {
        this.dataSaida = dataSaida;
    }

    public double getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(double orcamento) {
        this.orcamento = orcamento;
    }

    public int getQuantidadePessoas() {
        return quantidadePessoas;
    }

    public void setQuantidadePessoas(int quantidadePessoas) {
        this.quantidadePessoas = quantidadePessoas;
    }

    private double orcamento;
    private int quantidadePessoas;
}

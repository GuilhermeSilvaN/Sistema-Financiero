package com.sytem.financeiropersonal.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="tb_entrada")
public class Entrada implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date dataEntrada;

    private String descricao;

    private Double valor;

    @ManyToOne
    @JoinColumn(name="dashboard_id")
    private Dashboard dashboard;

    public Entrada() {}

    public Entrada(Date dataEntrada, String descricao, Double valor) {
        this.dataEntrada = dataEntrada;
        this.descricao = descricao;
        this.valor = valor;
    }

    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    @JsonIgnore
    public Dashboard getDashboard() { return dashboard; }

    public void setDashboard(Dashboard dashboard) { this.dashboard = dashboard; }
}

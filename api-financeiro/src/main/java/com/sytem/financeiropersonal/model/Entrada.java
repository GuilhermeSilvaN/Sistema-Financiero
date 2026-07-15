package com.sytem.financeiropersonal.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Entity
@Table(name="tb_entrada")
public class Entrada implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(pattern = "dd/mm/yyyy")
    private LocalDate dataEntrada;

    private String descricao;

    private Double valor;

    @ManyToOne
    @JoinColumn(name="dashboard_id")
    private Dashboard dashboard;

    public Entrada() {}

    public Entrada(String dataEntradaString, String descricao, Double valor) {
        setDataEntrada(dataEntradaString);
        this.descricao = descricao;
        this.valor = valor;
    }

    public Long getId() {
        return id;
    }

    public String getDataEntrada() {
        //convert LocalDate to String;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return formatter.format(dataEntrada);
    }

    public void setDataEntrada(String dataEntrada) {
        //convert String to LocalDate;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.dataEntrada = LocalDate.parse(dataEntrada, formatter);
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

    @JsonIgnore
    public Dashboard getDashboard() { return dashboard; }

    public void setDashboard(Dashboard dashboard) { this.dashboard = dashboard; }
}

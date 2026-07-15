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
@Table(name="tb_despesa")
public class Despesa implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(pattern = "dd/mm/yyyy")
    private LocalDate dataDespesa;

    private String descricao;

    private String categoria;

    private String formaPagamento;

    private Double valor;

    @ManyToOne
    @JoinColumn(name="dashboard_id")
    private Dashboard dashboard;

    public Despesa() {}

    public Despesa(String dataDespesaString, String descricao, String categoria, String formaPagamento, Double valor) {
        setDataDespesa(dataDespesaString);
        this.descricao = descricao;
        this.categoria = categoria;
        this.formaPagamento = formaPagamento;
        this.valor = valor;
    }

    public Long getId() {
        return id;
    }

    public String getDataDespesa() {
        //convert LocalDate to String
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return formatter.format(dataDespesa);
    }

    public void setDataDespesa(String dataDespesa) {
        //convert String to LocalDate
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.dataDespesa = LocalDate.parse(dataDespesa, formatter);
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    @JsonIgnore
    public Dashboard getDashboard() {
        return dashboard;
    }

    public void setDashboard(Dashboard dashboard) { this.dashboard = dashboard; }
}

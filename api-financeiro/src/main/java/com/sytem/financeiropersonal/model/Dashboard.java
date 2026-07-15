package com.sytem.financeiropersonal.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="tb_dashboard")
public class Dashboard implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy="dashboard")
    private MesDashboard mesDashboard;

    @OneToMany(mappedBy = "dashboard", cascade = CascadeType.ALL,  orphanRemoval = true)
    private List<Despesa> despesas = new ArrayList<>();

    @OneToMany(mappedBy = "dashboard", cascade = CascadeType.ALL,  orphanRemoval = true)
    private List<Entrada> entradas = new ArrayList<>();

    public Dashboard() {}

    public Long getId() {
        return id;
    }

    public List<Entrada> getEntradas() {
        return entradas;
    }
    public void setEntradas(List<Entrada> entradas) {
        this.entradas = entradas;
    }

    public List<Despesa> getDespesas() {
        return despesas;
    }
    public void setDespesas(List<Despesa> despesas) {
        this.despesas = despesas;
    }

    @JsonIgnore
    public MesDashboard getMes() {
        return mesDashboard;
    }

    public void setMes(MesDashboard mesDashboard) {
        this.mesDashboard = mesDashboard;
    }

    public void addEntrada(Entrada entrada) {
        entradas.add(entrada);
        entrada.setDashboard(this);
    }

    public void removeEntrada(Entrada entrada) {
        entradas.remove(entrada);
        entrada.setDashboard(null);
    }

    public void addDespesa(Despesa despesa) {
        despesas.add(despesa);
        despesa.setDashboard(this);
    }

    public void removeDespesa(Despesa despesa) {
        despesas.remove(despesa);
        despesa.setDashboard(null);
    }

    public double getTotalDespesas() {
        return Math.round(
                despesas.stream()
                .mapToDouble(Despesa::getValor)
                .sum() * 100
        ) / 100.0;
    }

    public double getTotalEntradas() {
        return Math.round(
                entradas.stream()
                .mapToDouble(Entrada::getValor)
                .sum() * 100
        ) / 100.0;
    }

    public double getTotalSaldo(){
        return Math.round(
                (getTotalEntradas() - getTotalDespesas()) * 100
        ) / 100.0;
    }

}

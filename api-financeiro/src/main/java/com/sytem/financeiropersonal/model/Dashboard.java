package com.sytem.financeiropersonal.model;

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

    @ManyToOne
    @JoinColumn(name="user_id")
    private UserEntity userEntity;

    @OneToMany(mappedBy = "dashboard", cascade = CascadeType.ALL)
    private List<Despesa> despesas = new ArrayList<>();

    @OneToMany(mappedBy = "dashboard", cascade = CascadeType.ALL)
    private List<Entrada> entradas = new ArrayList<>();

    public Dashboard() {}

    public Dashboard(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

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

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public double getTotalDespesas() {
        return despesas.stream()
                .mapToDouble(Despesa::getValor)
                .sum();
    }

    public double getTotalEntradas() {
        return entradas.stream()
                .mapToDouble(Entrada::getValor)
                .sum();
    }

    public double getTotalSaldo(){
        return getTotalEntradas() - getTotalDespesas();
    }

}

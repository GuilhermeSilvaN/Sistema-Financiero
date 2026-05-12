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
    private UserEntity user;

    @OneToMany(mappedBy = "despesas")
    private List<Despesa> despesas = new ArrayList<>();

    @OneToMany(mappedBy = "entradas")
    private List<Entrada> entradas = new ArrayList<>();

    public Dashboard() {}

    public Long getId() {
        return id;
    }

    public List<Entrada> getEntradas() {
        return entradas;
    }

    public List<Despesa> getDespesas() {
        return despesas;
    }

    public UserEntity getUser() {
        return user;
    }
}

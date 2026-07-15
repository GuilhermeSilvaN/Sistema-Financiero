package com.sytem.financeiropersonal.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name="tb_mes_dashboard")
public class MesDashboard implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer month;

    private Integer year;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_userEntity", nullable=false)
    private UserEntity userEntity;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_dashboard")
    private Dashboard dashboard;

    public MesDashboard() {}

    public MesDashboard(Integer month, Integer year, UserEntity userEntity, Dashboard dashboard) {
        this.month = month;
        this.year = year;
        this.userEntity = userEntity;
        this.dashboard = dashboard;
    }

    public Long getId() {
        return id;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) { this.month = month;}

    public Integer getYear() { return year; }

    public void setYear(Integer year) { this.year = year; }

    @JsonIgnore
    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) { this.userEntity = userEntity; }

    public Dashboard getDashboard() {
        return dashboard;
    }

    public  void setDashboard(Dashboard dashboard) {  this.dashboard = dashboard; }
}

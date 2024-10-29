package com.api.rest.lksbaas.model;

import javax.persistence.*;
import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;

@Entity
@Table(name = "DatoVivienda")
public class DatoVivienda implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "valorVivienda", nullable = false)
    private double valorVivienda;

    @Column(name = "valorInmueble", nullable = false)
    private double valorInmueble;

    @Column(name = "noAvaluo", nullable = false)
    private int noAvaluo;

    @Column(name = "loan", nullable = false)
    private double loan;

    @ManyToOne
    @JoinColumns({
        @JoinColumn(name = "ideCredito", referencedColumnName = "ideCredito"),
        @JoinColumn(name = "ideLineaCredito", referencedColumnName = "ideLineaCredito")
    })
    private IdentificadorCredito identificadorCredito;

 // Metodos

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getValorVivienda() {
        return valorVivienda;
    }

    public void setValorVivienda(double valorVivienda) {
        this.valorVivienda = valorVivienda;
    }

    public double getValorInmueble() {
        return valorInmueble;
    }

    public void setValorInmueble(double valorInmueble) {
        this.valorInmueble = valorInmueble;
    }

    public int getNoAvaluo() {
        return noAvaluo;
    }

    public void setNoAvaluo(int noAvaluo) {
        this.noAvaluo = noAvaluo;
    }

    public double getLoan() {
        return loan;
    }

    public void setLoan(double loan) {
        this.loan = loan;
    }

    public IdentificadorCredito getIdentificadorCredito() {
        return identificadorCredito;
    }

    public void setIdentificadorCredito(IdentificadorCredito identificadorCredito) {
        this.identificadorCredito = identificadorCredito;
    }
}

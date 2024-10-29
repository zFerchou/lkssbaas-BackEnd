package com.api.rest.lksbaas.model;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Credito")
public class Credito implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "tipoCredito", nullable = false)
    private String tipoCredito;

    @Column(name = "montoOriginal", nullable = false)
    private double montoOriginal;

    @Column(name = "saldoActual", nullable = false)
    private double saldoActual;

    @Column(name = "tasaInteres", nullable = false)
    private double tasaInteres;

    @ManyToOne
    @JoinColumn(name = "idAcreditado")
    private IdentificadorAcreditado acreditado;

    // Campo para manejar estado activo/inactivo
    @Column(name = "activo", nullable = false)
    private boolean activo;

    // Métodos

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipoCredito() {
        return tipoCredito;
    }

    public void setTipoCredito(String tipoCredito) {
        this.tipoCredito = tipoCredito;
    }

    public double getMontoOriginal() {
        return montoOriginal;
    }

    public void setMontoOriginal(double montoOriginal) {
        this.montoOriginal = montoOriginal;
    }

    public double getSaldoActual() {
        return saldoActual;
    }

    public void setSaldoActual(double saldoActual) {
        this.saldoActual = saldoActual;
    }

    public double getTasaInteres() {
        return tasaInteres;
    }

    public void setTasaInteres(double tasaInteres) {
        this.tasaInteres = tasaInteres;
    }

    public IdentificadorAcreditado getAcreditado() {
        return acreditado;
    }

    public void setAcreditado(IdentificadorAcreditado acreditado) {
        this.acreditado = acreditado;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}

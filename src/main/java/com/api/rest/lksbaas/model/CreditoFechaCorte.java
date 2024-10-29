package com.api.rest.lksbaas.model;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "CreditoFechaCorte")
public class CreditoFechaCorte implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "fechaCorte", nullable = false, length = 8)
    private String fechaCorte;

    @Column(name = "montoInsoluto", nullable = false)
    private double montoInsoluto;

    @Column(name = "saldoInsoluto", nullable = false)
    private double saldoInsoluto;

    @Column(name = "pagoAmortizacion", nullable = false)
    private double pagoAmortizacion;

    @Column(name = "pagoIntereses", nullable = false)
    private double pagoIntereses;

    @Column(name = "pagoCapital", nullable = false)
    private double pagoCapital;

    @Column(name = "totalPagado", nullable = false)
    private double totalPagado;

    @ManyToOne
    @JoinColumns({
        @JoinColumn(name = "ideCredito", referencedColumnName = "ideCredito"),
        @JoinColumn(name = "ideLineaCredito", referencedColumnName = "ideLineaCredito")
    })
    private IdentificadorCredito identificadorCredito;

    @Column(name = "activo", nullable = false)
    private boolean activo = true;  // Campo para el estado de activo/inactivo

    // Métodos

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFechaCorte() {
        return fechaCorte;
    }

    public void setFechaCorte(String fechaCorte) {
        this.fechaCorte = fechaCorte;
    }

    public double getMontoInsoluto() {
        return montoInsoluto;
    }

    public void setMontoInsoluto(double montoInsoluto) {
        this.montoInsoluto = montoInsoluto;
    }

    public double getSaldoInsoluto() {
        return saldoInsoluto;
    }

    public void setSaldoInsoluto(double saldoInsoluto) {
        this.saldoInsoluto = saldoInsoluto;
    }

    public double getPagoAmortizacion() {
        return pagoAmortizacion;
    }

    public void setPagoAmortizacion(double pagoAmortizacion) {
        this.pagoAmortizacion = pagoAmortizacion;
    }

    public double getPagoIntereses() {
        return pagoIntereses;
    }

    public void setPagoIntereses(double pagoIntereses) {
        this.pagoIntereses = pagoIntereses;
    }

    public double getPagoCapital() {
        return pagoCapital;
    }

    public void setPagoCapital(double pagoCapital) {
        this.pagoCapital = pagoCapital;
    }

    public double getTotalPagado() {
        return totalPagado;
    }

    public void setTotalPagado(double totalPagado) {
        this.totalPagado = totalPagado;
    }

    public IdentificadorCredito getIdentificadorCredito() {
        return identificadorCredito;
    }

    public void setIdentificadorCredito(IdentificadorCredito identificadorCredito) {
        this.identificadorCredito = identificadorCredito;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

	public boolean isPresent() {
		// TODO Auto-generated method stub
		return false;
	}

	public CreditoFechaCorte get() {
		// TODO Auto-generated method stub
		return null;
	}


}

package com.api.rest.lksbaas.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "CondicionFinanciera")
public class CondicionFinanciera implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "montoPesos", nullable = false)
    private double montoPesos;

    @Column(name = "montoMonedaOrigen", nullable = false)
    private double montoMonedaOrigen;

    @Column(name = "fechaDisposicion", nullable = false, length = 10)
    private String fechaDisposicion;

    @Column(name = "fechaVencimiento", nullable = false, length = 10)
    private String fechaVencimiento;

    @Column(name = "formaAdquisicion", nullable = false, length = 255)
    private String formaAdquisicion;

    @Column(name = "tasaInteres", nullable = false)
    private double tasaInteres;

    @Column(name = "diferenciaTasa", nullable = false)
    private double diferenciaTasa;

    @Column(name = "operacionTasa", nullable = false)
    private int operacionTasa;

    @Column(name = "tipoMoneda", nullable = false)
    private int tipoMoneda;

    @Column(name = "periodoPagosCapital", nullable = false)
    private int periodoPagosCapital;

    @Column(name = "periodoPagosInteres", nullable = false)
    private int periodoPagosInteres;

    @Column(name = "periodoFacturacion", nullable = false)
    private int periodoFacturacion;

    @Column(name = "comisionATasa", nullable = false)
    private double comisionATasa;

    @Column(name = "comisionAMonto", nullable = false)
    private double comisionAMonto;

    @Column(name = "comisionDTasa", nullable = false)
    private double comisionDTasa;

    @Column(name = "comisionDMonto", nullable = false)
    private double comisionDMonto;

    @ManyToOne
    @JoinColumns({
        @JoinColumn(name = "ideCredito", referencedColumnName = "ideCredito"),
        @JoinColumn(name = "ideLineaCredito", referencedColumnName = "ideLineaCredito")
    })
    private IdentificadorCredito identificadorCredito;

    // indicar si la condicion financiera está activa o inactiva
    @Column(name = "activo", nullable = false)
    private boolean activo = true;  // Por defecto, el registro está activo

    // Getters y Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getMontoPesos() {
        return montoPesos;
    }

    public void setMontoPesos(double montoPesos) {
        this.montoPesos = montoPesos;
    }

    public double getMontoMonedaOrigen() {
        return montoMonedaOrigen;
    }

    public void setMontoMonedaOrigen(double montoMonedaOrigen) {
        this.montoMonedaOrigen = montoMonedaOrigen;
    }

    public String getFechaDisposicion() {
        return fechaDisposicion;
    }

    public void setFechaDisposicion(String fechaDisposicion) {
        this.fechaDisposicion = fechaDisposicion;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getFormaAdquisicion() {
        return formaAdquisicion;
    }

    public void setFormaAdquisicion(String formaAdquisicion) {
        this.formaAdquisicion = formaAdquisicion;
    }

    public double getTasaInteres() {
        return tasaInteres;
    }

    public void setTasaInteres(double tasaInteres) {
        this.tasaInteres = tasaInteres;
    }

    public double getDiferenciaTasa() {
        return diferenciaTasa;
    }

    public void setDiferenciaTasa(double diferenciaTasa) {
        this.diferenciaTasa = diferenciaTasa;
    }

    public int getOperacionTasa() {
        return operacionTasa;
    }

    public void setOperacionTasa(int operacionTasa) {
        this.operacionTasa = operacionTasa;
    }

    public int getTipoMoneda() {
        return tipoMoneda;
    }

    public void setTipoMoneda(int tipoMoneda) {
        this.tipoMoneda = tipoMoneda;
    }

    public int getPeriodoPagosCapital() {
        return periodoPagosCapital;
    }

    public void setPeriodoPagosCapital(int periodoPagosCapital) {
        this.periodoPagosCapital = periodoPagosCapital;
    }

    public int getPeriodoPagosInteres() {
        return periodoPagosInteres;
    }

    public void setPeriodoPagosInteres(int periodoPagosInteres) {
        this.periodoPagosInteres = periodoPagosInteres;
    }

    public int getPeriodoFacturacion() {
        return periodoFacturacion;
    }

    public void setPeriodoFacturacion(int periodoFacturacion) {
        this.periodoFacturacion = periodoFacturacion;
    }

    public double getComisionATasa() {
        return comisionATasa;
    }

    public void setComisionATasa(double comisionATasa) {
        this.comisionATasa = comisionATasa;
    }

    public double getComisionAMonto() {
        return comisionAMonto;
    }

    public void setComisionAMonto(double comisionAMonto) {
        this.comisionAMonto = comisionAMonto;
    }

    public double getComisionDTasa() {
        return comisionDTasa;
    }

    public void setComisionDTasa(double comisionDTasa) {
        this.comisionDTasa = comisionDTasa;
    }

    public double getComisionDMonto() {
        return comisionDMonto;
    }

    public void setComisionDMonto(double comisionDMonto) {
        this.comisionDMonto = comisionDMonto;
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

	public List<CondicionFinanciera> getCampoRequerido() {
		// TODO Auto-generated method stub
		return null;
	}
}


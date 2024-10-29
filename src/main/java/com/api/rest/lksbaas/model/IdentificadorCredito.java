package com.api.rest.lksbaas.model;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "IdentificadorCredito")
public class IdentificadorCredito implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ideCredito", nullable = false, length = 50)
    private String ideCredito;

    @Column(name = "ideLineaCredito", nullable = false, length = 50)
    private String ideLineaCredito;

    @Column(name = "fechaOtorgamiento", nullable = false, length = 8)
    private String fechaOtorgamiento;

    @Column(name = "tipoAlta", nullable = false)
    private int tipoAlta;

    @Column(name = "tipoCartera", nullable = false)
    private int tipoCartera;

    @Column(name = "tipoProducto", nullable = false, length = 255)
    private String tipoProducto;

    @Column(name = "destinoCredito", nullable = false)
    private int destinoCredito;

    @Column(name = "claveSucursal", nullable = false, length = 50)
    private String claveSucursal;

    @Column(name = "noCuenta", nullable = false, length = 50)
    private String noCuenta;

    @Column(name = "noContrato", nullable = false, length = 50)
    private String noContrato;

    @Column(name = "nombreFactorado", nullable = false, length = 255)
    private String nombreFactorado;

    @Column(name = "rfcFactorado", nullable = false, length = 50)
    private String rfcFactorado;

    @Column(name = "activo", nullable = false)
    private boolean activo = true;

    @ManyToOne
    @JoinColumn(name = "noCliente", referencedColumnName = "noCliente")
    private IdentificadorAcreditado identificadorAcreditado;

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdeCredito() {
        return ideCredito;
    }

    public void setIdeCredito(String ideCredito) {
        this.ideCredito = ideCredito;
    }

    public String getIdeLineaCredito() {
        return ideLineaCredito;
    }

    public void setIdeLineaCredito(String ideLineaCredito) {
        this.ideLineaCredito = ideLineaCredito;
    }

    public String getFechaOtorgamiento() {
        return fechaOtorgamiento;
    }

    public void setFechaOtorgamiento(String fechaOtorgamiento) {
        this.fechaOtorgamiento = fechaOtorgamiento;
    }

    public int getTipoAlta() {
        return tipoAlta;
    }

    public void setTipoAlta(int tipoAlta) {
        this.tipoAlta = tipoAlta;
    }

    public int getTipoCartera() {
        return tipoCartera;
    }

    public void setTipoCartera(int tipoCartera) {
        this.tipoCartera = tipoCartera;
    }

    public String getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(String tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public int getDestinoCredito() {
        return destinoCredito;
    }

    public void setDestinoCredito(int destinoCredito) {
        this.destinoCredito = destinoCredito;
    }

    public String getClaveSucursal() {
        return claveSucursal;
    }

    public void setClaveSucursal(String claveSucursal) {
        this.claveSucursal = claveSucursal;
    }

    public String getNoCuenta() {
        return noCuenta;
    }

    public void setNoCuenta(String noCuenta) {
        this.noCuenta = noCuenta;
    }

    public String getNoContrato() {
        return noContrato;
    }

    public void setNoContrato(String noContrato) {
        this.noContrato = noContrato;
    }

    public String getNombreFactorado() {
        return nombreFactorado;
    }

    public void setNombreFactorado(String nombreFactorado) {
        this.nombreFactorado = nombreFactorado;
    }

    public String getRfcFactorado() {
        return rfcFactorado;
    }

    public void setRfcFactorado(String rfcFactorado) {
        this.rfcFactorado = rfcFactorado;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public IdentificadorAcreditado getIdentificadorAcreditado() {
        return identificadorAcreditado;
    }

    public void setIdentificadorAcreditado(IdentificadorAcreditado identificadorAcreditado) {
        this.identificadorAcreditado = identificadorAcreditado;
    }
    
    public String getNoCliente() {
        return identificadorAcreditado != null ? identificadorAcreditado.getNoCliente() : null;
    }

    public void setNoCliente(String noCliente) {
        if (this.identificadorAcreditado == null) {
            this.identificadorAcreditado = new IdentificadorAcreditado();
        }
        this.identificadorAcreditado.setNoCliente(noCliente);
    }
}

package com.api.rest.lksbaas.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "IdentificadorAcreditado")
public class IdentificadorAcreditado implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "noCliente", nullable = false, length = 50)
    private String noCliente;

    @Column(name = "tipoCliente", nullable = false)
    private int tipoCliente;

    @Column(name = "nombres", nullable = false, length = 255)
    private String nombres;

    @Column(name = "aPaterno", nullable = false, length = 255)
    private String aPaterno;

    @Column(name = "aMaterno", nullable = false, length = 255)
    private String aMaterno;

    @Column(name = "pJuridica", nullable = false)
    private int pJuridica;

    @Column(name = "grupoRiesgo", length = 255)
    private String grupoRiesgo;

    @Column(name = "actEconomicaAcreditado", length = 255)
    private String actEconomicaAcreditado;

    @Column(name = "nacionalidad", nullable = false)
    private int nacionalidad;

    @Column(name = "fechaNacimiento", nullable = false, length = 8)
    private String fechaNacimiento;

    @Column(name = "rfc", nullable = false, length = 50)
    private String rfc;

    @Column(name = "curp", nullable = false, length = 50)
    private String curp;

    @Column(name = "genero", nullable = false)
    private int genero;

    @Column(name = "calle", nullable = false, length = 255)
    private String calle;

    @Column(name = "noExterior", nullable = false, length = 50)
    private String noExterior;

    @Column(name = "colonia", nullable = false, length = 255)
    private String colonia;

    @Column(name = "cp", nullable = false)
    private int cp;

    @Column(name = "localidad", nullable = false, length = 255)
    private String localidad;

    @Column(name = "estado", nullable = false)
    private int estado;

    @Column(name = "municipio", nullable = false)
    private int municipio;

    @Column(name = "pais", nullable = false)
    private int pais;

    @Column(name = "tipoAcreditado", nullable = false)
    private int tipoAcreditado;

    @Column(name = "consultasSIC")
    private Integer consultasSIC;

    @Column(name = "ingresos", nullable = false)
    private float ingresos;

    @Column(name = "tamaño")
    private Integer tamaño;

    @Column(name = "activo")
    private boolean activo;

    // Métodos getter y setter

    public String getNoCliente() {
        return noCliente;
    }

    public void setNoCliente(String noCliente) {
        this.noCliente = noCliente;
    }

    public int getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(int tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getaPaterno() {
        return aPaterno;
    }

    public void setaPaterno(String aPaterno) {
        this.aPaterno = aPaterno;
    }

    public String getaMaterno() {
        return aMaterno;
    }

    public void setaMaterno(String aMaterno) {
        this.aMaterno = aMaterno;
    }

    public int getpJuridica() {
        return pJuridica;
    }

    public void setpJuridica(int pJuridica) {
        this.pJuridica = pJuridica;
    }

    public String getGrupoRiesgo() {
        return grupoRiesgo;
    }

    public void setGrupoRiesgo(String grupoRiesgo) {
        this.grupoRiesgo = grupoRiesgo;
    }

    public String getActEconomicaAcreditado() {
        return actEconomicaAcreditado;
    }

    public void setActEconomicaAcreditado(String actEconomicaAcreditado) {
        this.actEconomicaAcreditado = actEconomicaAcreditado;
    }

    public int getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(int nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public int getGenero() {
        return genero;
    }

    public void setGenero(int genero) {
        this.genero = genero;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNoExterior() {
        return noExterior;
    }

    public void setNoExterior(String noExterior) {
        this.noExterior = noExterior;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getMunicipio() {
        return municipio;
    }

    public void setMunicipio(int municipio) {
        this.municipio = municipio;
    }

    public int getPais() {
        return pais;
    }

    public void setPais(int pais) {
        this.pais = pais;
    }

    public int getTipoAcreditado() {
        return tipoAcreditado;
    }

    public void setTipoAcreditado(int tipoAcreditado) {
        this.tipoAcreditado = tipoAcreditado;
    }

    public Integer getConsultasSIC() {
        return consultasSIC;
    }

    public void setConsultasSIC(Integer consultasSIC) {
        this.consultasSIC = consultasSIC;
    }

    public float getIngresos() {
        return ingresos;
    }

    public void setIngresos(float ingresos) {
        this.ingresos = ingresos;
    }

    public Integer getTamaño() {
        return tamaño;
    }

    public void setTamaño(Integer tamaño) {
        this.tamaño = tamaño;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

	public Date getId() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setId(int numericCellValue) {
		// TODO Auto-generated method stub
		
	}
}

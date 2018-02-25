package com.example.cesar.core.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * La clase de persistencia para la tabla perfiles 
 * 
 */
@Entity
@Table(name="registros_pesca")
@NamedQuery(name="RegistroPesca.findAll", query="SELECT p FROM RegistroPesca p")
public class RegistroPesca implements Serializable {
	
	private static final long serialVersionUID = -2532555532765664848L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private Integer id_tipo_pesca;
	
	private Integer cant_personas;
	
	private Timestamp fecha_entrada;
	
	private Integer monto_horas_planificadas;
	
	
	public Integer getMonto_horas_planificadas() {
		return monto_horas_planificadas;
	}

	public void setMonto_horas_planificadas(Integer monto_horas_planificadas) {
		this.monto_horas_planificadas = monto_horas_planificadas;
	}



	private Integer cant_horas_planificadas;
	
	private Timestamp fecha_salida_planificada;
	
	
	
	public Timestamp getFecha_salida_planificada() {
		return fecha_salida_planificada;
	}

	public void setFecha_salida_planificada(Timestamp fecha_salida_planificada) {
		this.fecha_salida_planificada = fecha_salida_planificada;
	}



	private Timestamp fecha_salida_real;
	
	private Integer cant_horas_reales;
	
	public Integer getCantidad_horas_reales() {
		return cant_horas_reales;
	}

	public void setCantidad_horas_reales(Integer cant_horas_reales) {
		this.cant_horas_reales = cant_horas_reales;
	}



	private Integer monto_horas_reales;
	
	private String nombre_responsable;
	
	private String estado;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId_tipo_pesca() {
		return id_tipo_pesca;
	}

	public void setId_tipo_pesca(Integer id_tipo_pesca) {
		this.id_tipo_pesca = id_tipo_pesca;
	}

	public Integer getCant_personas() {
		return cant_personas;
	}

	public void setCant_personas(Integer cant_personas) {
		this.cant_personas = cant_personas;
	}

	public Timestamp getFecha_entrada() {
		return fecha_entrada;
	}

	public void setFecha_entrada(Timestamp fecha_entrada) {
		this.fecha_entrada = fecha_entrada;
	}

	public Integer getCant_horas_planificadas() {
		return cant_horas_planificadas;
	}

	public void setCant_horas_planificadas(Integer cant_horas_planificadas) {
		this.cant_horas_planificadas = cant_horas_planificadas;
	}

	public Timestamp getFecha_salida_real() {
		return fecha_salida_real;
	}

	public void setFecha_salida_real(Timestamp fecha_salida_real) {
		this.fecha_salida_real = fecha_salida_real;
	}

	public Integer getMonto_horas_reales() {
		return monto_horas_reales;
	}

	public void setMonto_horas_reales(Integer monto_horas_reales) {
		this.monto_horas_reales = monto_horas_reales;
	}

	public String getNombre_responsable() {
		return nombre_responsable;
	}

	public void setNombre_responsable(String nombre_responsable) {
		this.nombre_responsable = nombre_responsable;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

	public RegistroPesca() {
	}


}
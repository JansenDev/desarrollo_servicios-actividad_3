package com.idat.desarrollo_servicio_actividad_3.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="aula")
public class Aula implements Serializable{
		
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer aula_id;
	
	@Column
	private int grado;
	
	@Column
	private String seccion;
	
	@Column
	private int foro;
	
	@ManyToOne
	@JoinColumn(name="profesor_id", nullable = false, unique = true,
	foreignKey = @ForeignKey(foreignKeyDefinition = "foreign Key(profesor_id) references profesor(profesor_id)"))
	
	private Profesor profesor;

	public Aula() {
		super();
	}
	
	public Aula(Integer aula_id, int grado, String seccion, int foro, Profesor profesor) {
		super();
		this.aula_id = aula_id;
		this.grado = grado;
		this.seccion = seccion;
		this.foro = foro;
		this.profesor = profesor;
	}

	public Integer getAula_id() {
		return aula_id;
	}

	public void setAula_id(Integer aula_id) {
		this.aula_id = aula_id;
	}

	public int getGrado() {
		return grado;
	}

	public void setGrado(int grado) {
		this.grado = grado;
	}

	public String getSeccion() {
		return seccion;
	}

	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}

	public int getForo() {
		return foro;
	}

	public void setForo(int foro) {
		this.foro = foro;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}
	
}






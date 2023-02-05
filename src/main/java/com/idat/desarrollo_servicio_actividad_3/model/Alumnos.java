package com.idat.desarrollo_servicio_actividad_3.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name="alumnos")
public class Alumnos implements Serializable{
	private static final long serialVersionUID=1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int profesor_id;
	
	@Column
	private String nombre;
	
	@Column
	private String apellidos;
	
	@Column
	private int edad;
	
	@Column(unique=true,nullable=false)
	private String correo;
	
	@ManyToMany()
	@JoinColumn(name = "profesores")
	private Collection<Profesor> profesor;
	
	public Alumnos() {
		
	}

	public Alumnos(int profesor_id, String nombre, String apellidos, int edad, String correo) {
		super();
		this.profesor_id = profesor_id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
		this.correo = correo;
	}

	public int getProfesor_id() {
		return profesor_id;
	}

	public void setProfesor_id(int profesor_id) {
		this.profesor_id = profesor_id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}
		
	

}

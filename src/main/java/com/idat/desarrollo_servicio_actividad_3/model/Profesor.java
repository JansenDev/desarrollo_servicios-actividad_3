package com.idat.desarrollo_servicio_actividad_3.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="profesores")
public class Profesor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int profesor_id;

    private String nombre;

    private String apellidos;

    private int edad;

    private String email;

    @OneToOne(mappedBy = "profesor")
    private Conyuge conyuge;

    public Profesor(int profesor_id, String nombre, String apellidos, int edad, String email) {
        this.profesor_id = profesor_id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.email = email;
    }

    public Profesor() {

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

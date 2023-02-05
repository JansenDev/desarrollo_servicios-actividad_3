package com.idat.desarrollo_servicio_actividad_3.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Conyuge implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int conyuge_id;

    private String nombre;

    private String apellidos;

    private int edad;

    @OneToOne
    @JoinColumn(nullable = true, unique = true, foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key (profesor_profesor_id) references profesores (profesor_id)"))
    private Profesor profesor;

    public Conyuge(int conyuge_id, String nombre, String apellidos, int edad) {
        this.conyuge_id = conyuge_id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
    }

    public Conyuge() {
        
    }

    public int getConyuge_id() {
        return conyuge_id;
    }

    public void setConyuge_id(int conyuge_id) {
        this.conyuge_id = conyuge_id;
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
}

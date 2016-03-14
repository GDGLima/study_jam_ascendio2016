package com.gdglima.modelo;

import com.gdglima.interfaz.IEmpresa;


public abstract class Trabajador implements IEmpresa{

    protected String nombre;
    protected int edad;

    public Trabajador(String nombre) {
        this.nombre = nombre;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //public abstract double calcularSueldo();

}

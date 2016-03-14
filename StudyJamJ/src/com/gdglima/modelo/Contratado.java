package com.gdglima.modelo;

public class Contratado extends Trabajador{


    private double numhoras;
    private double entradas;


    public Contratado( String nombre,  double numhoras) {
        super(nombre);
        this.numhoras = numhoras;
    }

    public double getNumhoras() {
        return numhoras;
    }

    public void setNumhoras(double numhoras) {
        this.numhoras = numhoras;
    }


    @Override
    public double calcularSueldo() {
        double sueldo;
        return sueldo = this.numhoras * 80;

    }

    @Override
    public String visualizar() {
        return "Nombre " + nombre ;
    }

}

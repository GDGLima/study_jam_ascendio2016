package com.gdglima.modelo;

public class TiempoCompleto extends Trabajador{

    private double sueldo = 1000;
    private double numventas;

    //private double comision = 0.10;

    public TiempoCompleto(String nombre, double sueldo, double numventas ) {
        super(nombre);
        this.sueldo = sueldo;
        this.numventas = numventas;
    }


    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public double getNumventas() {
        return numventas;
    }

    public void setNumventas(double numventas) {
        this.numventas = numventas;
    }

    @Override
    public double calcularSueldo() {

        double totalSueldo;
        return totalSueldo = this.sueldo + (this.numventas *(this.sueldo * 0.10));
    }

    @Override
    public String visualizar() {
        return "Nombre " + nombre;
    }

}

package com.gdglima.controlador;


import com.gdglima.modelo.Contratado;
import com.gdglima.modelo.TiempoCompleto;
import com.gdglima.modelo.Trabajador;

import java.util.ArrayList;

public class ControlPersonal {


    static ArrayList<Trabajador> trabajadores = new ArrayList();


    public static void procesarOpcion(char opcion, String nombre, double sueldo, double ventas, double horas) {
        switch (opcion) {
            case '1':
                trabajadores.add(new TiempoCompleto(nombre, sueldo, ventas));
                break;
            case '2':
                trabajadores.add(new Contratado(nombre, horas ));

        }

    }

    public static ArrayList<Trabajador> getTrabajadores() {
        return trabajadores;
    }



}


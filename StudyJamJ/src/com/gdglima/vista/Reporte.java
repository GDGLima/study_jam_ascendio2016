package com.gdglima.vista;

import com.gdglima.controlador.ControlPersonal;
import com.gdglima.modelo.Trabajador;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Reporte {

    public static void menu() {
        System.out.println("Planilla de Trabajadores");
        System.out.println(" ");
        System.out.println("1) Trabajador Tiempo Completo");
        System.out.println("2) Trabajador Contratado");

        System.out.print("Ingrese su opción\t:");

    }

    public static void leerOpcion() {
        char opcion = ' ', contin = ' ';
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String nombre = "";
        double sueldo = 0;
        double dato = 0;
        double horas = 0;
        try {
            do {
                menu();


                opcion = in.readLine().charAt(0);
                switch (opcion) {
                    case '1':
                        System.out.print("Nombre Trabajador\t:");
                        nombre = in.readLine();
                        System.out.print("Sueldo\t:");
                        sueldo = Double.parseDouble(in.readLine());
                        System.out.print("Total Ventas\t:");
                        dato = Double.parseDouble(in.readLine());
                        break;

                    case '2':
                        System.out.print("Nombre Trabajador\t:");
                        nombre = in.readLine();
                        System.out.print("Cantidad de Horas Trabajadas\t:");

                        horas = Double.parseDouble(in.readLine());
                        break;

                }

                ControlPersonal.procesarOpcion(opcion, nombre, sueldo, dato, horas);

                System.out.print("Desea Agregar Otro Trabajador S/N\t:");
                contin = in.readLine().charAt(0);


            } while (contin == 'S' || contin == 's');

        } catch (Exception e) {
        }

        mostrarPlanilla();


    }

    public static void mostrarPlanilla() {
        ArrayList<Trabajador> lista = null;

        double totalsueldo = 0, totalSueldoContratado = 0, totalSueldoCompleto = 0;
        int trabajadores = 0, totalContratados = 0, totalCompleto = 0;

        lista = ControlPersonal.getTrabajadores();
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i).getNombre() + " Sueldo " + lista.get(i).calcularSueldo());

            if (lista.get(i) instanceof com.gdglima.modelo.TiempoCompleto) {
                totalContratados++;
                totalSueldoContratado += lista.get(i).calcularSueldo();
            }
            if (lista.get(i) instanceof com.gdglima.modelo.Contratado) {
                totalCompleto++;
                totalSueldoCompleto += lista.get(i).calcularSueldo();

            }
            trabajadores++;
            totalsueldo = lista.get(i).calcularSueldo() + totalsueldo;
        }
        System.out.println("=============================================================");
        System.out.println("Total de sueldo : " + totalsueldo);
        System.out.println("Total de Trabajadores : " + trabajadores);
        System.out.println("Trabajadores Tiempo Completo :" + totalContratados + " Total " + totalSueldoContratado);
        System.out.println("Trabajadores Contrado        :" + totalCompleto + " Total " + totalSueldoCompleto);

    }

}

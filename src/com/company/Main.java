package com.company;

import javax.swing.*;
import java.text.DecimalFormat;

public class Main {

    static DecimalFormat df = new DecimalFormat("#,###,##0.00");
    static String[] marcas = {"Mazda", "Renault", "Chevrolet"};

    static int precio = 0;
    static int planMes = 0;
    static int planAnios = 0;
    static double cuotaInicial = 0;
    static double saldoPorPagar = 0;
    static double tasaAnual = 0.0211;
    static double vrCuotas = 0;

    static boolean salir = false;

    static Carro mazda1 = new Carro(marcas[0] + " 3", marcas[0], 2004, 25000000);
    static Carro mazda2 = new Carro(marcas[0] + " 5", marcas[0], 2008, 35000000);
    static Carro renault1 = new Carro(marcas[1] + " Duster", marcas[1], 2009, 45000000);
    static Carro renault2 = new Carro(marcas[1] + " 4", marcas[1], 1994, 15000000);
    static Carro chevrolet1 = new Carro(marcas[2] + " Spark", marcas[2], 2014, 25000000);
    static Carro chevrolet2 = new Carro(marcas[2] + " Zafiro", marcas[2], 2012, 32000000);

    static String[] itemsMenu = {
            "1. " + mazda1.getNombre() + " - Modelo: " + mazda1.getModelo() + " - Precio: $" + df.format(mazda1.getPrecio()),
            "\n \n 2. " + mazda2.getNombre() + " - Modelo: " + mazda2.getModelo() + " - Precio: $ " + df.format(mazda2.getPrecio()),
            "\n \n 3. " + renault1.getNombre() + " - Modelo: " + renault1.getModelo() + " - Precio: $ " + df.format(renault1.getPrecio()),
            "\n \n 4. " + renault2.getNombre() + " - Modelo: " + renault2.getModelo() + " - Precio: $ " + df.format(renault2.getPrecio()),
            "\n \n 5. " + chevrolet1.getNombre() + " - Modelo: " + chevrolet1.getModelo() + " - Precio: $ " + df.format(chevrolet1.getPrecio()),
            "\n \n 6. " + chevrolet2.getNombre() + " - Modelo: " + chevrolet2.getModelo() + " - Precio: $ " + df.format(chevrolet2.getPrecio()),
    };

    public static void main(String[] args) {
        // write your code here
        menu();
        financiacion();
        resumen();
    }

    public static void menu() {
        JOptionPane.showMessageDialog(null, "Bienvenido a carros el Pitufo");
        while (!salir) {
            try {
                JOptionPane.showMessageDialog(null, "Catalogo actual \n \n" + itemsMenu[0] + itemsMenu[1] + itemsMenu[2] + itemsMenu[3] + itemsMenu[4] + itemsMenu[5]);
                int opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "Escriba el número del carro a comprar para continuar " +
                        "\n 1. " + mazda1.getNombre() +
                        "\n 2. " + mazda2.getNombre() +
                        "\n 3. " + renault1.getNombre() +
                        "\n 4. " + renault2.getNombre() +
                        "\n 5. " + chevrolet1.getNombre() +
                        "\n 6. " + chevrolet2.getNombre() +
                        "\n 7. Salir"));

                switch (opcion) {
                    case 1:
                        precio = mazda1.getPrecio();
                        salir = true;
                        break;
                    case 2:
                        precio = mazda2.getPrecio();
                        salir = true;
                        break;
                    case 3:
                        precio = renault1.getPrecio();
                        salir = true;
                        break;
                    case 4:
                        precio = renault2.getPrecio();
                        salir = true;
                        break;
                    case 5:
                        precio = chevrolet1.getPrecio();
                        salir = true;
                        break;
                    case 6:
                        precio = chevrolet2.getPrecio();
                        salir = true;
                    case 7:
                        JOptionPane.showMessageDialog(null, "Dirigiendo a planes de financiación");
                        salir = true;
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Ingrese un valor válido");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Ingrese un valor válido");
            }
        }

    }

    public static void financiacion() {

        while (salir) {
            try {
                int planes = Integer.parseInt(JOptionPane.showInputDialog(null, "Seleccione un plan de financiación: \n 1. A 3 años \n 2. A 5 años \n 3. A 10 años"));

                switch (planes){
                    case 1:
                        planMes = 36;
                        planAnios = 3;
                        salir = false;
                        break;
                    case 2:
                        planMes = 60;
                        planAnios = 5;
                        salir = false;
                        break;
                    case 3:
                        planMes = 120;
                        planAnios = 10;
                        salir = false;
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Ingrese un valor válido");
                }

            }catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Ingrese un valor válido");
            }
        }
    }

    public static void resumen() {
        cuotaInicial = precio * 0.1;
        saldoPorPagar = precio - cuotaInicial;
        vrCuotas = (saldoPorPagar * (1 + (tasaAnual* planAnios))) / planMes;
        JOptionPane.showMessageDialog(null, "El valor de las cuotas es de $" + df.format(vrCuotas));
        JOptionPane.showMessageDialog(null, "Felicidades!! Ya es dueño de su vehículo");
    }
}

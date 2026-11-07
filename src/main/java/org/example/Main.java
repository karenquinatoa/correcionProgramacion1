package org.example;

import java.sql.SQLOutput;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);

        TarjetaMetro.mostrarTraifas();
        System.out.print("Titular: ");
        String titular = sc.nextLine();
        System.out.print("cedula: ");
        String cedula = sc.nextLine();
        System.out.print("Edad: ");
        int edad = sc.nextInt();
        sc.nextLine();
        System.out.print("Discapcidad (S/N): ");
        String discapacidad = sc.nextLine();
        boolean tieneDiscacidad = discapacidad.equalsIgnoreCase("s");
        System.out.print("Saldo inical: ");
        double saldo = sc.nextDouble();

        TarjetaMetro tj = new TarjetaMetro(titular, cedula, edad, saldo, tieneDiscacidad);
        while (true){
            System.out.println("1.Recargar");
            System.out.println("2.Pagar viaje");
            System.out.println("3.Consultar tarjeta");
            System.out.println("4, simular recarga");
            System.out.print("Ingrese una opcion: ");
            int opcion  = sc.nextInt();

            if (opcion == 1){
                System.out.println("Ingrese un monto a recragar: ");
                double monto = sc.nextDouble();
                tj.recargar(monto);
            } else if (opcion == 2) {
                tj.pagarViaje();
            } else if (opcion == 3) {
                tj.mostrarInformacion();
            } else if (opcion == 4) {
                System.out.println("Ingrese el monto a simular");
                double simular  = sc.nextDouble();
                System.out.println("Si recarga "+ simular + "tendria : " + tj.calcularViajesDisponibles(simular));
            } else if (opcion == 5) {
                System.out.println("Saliendo");
                break;
            }else {
                System.out.println("Intentelo denuevo opcion incorrecta");
            }
        }




    }
}
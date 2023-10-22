/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package daw;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author eduar
 */
public class BurgerCangreBurger {

    private static Scanner teclado = new Scanner(System.in);
    private static Random random = new Random();

    public static void main(String[] args) {
        String repetirProg;
        do {
            registroCliente();
            double total = precio();
            int dado = dadoTirada();
            parImpar(dado, total);
            teclado.nextLine();
            System.out.println("¿Hay mas clientes:? ");
            repetirProg = teclado.nextLine();
        } while (!(repetirProg.equalsIgnoreCase("no")));
    }

    private static double precio() {
        int numPedido;
        double precio, total = 0;
        System.out.print("Introduce la cantidad de productos pedidos: ");
        numPedido = teclado.nextInt();

        for (int i = 0; i < numPedido; i++) {
            System.out.println("introduce el precio del " + (i + 1) + "º producto");
            precio = teclado.nextDouble();
            total += precio;
        }
        System.out.printf("El total de tu pedido es de %.2f €\n", total);
        return total;
    }

    private static int dadoTirada() {
        /*
        Creo una variable tirada y la inicializo con la clase random para que 
        salga un número entre el 1 y el 6
         */
        int tirada;
        System.out.println("Ahora vas a tirar un dado");
        tirada = random.nextInt(1, 7);
        System.out.println("En el dado ha salido: \n" + tirada);
        return tirada;
    }

    private static void registroCliente() {
        /*
        Pido por scanner el nombre y apellido del cliente
         */
        System.out.println("Dime tu nombre: ");
        String nombre = teclado.nextLine();
        System.out.println("Dime tu 1º apellido: ");
        String apellido = teclado.nextLine();
        System.out.printf("Bienvenido %s %s\n", nombre, apellido);
    }

    private static boolean parImpar(int numero, double total) {
        /*
        creo un método que devuelve un boolean, se le debe de introducir la tirada
        del dado y el total de el pedido, creo un if-else, en el primer caso 
        si la tirada sale par se le hace un descuentro del %25, pero si sale impar
        el usuario debe de elegir entre blanco y negro y dependiendo de la elección
        se le hara un tipo de descuento.
         */
        final double IVA_PAR = 0.25, IVA_AMARILLA = 0.5, IVA_ROJA = 0.12;
        //final int DIVISION = 100;
        double resultado;
        if (numero % 2 == 0) {
            System.out.println("La tirada ha salido par, tienes un descuento"
                    + " del %25");
            resultado = total * IVA_PAR;
            System.out.printf("%.2f€\n", resultado);
            return true;
        } else {
            System.out.println("La tirada ha salido impar, "
                    + "debes sacar una bola (blanco, roja y amrilla) ");
            int blancoNegro = random.nextInt(1, 4);
            switch (blancoNegro) {
                case 1 -> {
                    System.out.println("¡BLANCO! No tienes descuento, mala suerte");
                    System.out.printf("%.2f€\n", total);
                }
                case 2 -> {
                    System.out.println("¡ROJO! Tienes un descuento del %12 ");
                    resultado = total * IVA_ROJA;
                    System.out.printf("%.2f€\n", resultado);
                }
                case 3 -> {
                    System.out.println("¡AMARILLO! Tienes un descuento del %5 ");
                    resultado = total * IVA_AMARILLA;
                    System.out.printf("%.2f€\n", resultado);
                }
            }
            return false;
        }
    }
}

import java.util.ArrayList;
import java.util.Scanner;

public class Examen2Parcial_Vilchis_JoseMiguel {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] productos = {"Chocolate", "Paleta", "Gomitas", "Galletas"};
        double[] precios = {18, 12, 25, 15};
        int[] ventas = new int[productos.length];
        ArrayList<String> clientes = new ArrayList<>();
        double totalRecaudado = 0;

        int totalClientes;
        do {
            System.out.print("Ingrese la cantidad de clientes a atender: ");
            totalClientes = sc.nextInt();
        } while (totalClientes <= 0);
        sc.nextLine();

        for (int i = 0; i < totalClientes; i++) {
            System.out.println("\n--- Cliente " + (i + 1) + " ---");
            System.out.print("Ingrese el nombre del cliente: ");
            String nombre = sc.nextLine();
            clientes.add(nombre);

            double totalCliente = 0;
            String respuesta;
            do {
                System.out.println("\nCatálogo de productos:");
                for (int j = 0; j < productos.length; j++) {
                    System.out.println((j + 1) + ". " + productos[j] + " - $" + precios[j]);
                }

                int codigo;
                do {
                    System.out.print("Ingrese el código del producto (1-4): ");
                    codigo = sc.nextInt();
                } while (codigo < 1 || codigo > productos.length);

                int cantidad;
                do {
                    System.out.print("Ingrese la cantidad que desea comprar: ");
                    cantidad = sc.nextInt();
                } while (cantidad <= 0);

                double importe = precios[codigo - 1] * cantidad;
                ventas[codigo - 1] += cantidad;
                totalCliente += importe;

                System.out.println("Importe: $" + importe);
                System.out.print("¿Desea agregar otro producto? (s/n): ");
                respuesta = sc.next();
            } while (respuesta.equalsIgnoreCase("s"));

            sc.nextLine();
            totalRecaudado += totalCliente;
            System.out.println("Total de compra de " + nombre + ": $" + totalCliente);
        }

        System.out.println("\n=======================================================");
        System.out.println("TABLA DE PRODUCTOS VENDIDOS");
        System.out.println("=======================================================");
        System.out.println("Producto\tPrecio\tCantidad\tImporte Bruto");
        for (int i = 0; i < productos.length; i++) {
            System.out.println(productos[i] + "\t$" + precios[i] + "\t" + ventas[i] + "\t\t$" + (ventas[i] * precios[i]));
        }

        System.out.println("\n=======================================================");
        System.out.println("REPORTE FINAL");
        System.out.println("=======================================================");
        System.out.println("Cantidad total de clientes atendidos: " + clientes.size());
        System.out.println("Lista de nombres de los clientes:");
        for (String c : clientes) System.out.println("- " + c);

        System.out.println("Cantidad total vendida de cada tipo de producto:");
        for (int i = 0; i < productos.length; i++) {
            System.out.println("- " + productos[i] + ": " + ventas[i] + " unidades");
        }

        System.out.println("Total de dinero recaudado después de descuentos: $" + totalRecaudado);
        System.out.println("Promedio de venta por cliente: $" + (clientes.isEmpty() ? 0 : totalRecaudado / clientes.size()));

        sc.close();
    }
}

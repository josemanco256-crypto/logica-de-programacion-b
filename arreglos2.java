import java.util.ArrayList;
import java.util.Scanner;

public class arreglos2 {
    public static void main(String[] args) {
        ArrayList<Integer> numeros = new ArrayList<>();
        Scanner consola = new Scanner(System.in);

        for (int i = 0; i < 10; i++) {
            System.out.println("Ingresa un número entero:");
            int numero = consola.nextInt();
            numeros.add(numero);
        }

        int mayor = numeros.get(0);
        int menor = numeros.get(0);
        int posicionMayor = 0;
        int posicionMenor = 0;

        for (int i = 0; i < numeros.size(); i++) {
            if (numeros.get(i) > mayor) {
                mayor = numeros.get(i);
                posicionMayor = i;
            }
            if (numeros.get(i) < menor) {
                menor = numeros.get(i);
                posicionMenor = i;
            }
        }

        consola.close();

        System.out.println("El número mayor es: " + mayor + " esta en: " + posicionMayor);
        System.out.println("El numero menor es: " + menor + " esta en: " + posicionMenor);
    }
}
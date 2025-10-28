package bygjos.apps;
import java.util.Scanner;

import bygjos.essential.BygjOS_principalOS;

public class Calculadora {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\nCalculadora Simple");
            System.out.println("1. Sumar");
            System.out.println("2. Restar");
            System.out.println("3. Multiplicar");
            System.out.println("4. Dividir");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            
            int opcion = scanner.nextInt();
            if (opcion == 5) {
                System.out.println("Saliendo...");
                BygjOS_principalOS BygjOS = new BygjOS_principalOS();
            	BygjOS.menu(args);
                break;
            }
            
            System.out.print("Ingrese el primer número: ");
            double num1 = scanner.nextDouble();
            System.out.print("Ingrese el segundo número: ");
            double num2 = scanner.nextDouble();
            
            switch (opcion) {
                case 1:
                    System.out.println("Resultado: " + (num1 + num2));
                    break;
                case 2:
                    System.out.println("Resultado: " + (num1 - num2));
                    break;
                case 3:
                    System.out.println("Resultado: " + (num1 * num2));
                    break;
                case 4:
                    if (num2 != 0) {
                        System.out.println("Resultado: " + (num1 / num2));
                    } else {
                        System.out.println("Error: No se puede dividir por cero.");
                    }
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
        
        scanner.close();
    }
}

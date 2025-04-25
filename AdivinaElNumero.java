package bygj_OS_isoBooting_Project;
import java.util.Random;
import java.util.Scanner;

public class AdivinaElNumero {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int numeroSecreto = random.nextInt(100) + 1;
        int intentos = 0;
        int numeroUsuario;
        
        System.out.println("¡Bienvenido a Adivina el Número!");
        System.out.println("Estoy pensando en un número entre 1 y 100. ¿Puedes adivinar cuál es?");
        
        while (true) {
            System.out.print("Introduce tu número: ");
            numeroUsuario = scanner.nextInt();
            intentos++;
            
            if (numeroUsuario == numeroSecreto) {
                System.out.println("¡Felicidades! Adivinaste el número en " + intentos + " intentos.");
                break;
            } else if (numeroUsuario < numeroSecreto) {
                System.out.println("El número es mayor. Inténtalo de nuevo.");
            } else {
                System.out.println("El número es menor. Inténtalo de nuevo.");
            }
        }
        
        scanner.close();
    }
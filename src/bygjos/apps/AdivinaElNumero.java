package bygjos.apps;
import java.util.Random;
import bygjos.essential.BygjOS_principalOS;
import java.util.Scanner;

public class AdivinaElNumero {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int numeroSecreto = random.nextInt(100) + 1;
        int intentos = 0;
        int numeroUsuario;
        
        System.out.println("¡Bienvenido a Adivina el Número!");
        System.out.println("Estoy pensando en un número entre 1 y 100. ¿Puedes adivinar cuál es?  Para salir pon 666 (es imposible que la maquina coja ese numero)");
        
        while (true) {
            System.out.print("Introduce tu número: ");
            numeroUsuario = scanner.nextInt();
            intentos++;
            
            if (numeroUsuario == numeroSecreto) {
                System.out.println("¡Felicidades! Adivinaste el número en " + intentos + " intentos. Para salir pon 666 (es imposible que la maquina coja ese numero)");
                break;
            } else if (numeroUsuario < numeroSecreto) {
                System.out.println("El número es mayor. Inténtalo de nuevo.");
            } else if (numeroUsuario == 666) {
            	BygjOS_principalOS BygjOS = new BygjOS_principalOS();
            	BygjOS.menu(args);
           
        } else {
            System.out.println("El número es menor. Inténtalo de nuevo.");
        }
        
        }
    }
}
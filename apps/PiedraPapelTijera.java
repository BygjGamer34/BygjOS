package pkg;
import java.util.Random;
import java.util.Scanner;

public class PiedraPapelTijera {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        String[] opciones = {"Piedra", "Papel", "Tijera"};
        
        while (true) {
            System.out.println("\nJuego: Piedra, Papel o Tijera");
            System.out.println("1. Piedra");
            System.out.println("2. Papel");
            System.out.println("3. Tijera");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            
            int eleccionUsuario = scanner.nextInt();
            if (eleccionUsuario == 4) {
                System.out.println("Saliendo del juego...");
                break;
            }
            
            if (eleccionUsuario < 1 || eleccionUsuario > 3) {
                System.out.println("Opción no válida, intente de nuevo.");
                continue;
            }
            
            int eleccionMaquina = random.nextInt(3) + 1;
            
            System.out.println("Tú elegiste: " + opciones[eleccionUsuario - 1]);
            System.out.println("La máquina eligió: " + opciones[eleccionMaquina - 1]);
            
            if (eleccionUsuario == eleccionMaquina) {
                System.out.println("Empate!");
            } else if ((eleccionUsuario == 1 && eleccionMaquina == 3) ||
                       (eleccionUsuario == 2 && eleccionMaquina == 1) ||
                       (eleccionUsuario == 3 && eleccionMaquina == 2)) {
                System.out.println("¡Ganaste!");
            } else {
                System.out.println("Perdiste...");
            }
        }
        
        scanner.close();
    }
}

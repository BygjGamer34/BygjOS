package bygjos.essential;

import java.util.Scanner;

public class BootLoader {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        mostrarMenu();
    }

    private static void mostrarMenu() {
        System.out.println("==================================");
        System.out.println("        Bienvenido a BygjOS       ");
        System.out.println("==================================");
        System.out.println("Presiona R para abrir el programa de recuperación.");
        System.out.println("Presiona S para iniciar el sistema operativo.");
        System.out.println("==================================");
        System.out.print("Tu opción: ");

        String eleccion = scanner.nextLine().trim().toLowerCase();

        switch (eleccion) {
            case "r":
                abrirRecuperacion();
                break;
            case "s":
                iniciarSistema();
                break;
            default:
                System.out.println("Opción no válida. Intenta de nuevo.");
                mostrarMenu();
        }
    }

    private static void abrirRecuperacion() {
        System.out.println("Abriendo programa de recuperación...");
        // Llama a tu clase de recuperación o instalador
        try {
            BygjOS_Installer_Recup.main(new String[]{});
        } catch (Throwable e) {
            System.out.println("Error al iniciar la recuperación: " + e.getMessage());
        }
    }

    private static void iniciarSistema() {
        System.out.println("Iniciando BygjOS...");
        // Llama al sistema operativo principal
        try {
            BygjOS_principalOS.main(new String[]{});
        } catch (Throwable e) {
            System.out.println("Error al iniciar el sistema: " + e.getMessage());
        }
    }
}

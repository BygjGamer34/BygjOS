package bygjos.essential;

import java.util.Scanner;
import java.io.*;
import bygjos.apps.*;
public class BygjOS_principalOS {
    static File usuario = new File("user.bygj");
    static File pass = new File("pass.bygj");
    static String[] apps = {"Archivos", "Calculadora", "Piedra, Papel o Tijera", "Adivina El Número"};  
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Throwable {
    	if (!usuario.exists()) {
            mostrarCargando();
        } else {
            os(args);
        }
    }
    private static void os(String[] args) throws InterruptedException, Throwable {
        System.out.println("                                                                                                                                 Bygj                                    ");
        System.out.println("                                                                                                                               Cargando                                  ");
        System.out.println("                                                                                                                   -----------------------------                        ");
        System.out.println("                                                                                                                Asegúrate de tener pantalla completa                    ");
        Thread.sleep(10000);
        

        if (usuario.length() == 0 || pass.length() == 0) {
            Scanner setup = new Scanner(System.in);
            System.out.println("──────────────────────────────");
            System.out.println("Configuración inicial de BygjOS");
            System.out.println("──────────────────────────────");
            System.out.print("🧑 Escribe tu nombre de usuario: ");
            String nuevoUsuario = setup.nextLine();
            System.out.print("🔒 Escribe tu contraseña: ");
            String nuevaPass = setup.nextLine();

            try (FileWriter fwU = new FileWriter(usuario);
                 FileWriter fwP = new FileWriter(pass)) {
                fwU.write(nuevoUsuario);
                fwP.write(nuevaPass);
            }

            System.out.println("✅ Configuración completada. Reinicia BygjOS para continuar.");
            System.exit(0);
        }
        // Lectura segura de usuario y contraseña
        String[] datos = new String[2];

        try (Scanner scanF = new Scanner(usuario)) {
            if (scanF.hasNextLine()) {
                datos[0] = scanF.nextLine();
            } else {
                System.out.println("Error: Archivo de usuario vacío.");
                return;
            }
        }

        try (Scanner scanF = new Scanner(pass)) {
            if (scanF.hasNextLine()) {
                datos[1] = scanF.nextLine();
            } else {
                System.out.println("Error: Archivo de contraseña vacío.");
                return;
            }
        }

        System.out.print("Usuario: ");
        String usuarioIngresado = scanner.nextLine();

        System.out.print("Contraseña: ");
        String claveIngresada = scanner.nextLine();

        if (!usuarioIngresado.equals(datos[0]) || !claveIngresada.equals(datos[1])) {
            System.out.println("Incorrecto.");
            System.exit(0);
        }

        System.out.println("Bienvenido a BygjOS Eclipse");
        System.out.println("Apps");
        System.out.println("1) " + apps[0] + " 2) " + apps[1] + " 3) " + apps[2] + " 4) " + apps[3]);
        System.out.println("5) Salir");

        if (scanner.hasNextInt()) {
            int eleccion = scanner.nextInt();
            scanner.nextLine(); // Limpieza de buffer
            switch (eleccion) {
                case 1:
                    ExploradorArchivos.main(args);
                    break;
                case 2:
                    Calculadora.main(args);
                    break;
                case 3:
                    PiedraPapelTijera.main(args);
                    break;
                case 4:
                    AdivinaElNumero.main(args);
                    break;
                case 5:
                    BygjOS_Installer_Recup.eraseScreen();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } else {
            System.out.println("Error: Entrada inválida.");
        }
    }

    private static void mostrarCargando() {
        System.out.println("                        ____________________________");
        System.out.println("                        | -                        |");
        System.out.println("                        |   -                      |");
        System.out.println("                        |     -                    |");
        System.out.println("                        |       -                  |");
        System.out.println("                        |         -                |");
        System.out.println("                        |           -              |");
        System.out.println("                        |             -            |");
        System.out.println("                        |               -          |");
        System.out.println("                        |                 -        |");
        System.out.println("                        |                   -      |");
        System.out.println("                        |                     -    |");
        System.out.println("                        |                       -  |");
        System.out.println("                        |                        - |");
        System.out.println("                        |_________________________-|");
        System.out.println("                                 README.md");
    }
}

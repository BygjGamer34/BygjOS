package bygj_OS_isoBooting_Project;
import java.util.Scanner;
import java.io.*;
public class BygjOS_principalOS {
static File usuario = new File("user.bygj");
static File pass = new File("pass.bygj");
static String[] apps = {"Archivos", "Calculadora", "Piedra, Papel o Tijera", "Adivina El Número"};  
static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner scanArranque = new Scanner(System.in);
		String arranque = scanArranque.next();
		scanArranque.close();
		switch (arranque) {
		case "s" :
			if (!usuario.exists()) {
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
			} else {
			os(args);
			}
			break;
		case "r" :
			BygjOS_Installer_Recup.main(args);
			break;
		}
	}
	private static void os(String[] args) throws InterruptedException, FileNotFoundException {
        // Ruta del archivo
		System.out.println("                                                                                                                                 Bygj                                    ");
        System.out.println("                                                                                                                               Cargando                                  ");
        System.out.println("                                                                                                                   -----------------------------                        ");
        System.out.println("                                                                                                                Asegúrate de tener pantalla completa                    ");
        Thread.sleep(10000);
        File arranque = new File("arr.bygj");
        if (arranque.exists()) {
        	PrintStream writeData = new PrintStream(usuario);
        	boolean del = arranque.delete();
        	System.out.println("Configuración de sistema");
        	Thread.sleep(1000);
        	System.out.println("Usuario");
        	String usuarioConfig = scanner.nextLine();
        	writeData.println(usuarioConfig);
        	writeData = new PrintStream(pass);
        	System.out.println("Contraseña: ");
        	String passConfig = scanner.nextLine();
        	writeData.println(passConfig);
        	System.out.println("Configuración terminada");
        }
        Scanner scanF = new Scanner(usuario);
        String[] datos = null;
        datos[0] = scanF.nextLine();
        scanF = new Scanner(pass);
        datos[1] = scanF.nextLine();
        System.out.println("Usuario");
        String usuario = scanner.nextLine();
        System.out.println("Contraseña");
        String clave = scanner.nextLine();
        if (!usuario.equals(datos[0]) || !clave.equals(datos[1])) {
        	System.out.println("Incorrecto.");
        	System.exit(0);
        }
        System.out.println("Bienvenido a BygjOS Eclipse");
        System.out.println("Apps");
        System.out.println("1)" + apps[0] + " 2)" + apps[1] + " 3)" + apps[2] + " 4)" + apps[3]);
        System.out.println("5)Salir");
        int eleccion = scanner.nextInt();
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
        }
	}
	
}



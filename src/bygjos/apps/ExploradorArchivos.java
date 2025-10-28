package bygjos.apps;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;
import bygjos.essential.*;

public class ExploradorArchivos {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String rutaDirectorio = System.getProperty("user.dir");

        while (true) {
            File carpeta = new File(rutaDirectorio);
            File[] archivos = carpeta.listFiles();

            System.out.println("\nContenido de " + rutaDirectorio + ":");
            if (archivos != null && archivos.length > 0) {
                for (int i = 0; i < archivos.length; i++) {
                    System.out.println((i + 1) + ". " + archivos[i].getName() + (archivos[i].isDirectory() ? " (Directorio)" : " (Archivo)"));
                }
            } else {
                System.out.println("La carpeta está vacía o no se puede acceder.");
            }

            System.out.println("\nOpciones:");
            System.out.println("1. Abrir un archivo de texto (.txt)");
            System.out.println("2. Crear un nuevo directorio");
            System.out.println("3. Crear un archivo de texto");
            System.out.println("4. Eliminar un directorio o archivo");
            System.out.println("5. Entrar a un directorio");
            System.out.println("6. Volver al directorio padre");
            System.out.println("7. Ejecutar JAR");
            System.out.println("8. Salir");

            System.out.print("Seleccione una opción (1-8): ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    abrirArchivoMenu(scanner, archivos);
                    break;
                case 2:
                    crearDirectorio(scanner, rutaDirectorio);
                    break;
                case 3:
                    crearArchivo(scanner, rutaDirectorio);
                    break;
                case 4:
                    eliminarElementoMenu(scanner, archivos);
                    break;
                case 5:
                    rutaDirectorio = entrarDirectorio(scanner, archivos, rutaDirectorio);
                    break;
                case 6:
                    rutaDirectorio = volverDirectorioPadre(rutaDirectorio);
                    break;
                case 7:
                    System.out.print("Ingrese el número del archivo JAR que desea ejecutar: ");
                    int numeroJar = scanner.nextInt();
                    scanner.nextLine(); // limpiar buffer
                    if (numeroJar >= 1 && numeroJar <= archivos.length) {
                        File archivoJar = archivos[numeroJar - 1];
                        if (archivoJar.isFile() && archivoJar.getName().endsWith(".jar")) {
                            try {
                                ProcessBuilder pb = new ProcessBuilder("java", "-jar", archivoJar.getAbsolutePath());
                                pb.inheritIO(); // para que la salida del JAR aparezca en la consola
                                Process proceso = pb.start();
                                proceso.waitFor(); // esperar a que termine
                            } catch (IOException | InterruptedException e) {
                                System.out.println("Error al ejecutar el JAR: " + e.getMessage());
                            }
                        } else {
                            System.out.println("El archivo seleccionado no es un JAR.");
                        }
                    } else {
                        System.out.println("Número de archivo inválido.");
                    }
                    break;

                case 8:
                	System.out.println("Saliendo...");
                    BygjOS_principalOS BygjOS = new BygjOS_principalOS();
                    scanner.nextLine(); // limpia el buffer del Scanner
                	BygjOS.menu(args);
                	return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    private static void abrirArchivoMenu(Scanner scanner, File[] archivos) {
        System.out.print("Ingrese el número del archivo .txt que desea abrir: ");
        int numeroArchivo = scanner.nextInt();
        scanner.nextLine();
        if (numeroArchivo >= 1 && numeroArchivo <= archivos.length && archivos[numeroArchivo - 1].isFile()) {
            File archivo = archivos[numeroArchivo - 1];
            if (archivo.getName().endsWith(".txt")) {
                abrirArchivo(archivo, scanner);
            } else {
                System.out.println("Este archivo no es un archivo de texto.");
            }
        } else {
            System.out.println("Número de archivo inválido.");
        }
    }

    private static void abrirArchivo(File archivo, Scanner sc) {
        try {
            if (archivo.exists()) {
                System.out.println("\nContenido del archivo " + archivo.getName() + ":");
                String contenido = new String(Files.readAllBytes(archivo.toPath()));
                System.out.println("------------------------------------------------");
                System.out.println(contenido);
                System.out.println("------------------------------------------------");
            } else {
                System.out.println("El archivo no existe. Se creará uno nuevo.");
            }

            System.out.println("\n¿Deseas sobrescribir el contenido del archivo? (s/n): ");
            String respuesta = sc.nextLine().trim().toLowerCase();

            if (respuesta.equals("s")) {
                System.out.println("Escribe el nuevo contenido. Termina con una línea que contenga solo 'FIN':");
                StringBuilder nuevoContenido = new StringBuilder();
                while (true) {
                    String linea = sc.nextLine();
                    if (linea.equals("FIN")) break;
                    nuevoContenido.append(linea).append(System.lineSeparator());
                }

                Files.write(archivo.toPath(), nuevoContenido.toString().getBytes(),
                        StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
                System.out.println("Archivo actualizado correctamente.");
            } else {
                System.out.println("No se ha modificado el archivo.");
            }
        } catch (IOException e) {
            System.out.println("Error al manejar el archivo: " + e.getMessage());
        }
    }

    private static void crearDirectorio(Scanner scanner, String rutaDirectorio) {
        System.out.print("Ingrese el nombre del nuevo directorio: ");
        String nombreDirectorio = scanner.nextLine();
        File nuevoDirectorio = new File(rutaDirectorio + File.separator + nombreDirectorio);
        if (nuevoDirectorio.mkdir()) {
            System.out.println("Directorio creado con éxito.");
        } else {
            System.out.println("No se pudo crear el directorio.");
        }
    }

    private static void crearArchivo(Scanner scanner, String rutaDirectorio) {
        System.out.print("Ingrese el nombre del nuevo archivo de texto (con extensión .txt): ");
        String nombreArchivo = scanner.nextLine();
        File archivoNuevo = new File(rutaDirectorio + File.separator + nombreArchivo);
        try {
            if (archivoNuevo.createNewFile()) {
                System.out.println("Archivo creado con éxito.");
                System.out.println("Escribe el contenido del archivo. Termina con una línea que contenga solo 'FIN':");
                StringBuilder contenido = new StringBuilder();
                while (true) {
                    String linea = scanner.nextLine();
                    if (linea.equals("FIN")) break;
                    contenido.append(linea).append(System.lineSeparator());
                }
                try (FileWriter writer = new FileWriter(archivoNuevo)) {
                    writer.write(contenido.toString());
                }
                System.out.println("Contenido guardado en el archivo.");
            } else {
                System.out.println("El archivo ya existe.");
            }
        } catch (IOException e) {
            System.out.println("Error al crear el archivo: " + e.getMessage());
        }
    }

    private static void eliminarElementoMenu(Scanner scanner, File[] archivos) {
        System.out.print("Ingrese el número del directorio o archivo que desea eliminar: ");
        int numeroEliminar = scanner.nextInt();
        scanner.nextLine();
        if (numeroEliminar >= 1 && numeroEliminar <= archivos.length) {
            File itemEliminar = archivos[numeroEliminar - 1];
            if (eliminarElemento(itemEliminar)) {
                System.out.println("Elemento eliminado correctamente.");
            } else {
                System.out.println("No se pudo eliminar el elemento. Asegúrese de que no está en uso.");
            }
        } else {
            System.out.println("Número inválido.");
        }
    }

    private static boolean eliminarElemento(File elemento) {
        if (elemento.isDirectory()) {
            File[] archivos = elemento.listFiles();
            if (archivos != null) {
                for (File archivo : archivos) {
                    eliminarElemento(archivo);
                }
            }
        }
        return elemento.delete();
    }

    private static String entrarDirectorio(Scanner scanner, File[] archivos, String rutaActual) {
        System.out.print("Ingrese el número del directorio al que desea entrar: ");
        int numero = scanner.nextInt();
        scanner.nextLine();
        if (numero >= 1 && numero <= archivos.length && archivos[numero - 1].isDirectory()) {
            return archivos[numero - 1].getAbsolutePath();
        } else {
            System.out.println("Número de directorio inválido.");
            return rutaActual;
        }
    }

    private static String volverDirectorioPadre(String rutaActual) {
        File carpeta = new File(rutaActual);
        File padre = carpeta.getParentFile();
        if (padre != null) {
            return padre.getAbsolutePath();
        } else {
            System.out.println("Ya estás en la raíz, no se puede subir más.");
            return rutaActual;
        }
    }
}

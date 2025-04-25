package bygj_OS_isoBooting_Project;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ExploradorArchivos {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String rutaDirectorio = "./C";

        while (true) {
            File carpeta = new File(rutaDirectorio);
            File[] archivos = carpeta.listFiles();

            System.out.println("Contenido de " + rutaDirectorio + ":");
            if (archivos != null) {
                for (int i = 0; i < archivos.length; i++) {
                    System.out.println(i + 1 + ". " + archivos[i].getName() + (archivos[i].isDirectory() ? " (Directorio)" : " (Archivo)"));
                }
            } else {
                System.out.println("No se puede acceder a la carpeta.");
            }

            System.out.println("\nOpciones:");
            System.out.println("1. Abrir un archivo de texto (.txt)");
            System.out.println("2. Crear un nuevo directorio");
            System.out.println("3. Crear un archivo de texto");
            System.out.println("4. Eliminar un directorio o archivo");
            System.out.println("5. Salir");
            
            System.out.print("Seleccione una opción (1/2/3/4/5): ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el número del archivo .txt que desea abrir: ");
                    int numeroArchivo = scanner.nextInt();
                    scanner.nextLine();
                    if (numeroArchivo >= 1 && numeroArchivo <= archivos.length && archivos[numeroArchivo - 1].isFile()) {
                        File archivo = archivos[numeroArchivo - 1];
                        if (archivo.getName().endsWith(".txt")) {
                            abrirArchivo(archivo);
                        } else {
                            System.out.println("Este archivo no es un archivo de texto.");
                        }
                    } else {
                        System.out.println("Número de archivo inválido.");
                    }
                    break;
                case 2:
                    System.out.print("Ingrese el nombre del nuevo directorio: ");
                    String nombreDirectorio = scanner.nextLine();
                    File nuevoDirectorio = new File(rutaDirectorio + "\\" + nombreDirectorio);
                    if (nuevoDirectorio.mkdir()) {
                        System.out.println("Directorio creado con éxito.");
                    } else {
                        System.out.println("No se pudo crear el directorio.");
                    }
                    break;
                case 3:
                    System.out.print("Ingrese el nombre del nuevo archivo de texto (con extensión .txt): ");
                    String nombreArchivo = scanner.nextLine();
                    File archivoNuevo = new File(rutaDirectorio + "\\" + nombreArchivo);
                    try {
                        if (archivoNuevo.createNewFile()) {
                            System.out.println("Archivo creado con éxito.");
                            System.out.print("Ingrese el contenido del archivo: ");
                            String contenido = scanner.nextLine();
                            try (FileWriter writer = new FileWriter(archivoNuevo)) {
                                writer.write(contenido);
                                System.out.println("Contenido guardado en el archivo.");
                            }
                        } else {
                            System.out.println("El archivo ya existe.");
                        }
                    } catch (IOException e) {
                        System.out.println("Error al crear el archivo: " + e.getMessage());
                    }
                    break;
                case 4:
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
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    private static void abrirArchivo(File archivo) {
        try {
            ProcessBuilder pb = new ProcessBuilder("notepad.exe", archivo.getAbsolutePath());
            pb.start();
        } catch (IOException e) {
            System.out.println("Error al abrir el archivo: " + e.getMessage());
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
}

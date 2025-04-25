package bygj_OS_isoBooting_Project;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class BygjOS_Installer_Recup {
	public static String terms = """
			Términos y Condiciones de BygjOS 1.0

			1. Aceptación de los Términos
			Al adquirir una licencia para BygjOS 1.0, el comprador acepta los términos y condiciones de uso establecidos en este documento. Si no está de acuerdo con los términos aquí descritos, no podrá hacer uso del producto.

			2. Descripción del Producto
			BygjOS 1.0 es un sistema operativo desarrollado por Bygj. La licencia proporcionada es válida únicamente para una instalación en un dispositivo compatible y no puede ser utilizada en más de un dispositivo simultáneamente.

			3. Proceso de Compra y Distribución
			Las licencias se venden en reuniones familiares, y cada clave vendrá con un enlace de descarga único. Dicho enlace proporcionará acceso a una imagen de disco (.iso) que contiene los archivos necesarios para instalar BygjOS 1.0. La descarga está disponible solo a través de los enlaces distribuidos.

			4. Pago
			El costo de cada licencia es de 1€. El pago debe ser realizado en efectivo en las reuniones familiares o mediante acuerdos privados. No se ofrece ningún reembolso una vez realizada la compra, salvo que se especifique lo contrario.

			5. Licencia de Uso
			El comprador recibe una licencia no exclusiva para usar BygjOS 1.0 en un solo dispositivo. No se permite la redistribución, copia o modificación del sistema operativo sin el permiso explícito de Bygj.

			6. Responsabilidad
			Bygj no será responsable de ningún daño directo, indirecto, incidental o consecuente que resulte del uso o la imposibilidad de usar BygjOS 1.0. Al adquirir el producto, el comprador asume toda la responsabilidad del uso que haga del sistema operativo.

			7. Soporte Técnico
			El soporte técnico para BygjOS 1.0 es limitado. Si tienes algún problema con la instalación o el uso del sistema operativo, puedes contactar a atención al cliente a través de atencionalclienteBYGJOS@gmail.com.

			8. Actualizaciones
			Las actualizaciones de BygjOS 1.0 podrán ser proporcionadas en el futuro bajo los términos que se establezcan en su momento. Las actualizaciones no están garantizadas.

			9. Modificaciones de los Términos
			Bygj se reserva el derecho de modificar estos Términos y Condiciones en cualquier momento, sin previo aviso. Cualquier modificación será válida a partir de su publicación.

			10. Aceptación de los Términos
			Al realizar la instalación de BygjOS, el usuario reconoce haber leído, comprendido y aceptado estos Términos y Condiciones.

			¡Gracias por confiar en BygjOS 1.0!
			Recuerda que las licencias están disponibles solo en nuestras reuniones familiares o por privado con Bygj. Si tienes alguna duda, no dudes en contactarnos.


					""";
				public static void main(String[] args) throws Exception {
					// TODO Auto-generated method stub
					Scanner scanCosas = new Scanner(System.in);
					loading(); 
					    int cosita = scanCosas.nextInt();
					    if (cosita == 1) {
					    	installer();
					    } else if (cosita == 2) {
					    	eraseScreen();
					    } else if (cosita == 3) {
					    	System.exit(0);
					    } else {
					    	System.exit(0);
					    }
					    
				}
				
				public static void installer() throws Exception {
				    System.out.println("Programa de instalacion de BygjOS Eclipse 1.0");
				    Thread.sleep(3000);
				    System.out.println("Términos y condiciones:");
				    System.out.println(terms);
				    System.out.println("1)Acepto 2)No acepto");
				    Scanner scanner = new Scanner(System.in);
				    int num1 = scanner.nextInt();
				    scanner.nextLine();  // Consumir el salto de línea pendiente
				    if (!(num1 == 1)) {
				        eraseScreen();
				        System.exit(0);
				    }

				    System.out.println("Instalando...");
				    FileWriter usuario = new FileWriter("user.bygj");
				    usuario.close();
				    FileWriter pass = new FileWriter("pass.bygj");
				    pass.close();
				    FileWriter arr = new FileWriter("arr.bygj");
				    arr.close();
				    Thread.sleep(1000);
				    System.out.println("Instalado, arranca on el OS normal (véase README.md) para configurar");
				}

				public static void eraseScreen() {
					// TODO Auto-generated method stub
					for (int i = 0; i < 300; i++) {
						System.out.println(System.lineSeparator());
					}
				}

				private static void loading() throws Exception {
					// TODO Auto-generated method stub
					System.out.println("                                                                          ");
			        System.out.println("                                                                          ");
			        System.out.println("                                                                                                                                 Bygj                                    ");
			        System.out.println("                                                                                                                               Cargando                                  ");
			        System.out.println("                                                                                                                   -----------------------------                        ");
			        System.out.println("                                                                                                                Asegúrate de tener pantalla completa                    ");
			        Thread.sleep(10000);
			        eraseScreen();
			        System.out.println("                                                                          __________________________________________________________________________");
			        System.out.println("                                                                          |                  Instalación/recuperación de BygjOS 1.0                 |");
			        System.out.println("                                                                          |_________________________________________________________________________|");
			        System.out.println("                                                                          |                                                                         |");
			        System.out.println("                                                                          |  ┌───────────────────────────────────────────────────────────────┐      |");
			        System.out.println("                                                                          |  |  1. Reinstalar BygjOS Eclipse 1.0                             |      |");
			        System.out.println("                                                                          |  └───────────────────────────────────────────────────────────────┘      |");
			        System.out.println("                                                                          |                                                                         |");
			        System.out.println("                                                                          |  ┌───────────────────────────────────────────────────────────────┐      |");
			        System.out.println("                                                                          |  |  2. Salir                                                     |      |");
			        System.out.println("                                                                          |  └───────────────────────────────────────────────────────────────┘      |");
			        System.out.println("                                                                          |_________________________________________________________________________|");



				}

}

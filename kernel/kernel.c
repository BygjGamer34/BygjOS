// kernel/kernel.c - Kernel mínimo que lanza BootLoader.class
#include <stdlib.h>

void kmain() {
    // Mostrar mensaje inicial
    system("echo Kernel cargado, lanzando Java...");

    // Ejecutar tu clase BootLoader.class
    // Se asume que estás en build/, por eso la ruta empieza desde bygjos/
    system("jdk/bin/java -cp bygjos essential.BootLoader");

    // Bucle infinito para que el kernel no termine
    while(1);
}

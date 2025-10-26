; boot/boot.asm - Bootloader mínimo que carga kernel.bin
[org 0x7C00]

start:
    cli                 ; Desactiva interrupciones
    xor ax, ax
    mov ds, ax
    mov es, ax

    ; Mostrar mensaje inicial
    mov si, msg
print_char:
    lodsb
    cmp al, 0
    je load_kernel
    mov ah, 0x0E
    int 0x10
    jmp print_char

; ---------------------------------------------------
; Cargar kernel.bin (asumimos 1 sector = 512 bytes por simplicidad)
load_kernel:
    mov bx, 0x1000      ; Dirección donde cargaremos el kernel (0x1000 = 4KB)
    mov dh, 1           ; Número de sectores a leer (puedes aumentar según tamaño)
    mov dl, 0           ; Unidad de disco (0 = primer floppy o disco duro)
    mov ch, 0           ; Cilindro
    mov cl, 2           ; Sector (empezamos en 2, sector 1 es bootloader)
    mov ah, 0x02        ; Función BIOS: leer sectores
    int 0x13            ; Llamada BIOS
    jc disk_error       ; Si hay error, saltar a mensaje

    ; Saltar al kernel
    jmp 0x0000:0x1000

disk_error:
    mov si, err_msg
err_loop:
    lodsb
    cmp al, 0
    je $
    mov ah, 0x0E
    int 0x10
    jmp err_loop

msg db "BygjOS booting...",0
err_msg db "Error leyendo kernel!",0

; Rellenar hasta 512 bytes y firma
times 510-($-$$) db 0
dw 0xAA55

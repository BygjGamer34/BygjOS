; boot/boot.asm - Bootloader mínimo para BygjOS
[org 0x7C00]          ; Dirección donde la BIOS carga el bootloader

start:
    cli                ; Desactiva interrupciones
    xor ax, ax
    mov ds, ax
    mov es, ax

    ; Mensaje a mostrar
    mov si, msg

print_char:
    lodsb              ; Carga un byte de [si] en AL y avanza SI
    cmp al, 0
    je halt
    mov ah, 0x0E       ; Función BIOS teletipo
    int 0x10           ; Llama a la BIOS para imprimir
    jmp print_char

halt:
    hlt                ; Detiene la CPU
    jmp halt           ; Bucle infinito

msg db "BygjOS booting...", 0

; Rellenar hasta 512 bytes con ceros y poner la firma 0xAA55
times 510-($-$$) db 0
dw 0xAA55


package examenprog3trimestre;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ExamenProg3Trimestre {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        Menu miMenu = new Menu();

        String rutasFile = "rutas.txt";
        String userFile = "";
        String sistemaFile = "";

        try (BufferedReader reader = new BufferedReader(new FileReader(rutasFile))) {
            userFile = reader.readLine();
            sistemaFile = reader.readLine();
        } catch (IOException e) {
            System.out.println("Error leyendo el archivo rutas.txt: " + e.getMessage());
            return;
        }

        File sistemaDat = new File(sistemaFile);
        Sistema sistema;

        if (!sistemaDat.exists()) {
            System.out.println("Creando el sistema por primera vez...");
            sistema = new Sistema();
            sistema.guardarSistema(sistemaFile, sistema);
        } else {
            System.out.print("Introduce el nombre de usuario: ");
            String username = scanner.nextLine();
            System.out.print("Introduce la contraseña: ");
            String password = scanner.nextLine();

            if (!miMenu.validarUsuario(userFile, username, password)) {
                System.out.println("Nombre de usuario o contraseña incorrectos.");
                return;
            }

            sistema = Sistema.cargarSistema(sistemaFile);
            if (sistema == null) {
                return;
            }
        }

        boolean salir = false;
        while (!salir) {
            System.out.println("Menú:");
            System.out.println("1- Ver servicios");
            System.out.println("2- Streamear servicio");
            System.out.println("3- Cerrar Streaming");
            System.out.println("4- Salir");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir nueva línea

            switch (opcion) {
                case 1:
                    sistema.verServicios();
                    break;
                case 2:
                    sistema.streamearServicio();
                    break;
                case 3:
                    sistema.cerrarStreaming();
                    break;
                case 4:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    }
    
}

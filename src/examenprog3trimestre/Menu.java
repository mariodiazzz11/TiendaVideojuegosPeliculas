package examenprog3trimestre;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Menu {
    
    private Scanner datos = new Scanner(System.in);

    public boolean validarUsuario(String archivoUsuarios, String nombre, String contraseña) {
        try {
            BufferedReader lector = new BufferedReader(new FileReader(archivoUsuarios));
            String linea;
            while ((linea = lector.readLine()) != null) {
                String nombreUsuario = linea;
                String contraseñaUsuario = lector.readLine();
                if (nombreUsuario.equals(nombre) && contraseñaUsuario.equals(contraseña)) {
                    return true;
                }
            }
        } catch (IOException e) {
            System.out.println("Error leyendo el archivo.");
        }
        return false;
    }
    
    public void menu(){
        System.out.println("Menu:");
        System.out.println("1- Ver servicios");
        System.out.println("2- Streamear servicio");
        System.out.println("3- Cerrar Streaming");
        System.out.println("4- Salir");  
    }
}

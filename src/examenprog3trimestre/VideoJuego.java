package examenprog3trimestre;

import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;

public class VideoJuego extends Servicio {
    
    private String compañia;
    private String dificultad;
    private String consola;

    public VideoJuego() {
        Scanner datos = new Scanner(System.in);
        boolean valido = false;
        System.out.print("Introduce la compañia: ");
        this.compañia = datos.nextLine();
        do {
            try {
                System.out.print("Introduce la dificultad (alta/media/baja): ");
                this.dificultad = datos.nextLine();
                if (this.dificultad.equalsIgnoreCase("baja") || this.dificultad.equalsIgnoreCase("media") || this.dificultad.equalsIgnoreCase("alta")) {
                    valido = true;
                } else {
                    System.out.print("Opción no válida.");
                }
            } catch (InputMismatchException e) {
                System.out.print("Entrada no válida.");
            }
        } while (!valido);
        System.out.print("Introduce la consola: ");
        this.consola = datos.nextLine();
    }

    @Override
    public String toString() {
        return "Nombre del videojuego: " + getNombre()
                + "\nAño de salida: " + getAñoSalida()
                + "\nPrecio: " + getPrecio()
                + "\nCompañia: " + this.compañia
                + "\nDificultad: " + this.dificultad
                + "\nConsola: " + this.consola;
    }

    public String getCompañia() {
        return compañia;
    }

    public String getDificultad() {
        return dificultad;
    }

    public String getConsola() {
        return consola;
    }

    public void setCompañia(String compañia) {
        this.compañia = compañia;
    }

    public void setDificultad(String dificultad) {
        this.dificultad = dificultad;
    }

    public void setConsola(String consola) {
        this.consola = consola;
    }

}

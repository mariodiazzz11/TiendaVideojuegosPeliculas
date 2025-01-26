package examenprog3trimestre;

import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class Servicio implements Serializable{

    private String nombre;
    private int añoSalida;
    private double precio;
    private boolean StreamingAbierto;
    private double anchoBanda;

    public Servicio() {
        Scanner datos = new Scanner(System.in);
        boolean valido = false;
        boolean valido2 = false;
        System.out.print("Introduce el nombre: ");
        this.nombre = datos.nextLine();
        do {
            try {
                System.out.print("Introduce el año de salida: ");
                this.añoSalida = datos.nextInt();
                if (añoSalida > 1950 && añoSalida < 2024) {
                    valido = true;
                } else {
                    System.out.println("Año no válido. Ha de estar entre 1950 y 2024.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada no válida.");
                datos.nextLine();
            }
        } while (!valido);
        do {
            try {
                System.out.print("Introduce el precio: ");
                this.precio = datos.nextDouble();
                if(this.precio > 0){
                    valido2 = true;
                }else{
                    System.out.println("Precio no valido.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada no válida.");
                datos.nextLine();
            }
        } while (!valido2);
        this.StreamingAbierto = false;
        this.anchoBanda = (int) (Math.random() * 100) + 1;
    }

    @Override
    public abstract String toString();

    public String getNombre() {
        return nombre;
    }

    public int getAñoSalida() {
        return añoSalida;
    }

    public double getPrecio() {
        return precio;
    }

    public boolean isStreamingAbierto() {
        return StreamingAbierto;
    }

    public double getAnchoBanda() {
        return anchoBanda;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setAñoSalida(int añoSalida) {
        this.añoSalida = añoSalida;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setStreamingAbierto(boolean StreamingAbierto) {
        this.StreamingAbierto = StreamingAbierto;
    }

    public void setAnchoBanda(double anchoBanda) {
        this.anchoBanda = anchoBanda;
    }

}

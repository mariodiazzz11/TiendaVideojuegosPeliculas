package examenprog3trimestre;

import java.io.Serializable;
import java.util.Scanner;

public class StreamingTv extends Servicio implements Serializable{
    
    private String director;
    private String pais;
    
    public StreamingTv(){
        Scanner datos = new Scanner(System.in);
        System.out.print("Introduce el director: ");
        this.director = datos.nextLine();
        System.out.print("Introduce el pais: ");
        this.pais = datos.nextLine();
    }
    
    @Override
    public String toString(){
        return "Nombre de la pelicula: " + getNombre()
                + "\nAño de salida: " + getAñoSalida()
                + "\nPrecio: " + getPrecio()
                + "\nDirector: " + this.director
                + "\nPais: " + this.pais;
    }

    public String getDirector() {
        return director;
    }

    public String getPais() {
        return pais;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
    
}

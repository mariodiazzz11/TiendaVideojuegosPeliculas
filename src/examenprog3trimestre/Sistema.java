package examenprog3trimestre;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Sistema implements Serializable {

    private ArrayList<Servicio> losServicios;
    private double anchoBandaUsuario;

    public Sistema() {
        losServicios = new ArrayList<>();
        try {
            System.out.println("Registra un videojuego ->");
            losServicios.add(new VideoJuego());
            System.out.println("-----------------------");
            System.out.println("Registra una peli ->");
            losServicios.add(new StreamingTv());
            System.out.println("-----------------------");
            System.out.println("Registra un videojuego ->");
            losServicios.add(new VideoJuego());
            System.out.println("-----------------------");
            System.out.println("Registra una peli ->");
            losServicios.add(new StreamingTv());
        } catch (Exception e) {
            System.out.println("Error al añadir los servicios.");
        }
        this.anchoBandaUsuario = 100;
    }

    public void verServicios() {
        for (Servicio servicio : losServicios) {
            System.out.println(servicio.toString());
            System.out.println();
        }
    }

    public void streamearServicio() {
        Scanner datos = new Scanner(System.in);
        System.out.print("Introduce el nombre del servicio a streamear: ");
        String nombreServicio = datos.nextLine();
        boolean servicioEncontrado = false;
        for (Servicio s : losServicios) {
            if (nombreServicio.equalsIgnoreCase(s.getNombre())) {
                servicioEncontrado = true;
                if (!s.isStreamingAbierto() && s.getAnchoBanda() <= this.anchoBandaUsuario) {
                    s.setStreamingAbierto(true);
                    this.anchoBandaUsuario = this.anchoBandaUsuario - s.getAnchoBanda();
                    System.out.println("Servicio " + s.getNombre() + " está ahora en streaming.");
                } else if(s.isStreamingAbierto()){
                    System.out.println("El servicio ya esta en streaming.");
                } else{
                    System.out.println("No se peude streamear el servicio. No queda ancho de banda");
                }
                break;
            }
        }
        if (!servicioEncontrado) {
            System.out.println("El nombre introducido no pertenece a ningun servicio.");
        }
    }

    public void cerrarStreaming() {
        Scanner datos = new Scanner(System.in);
        System.out.print("Introduce el nombre del servicio a liberar: ");
        String nombreServicio = datos.nextLine();
        boolean servicioEncontrado = false;
        for (Servicio s : losServicios) {
            if (nombreServicio.equalsIgnoreCase(s.getNombre())) {
                servicioEncontrado = true;
                if (s.isStreamingAbierto()) {
                    s.setStreamingAbierto(false);
                    this.anchoBandaUsuario = this.anchoBandaUsuario + s.getAnchoBanda();
                    System.out.println("Servicio " + s.getNombre() + " ha sido liberado.");
                } else {
                    System.out.println("El servicio ya está liberado.");
                }
                break;
            }
        }
        if (!servicioEncontrado) {
            System.out.println("El nombre introducido no pertenece a ningun servicio.");
        }
    }

    // Método para guardar los servicios en un archivo .dat
    public static void guardarSistema(String sistemaFile, Sistema sistema) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(sistemaFile))) {
            oos.writeObject(sistema);
            System.out.println("Servicio guardado correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para cargar los servicios desde un archivo .dat
    public static Sistema cargarSistema(String sistemaFile) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(sistemaFile))) {
            System.out.println("Servicio cargado correctamente.");
            return (Sistema) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

}

package es.upsa.papps.rutassenderismo;

public class Ruta
{
    private String id;
    private String nombre_ruta;
    private String explorador;//el que la incorpora al sistema
    private double valoracion;//valoracion de la ruta
    private double dificultad;//dificultad de la ruta


    public Ruta() {}

    public Ruta(String id, String nombre_ruta, String explorador, double valoracion, double dificultad) {
        this.id = id;
        this.nombre_ruta = nombre_ruta;
        this.explorador = explorador;
        this.valoracion = valoracion;
        this.dificultad = dificultad;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre_ruta() {
        return nombre_ruta;
    }

    public void setNombre_ruta(String nombre_ruta) {
        this.nombre_ruta = nombre_ruta;
    }

    public String getExplorador() {
        return explorador;
    }

    public void setExplorador(String explorador) {
        this.explorador = explorador;
    }

    public double getValoracion() {
        return valoracion;
    }

    public void setValoracion(double valoracion) {
        this.valoracion = valoracion;
    }

    public double getDificultad() {
        return dificultad;
    }

    public void setDificultad(double dificultad) {
        this.dificultad = dificultad;
    }
}

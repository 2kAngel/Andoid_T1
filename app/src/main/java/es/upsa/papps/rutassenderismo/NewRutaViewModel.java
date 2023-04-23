package es.upsa.papps.rutassenderismo;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

public class NewRutaViewModel extends AndroidViewModel
{
    private String nombreRuta;
    private String explorador;
    private float valoracion;
    private float dificultad;

    private Repository repository;

    public NewRutaViewModel(@NonNull Application application) {
        super(application);
        RutasApplication app = getApplication();
        this.repository = app.getRepository();
    }

    public String getNombreRuta() {
        return nombreRuta;
    }

    public String getExplorador() {
        return explorador;
    }

    public float getValoracion() {
        return Float.valueOf(valoracion/2).floatValue();
    }
    public float getDificultad() {return Float.valueOf(dificultad/2).floatValue();}

    public void setNombreRuta(String nombreRuta) {
        this.nombreRuta = nombreRuta;
    }

    public void setExplorador(String explorador) {
        this.explorador = explorador;
    }

    public void setValoracion(float valoracion) {
        this.valoracion = Float.valueOf(valoracion*2).floatValue();
    }


    public void setDificultad(float dificultad) {
        this.dificultad = Float.valueOf(dificultad).floatValue();
    }
    public Ruta crearRuta()
    {
        return repository.insertRuta(nombreRuta,explorador,valoracion,dificultad);
    }
}

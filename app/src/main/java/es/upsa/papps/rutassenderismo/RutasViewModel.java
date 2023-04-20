package es.upsa.papps.rutassenderismo;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

public class RutasViewModel extends AndroidViewModel
{
    private Repository repository;

    public RutasViewModel(@NonNull Application application) {
        super(application);
        RutasApplication app = getApplication();
        this.repository = app.getRepository();
    }

    public Ruta findRutaByid(String id)
    {
        return repository.findRutaById(id);
    }
}

package es.upsa.papps.rutassenderismo;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import java.util.List;

public class MainViewModel extends AndroidViewModel
{
    private Repository repository;

    public MainViewModel(@NonNull Application application)
    {
        super(application);
        RutasApplication app = getApplication();
        this.repository = app.getRepository();
    }

    public List<Ruta> getPeliculas()
    {
        return repository.getRutas();
    }
}

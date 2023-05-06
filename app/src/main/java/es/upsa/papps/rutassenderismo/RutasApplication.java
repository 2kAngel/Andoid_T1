package es.upsa.papps.rutassenderismo;

import android.app.Application;

public class RutasApplication extends Application
{
    private Repository repository;


    @Override
    public void onCreate() {




        super.onCreate();
        repository = new Repository();


    }



    public Repository getRepository() {
        return repository;
    }
}

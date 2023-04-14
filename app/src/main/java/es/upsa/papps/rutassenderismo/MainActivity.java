package es.upsa.papps.rutassenderismo;

import androidx.activity.result.contract.ActivityResultContract;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import es.upsa.papps.rutassenderismo.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

//Pasos Iniciar proyecto
    //0-> Mete las dependecias: projectStructure -> Dependecies -> app ->Library D -> andoindx.lifecycle/lifecycle-viewModel(2.5.1) || andoindx.lifecycle/lifecycle-viewModel-savedState(2.5.1)||androidx.activity/activity(1.6.1(la 1ª ni alfa ni beta))|| androidx.fragment/fragment(1.5.5(1ª ni alfa ni beta))
    //1-> Build Grandle(app) : debajo de compileOptions{} Add : viewBinding{ enabled true }
    //2-> En MainActivity: Creamos -> private ActivityMainBinding viewBinding;
    //3-> Editas el "onCreate" debajo de super..-> this.viewBinding = ActivityMainBinding.inflate(getLayoutInflater()); (debajo) setContentView( viewBinding.getRoot() );
    //4-> Creas X(Rutas)Application, extends Application + creas el onCreate
    //5-> Abres manifests -> AndroidManifest.xml -> Add name: (.X(Rutas)Application)
    //6-> Creas MainViewModel extends AndroidViewModel + constructor
    //7-> En MainActivity creas el viewModel :  private MainViewModel viewModel;
    //8-> Add en MainActivity en Oncreate debajo el : this.viewModel = new ViewModelProvider(this).get(MainViewModel.class)
    //9-> Creamos X("Ruta")
    //10->Creamos el repositorio de X(Rutas)


    private ActivityMainBinding viewBinding;
    //private MainViewModel viewModel;
    //private RutasAdapter rutasAdapter = new RutasAdapter();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.viewBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView( viewBinding.getRoot() );    }



    /*
    private void onRutaCreated(NewRutaActivityResult result)
    {
        if (result.isRutaCreated())
        {
            listarRutas();
        }

    }

    private void listarRutas()
    {
        rutasAdapter.setRutas(viewModel.getRutas() );

    }

    void showRutasActivity(String id)
    {
        Intent intent = new Intent(this, RutasActivity.class);
        intent.putExtra("idRuta",id);
        startActivity(intent);
    }

    class NewRutaActivityResultContract extends ActivityResultContract<String, NewRutaActivityResult>
    {

        @NonNull
        @Override
        public Intent createIntent(@NonNull Context context, String s)
        {
            Intent intent = new Intent(context,NewRutaActivity.class);

            return intent;
        }

        @Override
        public NewRutaActivityResult parseResult(int resultCode, @Nullable Intent intent) {
            if (resultCode == Activity.RESULT_OK)
            {
                return new NewRutaActivityResult(true, intent.getStringExtra("idRuta"));
            }

            return new NewRutaActivityResult(false,null);
        }
    }


    class NewRutaActivityResult
    {
        private  boolean rutaCreated;
        private String id;

        public NewRutaActivityResult(boolean rutaCreated, String id) {
            this.rutaCreated = rutaCreated;
            this.id = id;
        }

        public boolean isRutaCreated() {
            return rutaCreated;
        }

        public String getId() {
            return id;
        }
    }

*/
}
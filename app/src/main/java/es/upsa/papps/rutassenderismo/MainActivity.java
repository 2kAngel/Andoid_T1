package es.upsa.papps.rutassenderismo;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ImageButton;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Locale;

import es.upsa.papps.rutassenderismo.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {


    private ActivityMainBinding viewBinding;
    private MainViewModel viewModel;
    private RutasAdapter rutasAdapter = new RutasAdapter();

    ActivityResultLauncher<String> launcher = registerForActivityResult(new NewRutaActivityResultContract(),
            result -> onRutaCreated(result)
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {




        super.onCreate(savedInstanceState);
        this.viewBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView( viewBinding.getRoot() );

        this.viewModel = new ViewModelProvider(this).get(MainViewModel.class);


        listarRutas();
        rutasAdapter.setOnItemClick( (position,ruta) -> showRutasActivity(ruta.getId()));//te muestra el nombre de la ruta
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        //RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2, LinearLayoutManager.VERTICAL,false); // si lo quieres en pares
        viewBinding.rv.setLayoutManager(layoutManager);
        viewBinding.rv.setAdapter( rutasAdapter );


        viewBinding.btNew.setOnClickListener(v ->  launcher.launch("") );



        ImageButton imageButton = findViewById(R.id.imageButton);
        final boolean[] isImage1 = {true}; // Indica qué imagen está actualmente visible

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cambia el idioma
                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                String selectedLanguage;
                if (isImage1[0]) {
                    selectedLanguage = "en";
                } else {
                    selectedLanguage = "es";
                }
                prefs.edit().putString("selected_language", selectedLanguage).apply(); // Actualiza la preferencia de idioma

                Locale locale = new Locale(selectedLanguage);
                Locale.setDefault(locale);
                Configuration config = new Configuration();
                config.setLocale(locale);
                getResources().updateConfiguration(config, getResources().getDisplayMetrics());

                // Cambia la imagen
                if (isImage1[0] == true) {
                    imageButton.setImageResource(R.drawable.ic_toggle_on);
                    isImage1[0] = false;

                } else {
                    imageButton.setImageResource(R.drawable.ic_toggle_off);
                    isImage1[0] = true;
                }
            }

        });



    }




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
        Intent intent = new Intent(this, RutaActivity.class);
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

    public void setLocale(String lang) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("selected_language", lang);
        editor.apply();

        // Reinicia la actividad para aplicar el nuevo idioma
        Intent refresh = new Intent(this, MainActivity.class);
        finish();
        startActivity(refresh);
    }

}
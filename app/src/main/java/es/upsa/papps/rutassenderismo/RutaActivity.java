package es.upsa.papps.rutassenderismo;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import es.upsa.papps.rutassenderismo.databinding.ActivityRutaBinding;

public class RutaActivity extends AppCompatActivity
{
    ActivityRutaBinding viewBinding;

    RutasViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        this.viewBinding = ActivityRutaBinding.inflate(getLayoutInflater());
        setContentView(viewBinding.getRoot());
        this.viewModel = new ViewModelProvider(this).get(RutasViewModel.class);

        Intent intent = getIntent();
        String idRuta = intent.getStringExtra("idRuta");
        Ruta ruta = viewModel.findRutaByid(idRuta);

        viewBinding.tvId.setText("ID -> "+ruta.getId());
        viewBinding.tvNombreRuta.setText("Ruta -> "+ruta.getNombre_ruta());
        viewBinding.tvExplorador.setText("Explorador -> "+ruta.getExplorador());
        viewBinding.tvValoracion.setText("Valoracion -> " + String.valueOf(ruta.getValoracion())+"/10");
        viewBinding.tvDificultad.setText("Dificultad -> "+String.valueOf(ruta.getDificultad())+"/100");
    }
}

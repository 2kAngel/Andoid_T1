package es.upsa.papps.rutassenderismo;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

public class RutaActivity extends AppCompatActivity
{
    ActivityRutaBinding viewBinding;

    RutasViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        this.viewBinding = ActivityRutaBinding.inflate(getLayoutInflater());
        setContentView(viewBinding.getRoot());
        this.viewModel = new ViewModelProvider(this).get(RutaViewModel.class);

        Intent intent = getIntent();
        String idPelicula = intent.getStringExtra("idRuta");
        Ruta ruta = viewModel.findRutaByid(idRuta);
/*
        viewBinding.tvId.setText(pelicula.getId());
        viewBinding.tvTitulo.setText(pelicula.getTitulo());
        viewBinding.tvDirector.setText(pelicula.getDirector());
        viewBinding.tvValoracion.setText(String.valueOf(pelicula.getValoracion()));
*/
}

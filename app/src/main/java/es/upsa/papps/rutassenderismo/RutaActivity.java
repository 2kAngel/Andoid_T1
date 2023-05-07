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


        //---------Go back

        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //---------

        super.onCreate(savedInstanceState);
        this.viewBinding = ActivityRutaBinding.inflate(getLayoutInflater());
        setContentView(viewBinding.getRoot());
        this.viewModel = new ViewModelProvider(this).get(RutasViewModel.class);

        Intent intent = getIntent();
        String idRuta = intent.getStringExtra("idRuta");
        Ruta ruta = viewModel.findRutaByid(idRuta);

        String textoID = getString(R.string.tvID);
        String textoNR = getString(R.string.tvROUTE);
        String textoEX = getString(R.string.tvEXPLORER);
        String textoVA = getString(R.string.tvASSESSMENT);
        String textoDI = getString(R.string.tvDIFFICULTY);

        viewBinding.tvId.setText(textoID+ruta.getId());
        viewBinding.tvNombreRuta.setText(textoNR+ruta.getNombre_ruta());
        viewBinding.tvExplorador.setText(textoEX+ruta.getExplorador());
        viewBinding.tvValoracion.setText(textoVA+String.valueOf(ruta.getValoracion())+"/10");
        viewBinding.tvDificultad.setText(textoDI+String.valueOf(ruta.getDificultad())+"/100");
    }
}

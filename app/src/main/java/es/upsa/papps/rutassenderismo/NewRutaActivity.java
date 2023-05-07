package es.upsa.papps.rutassenderismo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.SeekBar;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import es.upsa.papps.rutassenderismo.databinding.ActivityNewRutaBinding;

public class NewRutaActivity extends AppCompatActivity
{


    private ActivityNewRutaBinding viewBinding;

    private NewRutaViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        //---------Go back

        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        //---------

        super.onCreate(savedInstanceState);
        this.viewBinding = ActivityNewRutaBinding.inflate(getLayoutInflater());
        setContentView(viewBinding.getRoot());

        this.viewModel = new ViewModelProvider(this).get(NewRutaViewModel.class);


        viewBinding.etNombreRuta.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                viewModel.setNombreRuta( editable.toString());
            }
        });


        viewBinding.etExplorador.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                viewModel.setExplorador( editable.toString());
            }
        });

        viewBinding.rbRating.setOnRatingBarChangeListener( (ratingBar,  rating,  fromUser) -> {
                    if (fromUser == true) viewModel.setValoracion(rating);
                }
        );


        viewBinding.skDiff.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    float dificultad = progress ;
                    viewModel.setDificultad(dificultad);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        viewBinding.btSave.setOnClickListener(v -> insertarRuta());

    }

    private void insertarRuta()
    {
        Ruta ruta = viewModel.crearRuta();

        Intent resultado = new Intent();
        resultado.putExtra("idRuta", ruta.getId());
        setResult(Activity.RESULT_OK, resultado);
        finish();
    }
}

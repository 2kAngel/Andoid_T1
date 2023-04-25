package es.upsa.papps.rutassenderismo;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import es.upsa.papps.rutassenderismo.databinding.RutaItemBinding;

public class RutasAdapter extends RecyclerView.Adapter<RutasAdapter.RutaViewHolder>
{
    public interface OnItemClick
    {
        public void onItemClick(int position, Ruta ruta);
    }

    private List<Ruta> rutas;

    private OnItemClick onItemClick;


    public void setRutas(List<Ruta> rutas) {
        this.rutas = rutas;
        notifyDataSetChanged();
    }

    public void setOnItemClick(OnItemClick onItemClick) {
        this.onItemClick = onItemClick;
    }

    @NonNull
    @Override
    public RutaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        RutaItemBinding viewBinding = RutaItemBinding.inflate(layoutInflater, parent ,false);
        return new RutaViewHolder(viewBinding);

    }

    @Override
    public void onBindViewHolder(@NonNull RutaViewHolder holder, int position)
    {
        Ruta ruta = rutas.get(position);
        holder.bind(ruta);
    }

    @Override
    public int getItemCount()
    {
        return (rutas == null)?0 : rutas.size();
    }

    class RutaViewHolder extends RecyclerView.ViewHolder
    {

        private RutaItemBinding viewBinding;

        private Ruta ruta;

        public RutaViewHolder(@NonNull RutaItemBinding viewBinding) {
            super(viewBinding.getRoot());
            this.viewBinding = viewBinding;
            viewBinding.getRoot().setOnClickListener(view -> { onItemClick.onItemClick(this.getAdapterPosition() , ruta); }  );
        }


        public void bind(Ruta ruta)
        {
            this.ruta = ruta;
            viewBinding.tvNombreRuta.setText(ruta.getNombre_ruta());
            viewBinding.tvExplorador.setText(ruta.getExplorador());
            viewBinding.tvValoracion.setText(String.valueOf(ruta.getValoracion()));
            viewBinding.tvDificultad.setText(String.valueOf(ruta.getDificultad()));
        }
    }


}

package com.example.menu;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    private List<ListadoDeElementos> mData;
    private LayoutInflater mInflater;
    private OnFavoritoClickListener onFavoritoClickListener;

    public ListAdapter(List<ListadoDeElementos> itemList, Context context, OnFavoritoClickListener listener) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = itemList;
        this.onFavoritoClickListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.listado, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ListadoDeElementos item = mData.get(position);
        holder.bindData(item);

        holder.btnMoreDetails.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), ActivityDetalles.class);
            intent.putExtra("nombre", item.getNombre());
            intent.putExtra("ciudad", item.getCiudad());
            intent.putExtra("descripcion", item.getDescripcion());
            intent.putExtra("direccion", item.getDireccion());
            intent.putExtra("telefono", item.getTelefono());
            intent.putExtra("sitioWeb", item.getSitioWeb());
            v.getContext().startActivity(intent);
        });

        holder.ivFavorito.setImageResource(item.isFavorito() ? R.drawable.favotrito : R.drawable.infavorito);
        holder.ivFavorito.setOnClickListener(v -> {
            if (onFavoritoClickListener != null) {
                onFavoritoClickListener.onFavoritoClicked(item, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvNombre, tvDescripcion;
        ImageView ivLogo, ivFavorito;
        Button btnMoreDetails;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNombre = itemView.findViewById(R.id.tvNombreUdelaSerena);
            tvDescripcion = itemView.findViewById(R.id.tvDescripcionUdelaSerena);
            ivLogo = itemView.findViewById(R.id.ivLogoUdelaSerena);
            ivFavorito = itemView.findViewById(R.id.ivFavorito);
            btnMoreDetails = itemView.findViewById(R.id.btnMoreDetailsUdelaSerena);
        }

        void bindData(ListadoDeElementos item) {
            tvNombre.setText(item.getNombre());
            tvDescripcion.setText(item.getDescripcion());
            ivLogo.setImageResource(item.getImageResId());
        }
    }

    public interface OnFavoritoClickListener {
        void onFavoritoClicked(ListadoDeElementos item, int position);
    }
}
package com.example.lab4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class LocationAdapter extends RecyclerView.Adapter<LocationAdapter.ViewHolder> {

    private final List<LocationItem> locationList;

    public LocationAdapter(List<LocationItem> locationList) {
        this.locationList = locationList;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvNombre, tvRegion, tvPais, tvLatitud, tvLongitud;

        public ViewHolder(View itemView) {
            super(itemView);
            tvNombre = itemView.findViewById(R.id.tvNombre);
            tvRegion = itemView.findViewById(R.id.tvRegion);
            tvPais = itemView.findViewById(R.id.tvPais);
            tvLatitud = itemView.findViewById(R.id.tvLatitud);
            tvLongitud = itemView.findViewById(R.id.tvLongitud);
        }
    }

    @NonNull
    @Override
    public LocationAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_location, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LocationAdapter.ViewHolder holder, int position) {
        LocationItem item = locationList.get(position);
        holder.tvNombre.setText("Nombre\n" + item.getName());
        holder.tvRegion.setText("Región\n" + item.getRegion());
        holder.tvPais.setText("País\n" + item.getCountry());
        holder.tvLatitud.setText("Latitud\n" + item.getLatitud());
        holder.tvLongitud.setText("Longitud\n" + item.getLongitud());
    }

    @Override
    public int getItemCount() {
        return locationList.size();
    }
}

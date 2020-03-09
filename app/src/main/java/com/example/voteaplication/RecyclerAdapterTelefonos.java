package com.example.voteaplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerAdapterTelefonos extends RecyclerView.Adapter<RecyclerAdapterTelefonos.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tv_telefono, tv_voto;
        public ViewHolder(View itemView){
            super(itemView);
            tv_telefono = (TextView)itemView.findViewById(R.id.tv_PTelefono);
            tv_voto = (TextView)itemView.findViewById(R.id.tv_PVoto);

        }
    }
    public List<Participante> listaCandido;

    public RecyclerAdapterTelefonos(List<Participante> listaParticipante) {
        listaCandido = listaParticipante;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_participante, parent, false); //Podría dar error aquí debido a las importaciones de clases
        RecyclerAdapterTelefonos.ViewHolder viewHolder = new RecyclerAdapterTelefonos.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tv_telefono.setText(listaCandido.get(position).getTelefonoParticipante());
        holder.tv_voto.setText(listaCandido.get(position).getVotoParticipante());
    }

    @Override
    public int getItemCount() {
        return listaCandido.size();
    }
}

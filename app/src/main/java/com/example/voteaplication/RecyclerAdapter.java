package com.example.voteaplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerAdapter  extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {



    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tv_candidato, tv_partido, tv_acronimo, tv_votos;
        public ViewHolder(View itemView){
            super(itemView);
            tv_candidato = (TextView)itemView.findViewById(R.id.tv_CNombre);
            tv_partido = (TextView)itemView.findViewById(R.id.tv_CPartido);
            tv_acronimo = (TextView)itemView.findViewById(R.id.tv_CAcronimo);
            tv_votos = (TextView)itemView.findViewById(R.id.tv_CVotos);

        }
    }
    public List<Candidato> listaCandido;

    public RecyclerAdapter(List<Candidato> listaCandidato){
        listaCandido = listaCandidato;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_candidatos, parent, false); //Podría dar error aquí debido a las importaciones de clases
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tv_candidato.setText(listaCandido.get(position).getCandidatoNombre());
        holder.tv_partido.setText(listaCandido.get(position).getCandidatoPartido());
        holder.tv_acronimo.setText(listaCandido.get(position).getCandidatoAcronimo());
        holder.tv_votos.setText(""+listaCandido.get(position).getCandidatoVotos());
    }

    @Override
    public int getItemCount() {
        return listaCandido.size();
    }

}

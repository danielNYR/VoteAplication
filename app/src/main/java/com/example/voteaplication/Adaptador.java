package com.example.voteaplication;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class Adaptador extends BaseAdapter {
    ArrayList<Candidato> listaCandidatos = new ArrayList<>(); //lista
    daoCandidato obj_daoCandidato; //dao
    Candidato obj_candidato; //c
    Fragment fragment; //a
    Activity a;

    public Adaptador(ArrayList<Candidato> listaCandidatos, daoCandidato obj_daoCandidato, Activity a) {
        this.listaCandidatos = listaCandidatos;
        this.obj_daoCandidato = obj_daoCandidato;
        this.a = a;
    }

    public Adaptador(ArrayList<Candidato> listaCandidatos, daoCandidato obj_daoCandidato, Fragment fragment) {
        this.listaCandidatos = listaCandidatos;
        this.obj_daoCandidato = obj_daoCandidato;
        this.fragment = fragment;
    }

    @Override
    public int getCount() {
        return listaCandidatos.size();
    }

    @Override
    public Object getItem(int position) {
        obj_candidato = listaCandidatos.get(position);
        return null;
    }

    @Override
    public long getItemId(int position) {
        obj_candidato = listaCandidatos.get(position);
        return obj_candidato.getCandidatoId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View vista = convertView;
        if(vista != null){
            LayoutInflater layoutInflater = (LayoutInflater) a.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            vista = layoutInflater.inflate(R.layout.item_candidato, null);
        }
        obj_candidato = listaCandidatos.get(position);

        //TextView name = (TextView) vista.findViewById(R.id.txt_nombre);
        TextView nombre = (TextView) vista.findViewById(R.id.txt_nombre);
        TextView partido = (TextView)vista.findViewById(R.id.txt_partido);
        TextView acronimo = (TextView)vista.findViewById(R.id.txt_acronimo);
        TextView votos = (TextView)vista.findViewById(R.id.txt_votos);
        //Asignación de valores
        nombre.setText(listaCandidatos.get(position).candidatoNombre);
        partido.setText(listaCandidatos.get(position).candidatoPartido);
        acronimo.setText(listaCandidatos.get(position).candidatoAcronimo);
        votos.setText(""+ listaCandidatos.get(position).candidatoVotos);

        return vista;
    }
}

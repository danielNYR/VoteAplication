package com.example.voteaplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    View ref;
    private RecyclerView recyclerViewCandidato;
    private  RecyclerAdapter adaptadorCandidatos;
    daoCandidato daoCandidato;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //listaCandidato.add(new Candidato(1, "Daniel", "Prinosaurio", "PRT", 0));

        ref = inflater.inflate(R.layout.home_fragment, container, false);
        daoCandidato = new daoCandidato(ref.getContext());
        recyclerViewCandidato = (RecyclerView) ref.findViewById(R.id.recycler_candidatos);
        recyclerViewCandidato.setLayoutManager(new LinearLayoutManager(this.getActivity()));

        adaptadorCandidatos = new RecyclerAdapter(daoCandidato.getListaCandidato());
        recyclerViewCandidato.setAdapter(adaptadorCandidatos);

        /*obj_datoCandidato = new daoCandidato(this.getActivity());
        listaCandidato = new ArrayList<>();
        listaCandidato = obj_datoCandidato.getListaCandidato();

        adaptador = new Adaptador(listaCandidato, obj_datoCandidato, this);
        lview = (ListView) ref.findViewById(R.id.listv_candidatos); //Quite el lv temporalmente
        lview.setAdapter(adaptador);*/
        return ref;
    }


}

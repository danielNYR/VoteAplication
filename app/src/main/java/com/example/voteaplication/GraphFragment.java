package com.example.voteaplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class GraphFragment extends Fragment {
    View reference;
    daoCandidato daoCandidato;
    List<Votos> lista_entradas;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        reference = inflater.inflate(R.layout.graph_fragment, container, false);

        PieChart pieChart = reference.findViewById(R.id.pie_chart);
        daoCandidato = new daoCandidato(reference.getContext());
        //lista_entradas = daoCandidato.listaVotos;
        /*ArrayList<PieEntry> candidatos = new ArrayList<>();
        for (int indice_le = 0; indice_le < lista_entradas.size(); indice_le++){
            candidatos.add(new PieEntry(lista_entradas.get(indice_le).getCantidadVotos(), lista_entradas.get(indice_le).getAcronimoVotos()));
        }*/
        PieDataSet set = new PieDataSet(daoCandidato.getListaVotos(), "Candidatos Actuales");
        PieData data = new PieData(set);
        set.setColors(ColorTemplate.MATERIAL_COLORS);
        pieChart.setData(data);
        pieChart.invalidate();

        return reference;
    }
}

package com.example.voteaplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class VistaCandidatos extends AppCompatActivity {

    daoCandidato obj_datoCandidato; //dao
    ArrayList<Candidato> listaCandidato;
    ListView lview;
    Button boton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista_candidatos);
    }
}

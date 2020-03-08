package com.example.voteaplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class RegisterFragment extends Fragment {

    Button newRegistro;
    Candidato candidato;
    daoCandidato daoCandidato;
    View vista;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        vista = inflater.inflate(R.layout.register_fragment, container, false);
        daoCandidato = new daoCandidato(vista.getContext());
        newRegistro = (Button) vista.findViewById(R.id.btn_registrar);
        final EditText nombre = (EditText) vista.findViewById(R.id.et_nombre);
        final EditText partido = (EditText) vista.findViewById(R.id.et_partido);
        final EditText acronimo = (EditText) vista.findViewById(R.id.et_acronimo);

        newRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if(daoCandidato.insert_new(new Candidato(nombre.getText().toString(), partido.getText().toString(), acronimo.getText().toString(), 0))){
                        nombre.setText("");
                        partido.setText("");
                        acronimo.setText("");
                        Toast.makeText(getActivity().getApplication(), "Se ha registrado al candidato", Toast.LENGTH_SHORT).show();
                    }

                }catch (Exception e){
                    Toast.makeText(getActivity().getApplication(), "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        return vista;
    }

    private void obtenerDatos(){

    }


}

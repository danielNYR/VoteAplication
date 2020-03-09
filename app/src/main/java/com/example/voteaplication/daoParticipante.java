package com.example.voteaplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;

public class daoParticipante {

    SQLiteDatabase conextion; //cx
    ArrayList<Participante> listaParticipante = new ArrayList<>(); //lista
    Participante objParticipante;
    Context context;
    String dbName = "DBVotos";
    String create_table_numeros = "create table if not exists participante(participanteId integer primary key autoincrement, telefonoParticipante text, votoParticipante text)";

    public daoParticipante() {
    }

    public daoParticipante(Context context) {
        this.context = context;
        conextion = context.openOrCreateDatabase(dbName, Context.MODE_PRIVATE, null);
        conextion.execSQL(create_table_numeros);
    }

    public boolean insert_participante(Participante objParticipante){
        ContentValues contentValues = new ContentValues();
        contentValues.put("telefonoParticipante", objParticipante.getTelefonoParticipante());
        contentValues.put("votoParticipante", objParticipante.getVotoParticipante());

        return (conextion.insert("participante", null, contentValues))>0;
    }

    public boolean ifexists(String telefono){
        ContentValues contentValues = new ContentValues();
        Cursor database = conextion.rawQuery("select * from participante where telefonoParticipante ='"+telefono+"';", null);
        if(database != null && database.getCount()>0){
           return true; //Se ha encontrado que ya ha participado
        }else{
            return false;
        }
    }



    public ArrayList<Participante> getListaParticipante(){
        listaParticipante.clear();
        Cursor database = conextion.rawQuery("select * from participante", null);
        if(database != null && database.getCount()>0){
            database.moveToFirst();
            do {
                listaParticipante.add(new Participante(
                        database.getString(1),
                        database.getString(2)));
            }while (database.moveToNext());
        }
        return listaParticipante;
    }
}

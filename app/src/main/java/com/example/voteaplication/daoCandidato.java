package com.example.voteaplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class daoCandidato {

    SQLiteDatabase conextion; //cx
    ArrayList<Candidato> listaCandidato = new ArrayList<>(); //lista
    Candidato objCandidato; //c
    Context context;
    String dbName = "DBVotos";
    String create_table = "create table if not exists candidato(candidatoId integer primary key autoincrement, candidatoNombre text, " +
            "candidatoPartido text, candidatoAcronimo text, candidatoVotos integer)";
    String create_table_numeros = "create table if not exist telefono_participante(telefonoId integer primary key autoincrement, telefono text)";

    public daoCandidato() {
    }

    public daoCandidato(Context context) {
        this.context = context;
        conextion = context.openOrCreateDatabase(dbName, Context.MODE_PRIVATE, null);
        conextion.execSQL(create_table);

    }

    public boolean insert_new(Candidato candidato){
        ContentValues contentValues = new ContentValues();
        contentValues.put("candidatoNombre", candidato.getCandidatoNombre());
        contentValues.put("candidatoPartido", candidato.getCandidatoPartido());
        contentValues.put("candidatoAcronimo", candidato.getCandidatoAcronimo());
        contentValues.put("candidatoVotos", candidato.getCandidatoVotos());

        return (conextion.insert("candidato", null, contentValues))>0;
    }

    public boolean update_votos(int id){
        final int votoSumado = 1;

        return true;
    }

    public ArrayList<Candidato>getListaCandidato(){
        listaCandidato.clear();
        Cursor database = conextion.rawQuery("select * from candidato", null);
        if(database != null && database.getCount()>0){
            database.moveToFirst();
            do {
                listaCandidato.add(new Candidato(database.getInt(0),
                        database.getString(1),
                        database.getString(2),
                        database.getString(3),
                        database.getInt(4)));
            }while (database.moveToNext());
        }
        return listaCandidato;
    }
}

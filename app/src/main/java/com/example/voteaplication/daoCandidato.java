package com.example.voteaplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;

public class daoCandidato {

    SQLiteDatabase conextion; //cx
    ArrayList<Candidato> listaCandidato = new ArrayList<>(); //lista
    Candidato objCandidato; //c
    Context context;
    String dbName = "DBVotos";
    String create_table = "create table if not exists candidato(candidatoId integer primary key autoincrement, candidatoNombre text, " +
            "candidatoPartido text, candidatoAcronimo text, candidatoVotos integer)";

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

    public boolean ifexists(String acronimo){
        ContentValues contentValues = new ContentValues();
        Cursor database = conextion.rawQuery("select * from candidato where candidatoAcronimo ='"+acronimo+"';", null);
        if(database != null && database.getCount()>0){
            return true; //Se ha encontrado que ya ha participado
        }else{
            return false;
        }
    }

    ArrayList<PieEntry> listaVotos = new ArrayList<>();
    public ArrayList<PieEntry>getListaVotos(){
        listaVotos.clear();
        Cursor database = conextion.rawQuery("select * from candidato", null);
        if(database != null && database.getCount()>0){
            database.moveToFirst();
            do {
                listaVotos.add(new PieEntry(database.getInt(4), database.getString(3)));//new Votos(, ));
            }while (database.moveToNext());
        }
        return listaVotos;
    }

    public boolean update_votos(String acronimo){
        final int votoSumado = 1;
        ContentValues contentValues = new ContentValues();
        Cursor database = conextion.rawQuery("select * from candidato where candidatoAcronimo ='"+acronimo+"';", null);
        if(database != null && database.getCount()>0){
            database.moveToFirst(); //Se mueve al primero...que debería ser el único
            contentValues.put("candidatoId", database.getString(0));
            contentValues.put("candidatoNombre", database.getString(1));
            contentValues.put("candidatoPartido", database.getString(2));
            contentValues.put("candidatoAcronimo", database.getString(3));
            contentValues.put("candidatoVotos", (database.getInt(4) + 1));
            Toast.makeText(context, "Se ha realizado el voto", Toast.LENGTH_SHORT).show();
            return (conextion.update("candidato", contentValues, "candidatoId="+database.getInt(0), null)) > 0;
        }else{
            return false;
        }

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

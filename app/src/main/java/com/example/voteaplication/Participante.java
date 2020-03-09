package com.example.voteaplication;

public class Participante {

    int idParticipante;
    String telefonoParticipante;
    String votoParticipante;

    public Participante(int anInt, String string, String databaseString) {
    }

    public Participante(String telefonoParticipante, String votoParticipante) {
        this.telefonoParticipante = telefonoParticipante;
        this.votoParticipante = votoParticipante;
    }


    public String getTelefonoParticipante() {
        return telefonoParticipante;
    }

    public void setTelefonoParticipante(String telefonoParticipante) {
        this.telefonoParticipante = telefonoParticipante;
    }

    public String getVotoParticipante() {
        return votoParticipante;
    }

    public void setVotoParticipante(String votoParticipante) {
        this.votoParticipante = votoParticipante;
    }
}

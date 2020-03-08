package com.example.voteaplication;

public class Candidato {

    int candidatoId;
    String candidatoNombre;
    String candidatoPartido;
    String candidatoAcronimo;
    int candidatoVotos;

    public Candidato() {
    }

    public Candidato(String candidatoNombre, String candidatoPartido, String candidatoAcronimo, int candidatoVotos) {
        this.candidatoNombre = candidatoNombre;
        this.candidatoPartido = candidatoPartido;
        this.candidatoAcronimo = candidatoAcronimo;
        this.candidatoVotos = candidatoVotos;
    }

    public Candidato(int candidatoId, String candidatoNombre, String candidatoPartido, String candidatoAcronimo, int candidatoVotos) {
        this.candidatoId = candidatoId;
        this.candidatoNombre = candidatoNombre;
        this.candidatoPartido = candidatoPartido;
        this.candidatoAcronimo = candidatoAcronimo;
        this.candidatoVotos = candidatoVotos;
    }

    public int getCandidatoId() {
        return candidatoId;
    }

    public void setCandidatoId(int candidatoId) {
        this.candidatoId = candidatoId;
    }

    public String getCandidatoNombre() {
        return candidatoNombre;
    }

    public void setCandidatoNombre(String candidatoNombre) {
        this.candidatoNombre = candidatoNombre;
    }

    public String getCandidatoPartido() {
        return candidatoPartido;
    }

    public void setCandidatoPartido(String candidatoPartido) {
        this.candidatoPartido = candidatoPartido;
    }

    public String getCandidatoAcronimo() {
        return candidatoAcronimo;
    }

    public void setCandidatoAcronimo(String candidatoAcronimo) {
        this.candidatoAcronimo = candidatoAcronimo;
    }

    public int getCandidatoVotos() {
        return candidatoVotos;
    }

    public void setCandidatoVotos(int candidatoVotos) {
        this.candidatoVotos = candidatoVotos;
    }
}

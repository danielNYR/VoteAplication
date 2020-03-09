package com.example.voteaplication;

public class Votos {
    String acronimoVotos;
    int cantidadVotos;

    public Votos(String acronimoVotos, int cantidadVotos) {
        this.acronimoVotos = acronimoVotos;
        this.cantidadVotos = cantidadVotos;
    }

    public String getAcronimoVotos() {
        return acronimoVotos;
    }

    public void setAcronimoVotos(String acronimoVotos) {
        this.acronimoVotos = acronimoVotos;
    }

    public int getCantidadVotos() {
        return cantidadVotos;
    }

    public void setCantidadVotos(int cantidadVotos) {
        this.cantidadVotos = cantidadVotos;
    }
}

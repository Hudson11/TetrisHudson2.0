package com.example.aluno.tetrishudson.Peças_Jogo;

import java.util.ArrayList;

public abstract class Pecas {

    ArrayList<int[]> pontos;

    public Pecas(ArrayList<int[]> pontos) {
        this.pontos = pontos;
    }
    public Pecas(){}

    public ArrayList<int[]> getPontos() {
        return pontos;
    }

    public void setPontos(ArrayList<int[]> pontos) {
        this.pontos = pontos;
    }
}

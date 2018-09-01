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


    public void rotate(){

    }

    public void left(){
        pontos.get(0)[1] -= 1;
        pontos.get(1)[1] -= 1;
        pontos.get(2)[1] -= 1;
        pontos.get(3)[1] -= 1;
    }

    public void right() {
        pontos.get(0)[1] += 1;
        pontos.get(1)[1] += 1;
        pontos.get(2)[1] += 1;
        pontos.get(3)[1] += 1;
    }

    public void Movimenta_baixo(){
        pontos.get(0)[0] += 1;
        pontos.get(1)[0] += 1;
        pontos.get(2)[0] += 1;
        pontos.get(3)[0] += 1;
    }
}

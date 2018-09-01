package com.example.aluno.tetrishudson.Peças_Jogo;

import java.util.ArrayList;
import java.util.Arrays;

public class Peca_7 extends Pecas {

    public Peca_7(ArrayList<int[]> pontos) {
        super(pontos);
    }

    public Peca_7(){
        pontos =  new ArrayList<>(Arrays.asList(new int[2], new int[2], new int[2],new int[2]));

        pontos.get(0)[0] = 1;
        pontos.get(0)[1] = 11;

        pontos.get(1)[0] = 1;
        pontos.get(1)[1] = 12;

        pontos.get(2)[0] = 2;
        pontos.get(2)[1] = 11;

        pontos.get(3)[0] = 2;
        pontos.get(3)[1] = 12;
    }

    /*
    *  Representação da peça
    *       **
    *       **
    *
    * */

    public void Rotate(){
        return;
    }

}

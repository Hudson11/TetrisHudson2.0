package com.example.aluno.tetrishudson.Peças_Jogo;

import java.util.ArrayList;
import java.util.Arrays;

public class Peca_1 extends Pecas{

    public Peca_1(ArrayList<int[]> pontos) {
        super(pontos);
    }

    public Peca_1(){
        pontos =  new ArrayList<>(Arrays.asList(new int[2], new int[2], new int[2],new int[2]));

        pontos.get(0)[0] = 1;
        pontos.get(0)[1] = 14;

        pontos.get(1)[0] = 2;
        pontos.get(1)[1] = 13;

        pontos.get(2)[0] = 2;
        pontos.get(2)[1] = 14;

        pontos.get(3)[0] = 2;
        pontos.get(3)[1] = 15;
    }

    /*
    * Representação da Peça
    *         *
    *        ***
    *
    * */


}

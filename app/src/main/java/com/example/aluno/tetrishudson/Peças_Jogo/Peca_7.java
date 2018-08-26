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

        int aux1[] = new int[2];
        int aux2[] = new int[2];

        //Guarda o estado da peça - 1
        aux1[0] = pontos.get(1)[0];
        aux1[1] = pontos.get(1)[1];

        //Peça1 recebe a peça0
        pontos.get(1)[0] = pontos.get(0)[0];
        pontos.get(1)[1] = pontos.get(0)[1];

        //Guarda o estado da peça2
        aux2[0] = pontos.get(2)[0];
        aux2[1] = pontos.get(2)[1];

        //peça2 recebe peça1
        pontos.get(2)[0] = aux1[0];
        pontos.get(2)[1] = aux1[1];

        //Guarda estado da peça3
        aux1[0] = pontos.get(3)[0];
        aux1[1] = pontos.get(3)[1];

        //peça3 recebe a peça2
        pontos.get(3)[0] = aux2[0];
        pontos.get(3)[1] = aux2[1];

        //peça0 recebe peça3
        pontos.get(0)[0] = aux1[0];
        pontos.get(0)[0] = aux1[1];
    }

}

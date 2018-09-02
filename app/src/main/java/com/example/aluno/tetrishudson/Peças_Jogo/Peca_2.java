package com.example.aluno.tetrishudson.Peças_Jogo;

import java.util.ArrayList;
import java.util.Arrays;

public class Peca_2 extends Pecas {

    static int rotacao = 0;

    public Peca_2(ArrayList<int[]> pontos) {
        super(pontos);
    }

    public Peca_2(){
        pontos =  new ArrayList<>(Arrays.asList(new int[2], new int[2], new int[2],new int[2]));

        pontos.get(0)[0] = 0;
        pontos.get(0)[1] = 14;

        pontos.get(1)[0] = 1;
        pontos.get(1)[1] = 14;

        pontos.get(2)[0] = 1;
        pontos.get(2)[1] = 13;

        pontos.get(3)[0] = 2;
        pontos.get(3)[1] = 13;
    }

    /*
    *   Representação da Peça
    *        *
    *       **
    *       *
    * */
    /* R1 = (0) R2 = (1) R3 = (3)
    *  fator de rotação           [R1]
    *                          [*][R2]  [R1][*]
    *                          [R3]         [R3][R2]
    * */
    @Override
    public void rotate(){

        if(rotacao == 0){
            pontos.get(0)[0] = pontos.get(2)[0];
            pontos.get(0)[1] = pontos.get(2)[1] - 1;

            pontos.get(1)[0] = pontos.get(2)[0] + 1;
            pontos.get(1)[1] = pontos.get(2)[1] + 1;
            rotacao = 1;
        }else{
            pontos.get(0)[0] = pontos.get(2)[0] - 1;
            pontos.get(0)[1] = pontos.get(2)[1] + 1;

            pontos.get(1)[0] = pontos.get(2)[0];
            pontos.get(1)[1] = pontos.get(2)[1] + 1;
            rotacao = 0;
        }
        return;
    }
}

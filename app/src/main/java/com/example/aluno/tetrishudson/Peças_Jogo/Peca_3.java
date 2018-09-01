package com.example.aluno.tetrishudson.Peças_Jogo;

import java.util.ArrayList;
import java.util.Arrays;

public class Peca_3 extends Pecas {

    int vertical = 0;
    int horizontal = 1;

    public Peca_3(ArrayList<int[]> pontos) {
        super(pontos);
    }

    public Peca_3(){
        pontos =  new ArrayList<>(Arrays.asList(new int[2], new int[2], new int[2],new int[2]));

        pontos.get(0)[0] = 1;
        pontos.get(0)[1] = 13;

        pontos.get(1)[0] = 2;
        pontos.get(1)[1] = 13;

        pontos.get(2)[0] = 3;
        pontos.get(2)[1] = 13;

        pontos.get(3)[0] = 4;
        pontos.get(3)[1] = 13;
    }

    /*
    *  Representação da Peça
    *       *
    *       *
    *       *
    *       *
    * */

    /*
    *   [ ]
    *   [ ]
    *   [*] ponto de referencia para o giro [][*][ ][ ]
     *  [ ]
    *
    * */

    @Override
    public void rotate(){

        if(vertical == 1){
            pontos.get(0)[0] = pontos.get(2)[0] - 2;
            pontos.get(0)[1] = pontos.get(2)[1];

            pontos.get(1)[0] = pontos.get(2)[0] - 1;
            pontos.get(1)[1] = pontos.get(2)[1];

            pontos.get(3)[0] = pontos.get(2)[0] + 1;
            pontos.get(3)[1] = pontos.get(2)[1];

            horizontal = 1;
            vertical = 0;
        }else if(horizontal == 1){
            pontos.get(0)[0] = pontos.get(2)[0];
            pontos.get(0)[1] = pontos.get(2)[1] + 2;

            pontos.get(1)[0] = pontos.get(2)[0];
            pontos.get(1)[1] = pontos.get(2)[1] + 1;

            pontos.get(3)[0] = pontos.get(2)[0];
            pontos.get(3)[1] = pontos.get(2)[1] - 1;

            vertical = 1;
            horizontal = 0;
        }
        return;
    }
}

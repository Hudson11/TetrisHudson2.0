package com.example.aluno.tetrishudson;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class GameActivity extends AppCompatActivity {

    static final int EIXO_X = 35;
    static final int EIXO_Y = 25;

    ImageView[][] borda;
    ImageView imagem;
    int[][] referencia;

    GridLayout layout;
    TextView pontos;

    //peças
    ArrayList<Integer[]> quadrado;
    ArrayList<Integer[]> l_esquerda;
    ArrayList<Integer[]> l_direita;
    ArrayList<Integer[]> reto_horizontal;
    ArrayList<Integer[]> reto_vertical;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        //Configuração Padrão, vale caso seja instalado do 0 e o usuário ainda não tem configurado as dificuldades do jogo.
        int velocidade = 400, nivel = 4;


        //Recebe informações de Configurações selecionadas em ConfigActivity
        SharedPreferences prefs = getSharedPreferences("PREFS_NAME",MODE_PRIVATE);
        velocidade = prefs.getInt("velocidade", 1);
        nivel = prefs.getInt("nivel", 2);

        //checar se as informações foram corretamente passadas
        Log.i("JOGO", "velocidade: " + velocidade + " nivel: " + nivel);


        pontos = findViewById(R.id.pontos);
        imagem = findViewById(R.id.proxima);

        //matriz de referências
        referencia = new int[EIXO_X][EIXO_Y];

        //Matriz de Imagem
        //Tabuleiro
        borda = new ImageView[EIXO_X][EIXO_Y];
        layout = findViewById(R.id.gridBoard);

        //Set linhas e colunas
        layout.setRowCount(EIXO_X);
        layout.setColumnCount(EIXO_Y);

        LayoutInflater inflater = LayoutInflater.from(this);

        for (int x = 0; x < layout.getRowCount(); x++) {
            for (int y = 0; y < layout.getColumnCount(); y++) {
                //O tabuleiro na posição X,Y recebe uma ImageView inflado.
                borda[x][y] = (ImageView) inflater.inflate(R.layout.inflate_image_black, layout, false);

                if (x == 0) {
                    borda[x][y].setImageResource(R.drawable.blocograyp);
                    referencia[x][y] = 1;
                } else if (x == EIXO_X - 1) {
                    borda[x][y].setImageResource(R.drawable.blocograyp);
                    referencia[x][y] = 1;
                } else if (y == 0) {
                    borda[x][y].setImageResource(R.drawable.blocograyp);
                    referencia[x][y] = 1;
                } else if (y == EIXO_Y - 1) {
                    borda[x][y].setImageResource(R.drawable.blocograyp);
                    referencia[x][y] = 1;
                }
                //Adicionando ao Grid Layout o conteúdo no tabuleiro de imagens na posição X,Y.
                layout.addView(borda[x][y]);
            }
        }


        /*referencia[10][10] = 5;

        for(int i = 0; i < layout.getRowCount(); i++){
            for(int j = 0; j < layout.getColumnCount(); j++){
                if(referencia[i][j] == 5){
                    borda[i][j].setImageResource(R.drawable.blocowhitep);
                }
            }
        }*/
        boolean pausa = true;

        while(pausa){

            new Thread (new Runnable() {
                public void run(){

                    for(int i = 0, j = 0; i < EIXO_X; i++, j++){

                    }
                }
            }).start();

        }
    }
    public void inicia_peca(){
        //quadrado = new ArrayList<>(new int[2], new int[2], new int[2], new int [2]);
    }
}



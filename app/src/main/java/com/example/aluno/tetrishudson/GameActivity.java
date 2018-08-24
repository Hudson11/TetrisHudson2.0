package com.example.aluno.tetrishudson;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

    //vetor de peças
    ArrayList <ArrayList<Integer>> pecas;
    //peca;
    ArrayList<Integer> peca;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        //Recebe informações passadas através da Intent criada em Config.activity
       /* Bundle configs = getIntent().getExtras();
        int velocidade = configs.getInt("velocidade");
        int qtd_Pecas = configs.getInt("nivel");*/

        pontos = findViewById(R.id.text);
        imagem = findViewById(R.id.imageView);

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


    }

}



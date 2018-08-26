package com.example.aluno.tetrishudson.Activity_class;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.aluno.tetrishudson.Peças_Jogo.Peca_1;
import com.example.aluno.tetrishudson.Peças_Jogo.Peca_2;
import com.example.aluno.tetrishudson.Peças_Jogo.Peca_3;
import com.example.aluno.tetrishudson.Peças_Jogo.Peca_4;
import com.example.aluno.tetrishudson.Peças_Jogo.Peca_5;
import com.example.aluno.tetrishudson.Peças_Jogo.Peca_6;
import com.example.aluno.tetrishudson.Peças_Jogo.Peca_7;
import com.example.aluno.tetrishudson.Peças_Jogo.Pecas;
import com.example.aluno.tetrishudson.R;

import java.util.Random;

public class GameActivity extends AppCompatActivity {

    static final int EIXO_X = 35;
    static final int EIXO_Y = 25;

    ImageView[][] borda;
    ImageView imagem;
    int[][] referencia;

    GridLayout layout;
    TextView pontos;

    //Configuração Padrão, vale caso seja instalado do 0 e o usuário ainda não tem configurado as dificuldades do jogo.
    int velocidade = 400, nivel = 4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);


        //Recebe informações de Configurações selecionadas em ConfigActivity
        SharedPreferences prefs = getSharedPreferences("PREFS_NAME", MODE_PRIVATE);
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
    }

    public int createRadom_Peça () {
        Random r = new Random();
        int aleatorio = r.nextInt(nivel);
        Log.i("random", "Número random: " + aleatorio);
        return aleatorio;
    }

    Pecas peça;
    Handler handle = new Handler();
    boolean repete;

    public void Movimenta () {

        new Thread(new Runnable() {
            @Override
            public void run() {
                while(repete){
                    try{
                        Thread.sleep(velocidade);
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }

                    handle.post(new Runnable() {
                        @Override
                        public void run() {

                            int peça_number = createRadom_Peça();

                            if(peça_number == 1) {
                                peça = new Peca_1();
                            }else if(peça_number == 2){
                                peça = new Peca_2();
                            }else if(peça_number == 3){
                                peça = new Peca_3();
                            }else if(peça_number == 4){
                                peça = new Peca_4();
                            }else if(peça_number == 5){
                                peça = new Peca_5();
                            }else if(peça_number == 6){
                                peça = new Peca_6();
                            }else{
                                peça = new Peca_7();
                            }

                            for(int i = 0, j = 0; i < EIXO_X; i++,j++){
                            }
                            repete = false;
                        }
                    });
                }
            }
        });

    }
}

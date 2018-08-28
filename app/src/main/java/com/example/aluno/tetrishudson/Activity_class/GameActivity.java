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
    boolean nova_peça = true;
    int cont = 1;

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

        createRadom_Peça();
        Movimenta();
    }

    //******************************************************
    //******************************************************
    //******************************************************

    public int createRadom_Peça () {
        Random r = new Random();
        int aleatorio = r.nextInt(nivel);
        Log.i("random", "Número random: " + aleatorio);
        return aleatorio;
    }

    Pecas peça_atual;
    Pecas proxima_peça;

    Handler handle = new Handler();
    boolean repete = true;

    int numero;

    public void setNumero(){
        numero = 1;
    }

    public void Movimenta () {

        setNumero();

        new Thread(new Runnable() {
            @Override
            public void run() {

                repete = true;
                while(repete){
                    try{
                        Thread.sleep(velocidade);
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }

                    handle.post(new Runnable() {
                        @Override
                        public void run() {


                          if(nova_peça == true) {
                               switch (numero) {
                                   case 1:
                                       int atual_number = createRadom_Peça();
                                       if (atual_number == 0) {
                                           peça_atual = new Peca_1();
                                       } else if (atual_number == 1) {
                                           peça_atual = new Peca_2();
                                       } else if (atual_number == 2) {
                                           peça_atual = new Peca_3();
                                       } else if (atual_number == 3) {
                                           peça_atual = new Peca_4();
                                       } else if (atual_number == 4) {
                                           peça_atual = new Peca_5();
                                       } else if (atual_number == 5) {
                                           peça_atual = new Peca_6();
                                       } else {
                                           peça_atual = new Peca_7();
                                       }
                                       Log.i("PEÇA","peça: "+atual_number);
                                       numero = 0;
                                       nova_peça = false;
                                       break;
                                   case 0:
                                       int proxima_number = createRadom_Peça();

                                       if (proxima_number == 0) {
                                           proxima_peça = new Peca_1();
                                       } else if (proxima_number == 1) {
                                           proxima_peça = new Peca_2();
                                       } else if (proxima_number == 2) {
                                           proxima_peça = new Peca_3();
                                       } else if (proxima_number == 3) {
                                           proxima_peça = new Peca_4();
                                       } else if (proxima_number == 4) {
                                           proxima_peça = new Peca_5();
                                       } else if (proxima_number == 5) {
                                           proxima_peça = new Peca_6();
                                       } else {
                                           proxima_peça = new Peca_7();
                                       }

                                       peça_atual = proxima_peça;
                                       nova_peça = false;
                                       break;
                                   default:
                                       Log.i("ERRO", "erro ao criar peça");
                               }
                           }
                           //peça_atual = new Peca_3();



                            Log.i("EXECUTA", "eixo x " + peça_atual.getPontos().get(0)[0] + " eixo y " + peça_atual.getPontos().get(0)[1]);
                            Log.i("EXECUTA", "eixo x " + peça_atual.getPontos().get(1)[0] + " eixo y " + peça_atual.getPontos().get(1)[1]);
                            Log.i("EXECUTA", "eixo x " + peça_atual.getPontos().get(2)[0] + " eixo y " + peça_atual.getPontos().get(2)[1]);
                            Log.i("EXECUTA", "eixo x " + peça_atual.getPontos().get(3)[0] + " eixo y " + peça_atual.getPontos().get(3)[1]);


                            Log.i("ENTROU", "Laço esta sendo executado" + cont);

                           /* borda[peça_atual.getPontos().get(0)[0]][peça_atual.getPontos().get(0)[1]].setImageResource(R.drawable.blocograyp);
                            borda[peça_atual.getPontos().get(1)[0]][peça_atual.getPontos().get(1)[1]].setImageResource(R.drawable.blocograyp);
                            borda[peça_atual.getPontos().get(2)[0]][peça_atual.getPontos().get(2)[1]].setImageResource(R.drawable.blocograyp);
                            borda[peça_atual.getPontos().get(3)[0]][peça_atual.getPontos().get(3)[1]].setImageResource(R.drawable.blocograyp);*/

                            peça_atual.getPontos().get(0)[0] = cont;
                            peça_atual.getPontos().get(1)[0] = cont;
                            peça_atual.getPontos().get(2)[0] = cont;
                            peça_atual.getPontos().get(3)[0] = cont;

                            referencia[peça_atual.getPontos().get(0)[0]][peça_atual.getPontos().get(0)[1]] = 9;
                            referencia[peça_atual.getPontos().get(1)[0]][peça_atual.getPontos().get(1)[1]] = 9;
                            referencia[peça_atual.getPontos().get(2)[0]][peça_atual.getPontos().get(2)[1]] = 9;
                            referencia[peça_atual.getPontos().get(3)[0]][peça_atual.getPontos().get(3)[1]] = 9;

                            Log.i("Referencia", "eixo x " + referencia[peça_atual.getPontos().get(0)[0]] + " eixo y " + referencia[peça_atual.getPontos().get(0)[1]]);
                            Log.i("Referencia", "eixo x " + referencia[peça_atual.getPontos().get(1)[0]] + " eixo y " + referencia[peça_atual.getPontos().get(1)[1]]);
                            Log.i("Referencia", "eixo x " + referencia[peça_atual.getPontos().get(2)[0]] + " eixo y " + referencia[peça_atual.getPontos().get(2)[1]]);
                            Log.i("Referencia", "eixo x " + referencia[peça_atual.getPontos().get(3)[0]] + " eixo y " + referencia[peça_atual.getPontos().get(3)[1]]);


                            for(int i = 1; i < EIXO_X - 1; i++){
                                for(int j = 1; j < EIXO_Y - 1; j++){
                                    if(referencia[i][j] != 0){
                                        borda[i][j].setImageResource(R.drawable.blocograyp);
                                    }else{
                                        borda[i][j].setImageResource(R.drawable.blocoblackp);
                                    }
                                }
                            }

                            referencia[peça_atual.getPontos().get(0)[0]][peça_atual.getPontos().get(0)[1]] = 0;
                            referencia[peça_atual.getPontos().get(1)[0]][peça_atual.getPontos().get(1)[1]] = 0;
                            referencia[peça_atual.getPontos().get(2)[0]][peça_atual.getPontos().get(2)[1]] = 0;
                            referencia[peça_atual.getPontos().get(3)[0]][peça_atual.getPontos().get(3)[1]] = 0;

                            cont++;
                            /*if(peça_atual instanceof Peca_7) {
                                referencia[peça_atual.getPontos().get(0)[0] - 1][peça_atual.getPontos().get(0)[1]] = 0;
                                referencia[peça_atual.getPontos().get(1)[0] - 1][peça_atual.getPontos().get(1)[1]] = 0;
                            }else if(peça_atual instanceof Peca_4){
                                referencia[peça_atual.getPontos().get(0)[0] - 1][peça_atual.getPontos().get(0)[1]] = 0;
                                referencia[peça_atual.getPontos().get(1)[0] - 1][peça_atual.getPontos().get(1)[1]] = 0;
                                referencia[peça_atual.getPontos().get(2)[0] - 1][peça_atual.getPontos().get(1)[1]] = 0;
                            }else if (peça_atual instanceof Peca_3){
                                referencia[peça_atual.getPontos().get(0)[0] - 1][peça_atual.getPontos().get(0)[1]] = 0;
                            }else if(peça_atual instanceof  Peca_6 ){
                                referencia[peça_atual.getPontos().get(0)[0] -1][peça_atual.getPontos().get(0)[1]] = 0;
                                referencia[peça_atual.getPontos().get(1)[0] -1][peça_atual.getPontos().get(1)[1]] = 0;
                                referencia[peça_atual.getPontos().get(3)[0] -1][peça_atual.getPontos().get(3)[1]] = 0;
                            }else if(peça_atual instanceof Peca_5){
                                referencia[peça_atual.getPontos().get(0)[0] - 1][peça_atual.getPontos().get(0)[1]] = 0;
                                referencia[peça_atual.getPontos().get(1)[0] - 1][peça_atual.getPontos().get(1)[1]] = 0;
                            }else if(peça_atual instanceof Peca_2 ){
                                referencia[peça_atual.getPontos().get(0)[0] - 1][peça_atual.getPontos().get(0)[1]] = 0;
                                referencia[peça_atual.getPontos().get(2)[0] - 1][peça_atual.getPontos().get(2)[1]] = 0;
                            }else{
                                referencia[peça_atual.getPontos().get(0)[0] - 1][peça_atual.getPontos().get(0)[1]] = 0;
                                referencia[peça_atual.getPontos().get(1)[0] - 1][peça_atual.getPontos().get(1)[1]] = 0;
                                referencia[peça_atual.getPontos().get(3)[0] - 1][peça_atual.getPontos().get(3)[1]] = 0;
                            }*/

                                if (cont == 32) {
                                 nova_peça = true;
                                 numero = 0;
                                 repete = false;
                            }
                        }
                    });
                }
            }
        }).start();
    }

    public boolean isRepete() {
        return repete;
    }

    public void setRepete(boolean repete) {
        this.repete = repete;
    }
}

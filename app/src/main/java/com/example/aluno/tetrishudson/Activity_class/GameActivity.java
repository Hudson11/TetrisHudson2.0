package com.example.aluno.tetrishudson.Activity_class;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageButton;
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

    ImageView[][] borda;
    ImageView[][] proxima_peça;

    int[][] referencia;

    GridLayout layout;
    GridLayout layout_prox;

    //Configuração Padrão, vale caso seja instalado do 0 e o usuário ainda não tem configurado as dificuldades do jogo.
    int velocidade = 400, nivel = 4;

    //CRIANDO A CLASSE PARA SALVAR O ESTADO DA APLICAÇÂO
    public static class viewModel extends ViewModel{
        int[][] fundo = new int[EIXO_X][EIXO_Y];
        Pecas peça_atual;
        Handler handle = new Handler();
        boolean repete = true;
        TextView pontos;
        ImageView imagem;
    }

    viewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        viewModel = ViewModelProviders.of(this).get(viewModel.class);

        //Recebe informações de Configurações selecionadas em ConfigActivity
        SharedPreferences prefs = getSharedPreferences("PREFS_NAME", MODE_PRIVATE);
        velocidade = prefs.getInt("velocidade", 1);
        nivel = prefs.getInt("nivel", 2);

        //matriz de referências
        referencia = new int[EIXO_X][EIXO_Y];

        //matriz para referencia das peças do fundo
        //fundo = new int[EIXO_X][EIXO_Y];

        //Matriz de Imagem
        //Tabuleiro
        borda = new ImageView[EIXO_X][EIXO_Y];
        proxima_peça = new ImageView[4][4];

        layout = findViewById(R.id.gridBoard);
        layout_prox = findViewById(R.id.grid);

        //Set linhas e colunas
        layout.setRowCount(EIXO_X);
        layout.setColumnCount(EIXO_Y);
        layout_prox.setRowCount(4);
        layout_prox.setColumnCount(4);

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
                }else{
                    referencia[x][y] = -1;
                    viewModel.fundo[x][y] = -1;
                }
                //Adicionando ao Grid Layout o conteúdo no tabuleiro de imagens na posição X,Y.
                layout.addView(borda[x][y]);
            }
        }

       for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                proxima_peça[i][j] = (ImageView) inflater.inflate(R.layout.inflate_image_black, layout_prox, false);
                layout_prox.addView(proxima_peça[i][j]);
            }
       }

        Movimenta();
    }

    //******************************************************
    //******************************************************
    //******************************************************
    int atual_number, radom;


    public void Movimenta () {

        new Thread(new Runnable() {
            @Override
            public void run() {

                viewModel.repete = true;


                while(viewModel.repete){
                    try{
                        Thread.sleep(velocidade);
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }

                    viewModel.handle.post(new Runnable() {
                        @Override
                        public void run() {
                            if(nova_peça == true) {

                                atual_number = createRadom_Peça();
                                radom = createRadom_Peça();

                                if (atual_number == 0) {
                                    viewModel.peça_atual = new Peca_1();
                                } else if (atual_number == 1) {
                                    viewModel.peça_atual = new Peca_2();
                                } else if (atual_number == 2) {
                                    viewModel.peça_atual = new Peca_3();
                                } else if (atual_number == 3) {
                                    viewModel.peça_atual = new Peca_4();
                                } else if (atual_number == 4) {
                                    viewModel.peça_atual = new Peca_5();
                                } else if (atual_number == 5) {
                                    viewModel.peça_atual = new Peca_6();
                                } else {
                                    viewModel.peça_atual = new Peca_7();
                                }

                                nova_peça = false;
                            }

                            viewModel.peça_atual.getPontos().get(0)[0] += 1;
                            viewModel.peça_atual.getPontos().get(1)[0] += 1;
                            viewModel.peça_atual.getPontos().get(2)[0] += 1;
                            viewModel.peça_atual.getPontos().get(3)[0] += 1;

                            referencia[viewModel.peça_atual.getPontos().get(0)[0]][viewModel.peça_atual.getPontos().get(0)[1]] = 9;
                            referencia[viewModel.peça_atual.getPontos().get(1)[0]][viewModel.peça_atual.getPontos().get(1)[1]] = 9;
                            referencia[viewModel.peça_atual.getPontos().get(2)[0]][viewModel.peça_atual.getPontos().get(2)[1]] = 9;
                            referencia[viewModel.peça_atual.getPontos().get(3)[0]][viewModel.peça_atual.getPontos().get(3)[1]] = 9;

                            for(int i = 1; i < EIXO_X - 1; i++){
                                for(int j = 1; j < EIXO_Y - 1; j++){

                                    if(referencia[i][j] != 9 && viewModel.fundo[i][j] == -1){
                                        borda[i][j].setImageResource(R.drawable.blocoblackp);
                                    }else{
                                        if(radom == 0)
                                            borda[i][j].setImageResource(R.drawable.bloco_amarelo);
                                        else if(radom == 1)
                                            borda[i][j].setImageResource(R.drawable.bloco_azul);
                                        else if(radom == 2)
                                            borda[i][j].setImageResource(R.drawable.bloco_azul_claro);
                                        else if(radom == 3)
                                            borda[i][j].setImageResource(R.drawable.bloco_laranja);
                                        else if(radom == 4)
                                            borda[i][j].setImageResource(R.drawable.bloco_red);
                                        else if(radom == 5)
                                            borda[i][j].setImageResource(R.drawable.bloco_roxo);
                                        else
                                            borda[i][j].setImageResource(R.drawable.bloco_verde);
                                    }
                                }
                            }

                            referencia[viewModel.peça_atual.getPontos().get(0)[0]][viewModel.peça_atual.getPontos().get(0)[1]] = 0;
                            referencia[viewModel.peça_atual.getPontos().get(1)[0]][viewModel.peça_atual.getPontos().get(1)[1]] = 0;
                            referencia[viewModel.peça_atual.getPontos().get(2)[0]][viewModel.peça_atual.getPontos().get(2)[1]] = 0;
                            referencia[viewModel.peça_atual.getPontos().get(3)[0]][viewModel.peça_atual.getPontos().get(3)[1]] = 0;

                            if (referencia[viewModel.peça_atual.getPontos().get(3)[0] + 1][viewModel.peça_atual.getPontos().get(3)[1]] == 1
                            || viewModel.fundo[viewModel.peça_atual.getPontos().get(3)[0]+ 1][viewModel.peça_atual.getPontos().get(3)[1]] != -1
                            || viewModel.fundo[viewModel.peça_atual.getPontos().get(2)[0]+ 1][viewModel.peça_atual.getPontos().get(2)[1]] != -1
                            || viewModel.fundo[viewModel.peça_atual.getPontos().get(1)[0]+ 1][viewModel.peça_atual.getPontos().get(1)[1]] != -1
                            || viewModel.fundo[viewModel.peça_atual.getPontos().get(0)[0]+ 1][viewModel.peça_atual.getPontos().get(0)[1]] != -1){

                                if(referencia[viewModel.peça_atual.getPontos().get(3)[0] - 1][viewModel.peça_atual.getPontos().get(3)[1]] == 1
                                || referencia[viewModel.peça_atual.getPontos().get(2)[0] - 1][viewModel.peça_atual.getPontos().get(2)[1]] == 1
                                || referencia[viewModel.peça_atual.getPontos().get(1)[0] - 1][viewModel.peça_atual.getPontos().get(1)[1]] == 1
                                || referencia[viewModel.peça_atual.getPontos().get(0)[0] - 1][viewModel.peça_atual.getPontos().get(0)[1]] == 1){
                                    Intent intent = new Intent(GameActivity.this, ResultActivity.class);
                                    startActivity(intent);
                                    viewModel.repete = false;
                                }

                                nova_peça = true;

                                viewModel.fundo[viewModel.peça_atual.getPontos().get(0)[0]][viewModel.peça_atual.getPontos().get(0)[1]] = radom;
                                viewModel.fundo[viewModel.peça_atual.getPontos().get(1)[0]][viewModel.peça_atual.getPontos().get(1)[1]] = radom;
                                viewModel.fundo[viewModel.peça_atual.getPontos().get(2)[0]][viewModel.peça_atual.getPontos().get(2)[1]] = radom;
                                viewModel.fundo[viewModel.peça_atual.getPontos().get(3)[0]][viewModel.peça_atual.getPontos().get(3)[1]] = radom;
                            }
                        }
                    });
                }
            }
        }).start();
    }

    public int createRadom_Peça () {
        Random r = new Random();
        int aleatorio = r.nextInt(nivel);
        Log.i("random", "Número random: " + aleatorio);
        return aleatorio;
    }


    public void peça_left(View v){
        ImageButton button = findViewById(R.id.imageButton);

        if(referencia[viewModel.peça_atual.getPontos().get(0)[0]][viewModel.peça_atual.getPontos().get(0)[1] - 1] == 1
        || referencia[viewModel.peça_atual.getPontos().get(1)[0]][viewModel.peça_atual.getPontos().get(1)[1] - 1] == 1
        || referencia[viewModel.peça_atual.getPontos().get(2)[0]][viewModel.peça_atual.getPontos().get(2)[1] - 1] == 1
        || referencia[viewModel.peça_atual.getPontos().get(3)[0]][viewModel.peça_atual.getPontos().get(3)[1] - 1] == 1){
            return;
        }

        viewModel.peça_atual.left();
        return;
    }

    public void peça_right(View v){
        ImageButton button = findViewById(R.id.imageButton2);

        if(referencia[viewModel.peça_atual.getPontos().get(0)[0]][viewModel.peça_atual.getPontos().get(0)[1] + 1] == 1
        || referencia[viewModel.peça_atual.getPontos().get(1)[0]][viewModel.peça_atual.getPontos().get(1)[1] + 1] == 1
        || referencia[viewModel.peça_atual.getPontos().get(2)[0]][viewModel.peça_atual.getPontos().get(2)[1] + 1] == 1
        || referencia[viewModel.peça_atual.getPontos().get(3)[0]][viewModel.peça_atual.getPontos().get(3)[1] + 1] == 1){
            return;
        }
        viewModel.peça_atual.right();
        return;
    }

    public void peça_rotate(View v){
        ImageButton button = findViewById(R.id.imageButton3);
        viewModel.peça_atual.rotate();
        return;
    }

    public void movimenta_baixo(View v){
        ImageButton button = findViewById(R.id.imageButton4);

        if(referencia[viewModel.peça_atual.getPontos().get(0)[0] + 1][viewModel.peça_atual.getPontos().get(0)[1]] == 1
        || referencia[viewModel.peça_atual.getPontos().get(1)[0] + 1][viewModel.peça_atual.getPontos().get(1)[1]] == 1
        || referencia[viewModel.peça_atual.getPontos().get(2)[0] + 1][viewModel.peça_atual.getPontos().get(2)[1]] == 1
        || referencia[viewModel.peça_atual.getPontos().get(3)[0] + 1][viewModel.peça_atual.getPontos().get(3)[1]] == 1){
            return;
        }

        viewModel.peça_atual.Movimenta_baixo();
        return;
    }

    @Override
    public void onStop(){
        super.onStop();


    }
}

package com.example.aluno.tetrishudson;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class GameActivity extends AppCompatActivity {

    static final int EIXO_X = 30;
    static final int EIXO_Y = 46;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
    }

    int tabuleiro[][];
    int pontuacao;

}

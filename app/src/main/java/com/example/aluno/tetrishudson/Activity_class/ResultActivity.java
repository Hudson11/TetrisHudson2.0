package com.example.aluno.tetrishudson.Activity_class;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.aluno.tetrishudson.R;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
    }

    public void IniciarNovoGame(View v){
        Intent intent = new Intent(ResultActivity.this, GameActivity.class);
        startActivity(intent);
        finish();
    }

    public void sair(View v){
        finish();
    }

}

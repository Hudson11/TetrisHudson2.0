package com.example.aluno.tetrishudson.Activity_class;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.aluno.tetrishudson.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void settings(View v){
        Intent intent = new Intent(MainActivity.this, ConfigActivity.class);
        startActivity(intent);
        finish();
    }

    public void IniciarGame(View v){
        Intent intent = new Intent(MainActivity.this, GameActivity.class);
        startActivity(intent);
        finish();
    }

}

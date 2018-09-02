package com.example.aluno.tetrishudson.Activity_class;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.aluno.tetrishudson.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int pausa = getIntent().getIntExtra("PAUSAR", 0);
        Log.i("TESTTE","teste: "+ pausa);

        if(pausa == 1) {
            View button = findViewById(R.id.button5);
            int i = 0;
            button.setVisibility(i);
        }
    }

    public void settings(View v){
        Intent intent = new Intent(MainActivity.this, ConfigActivity.class);
        startActivity(intent);
    }

    public void IniciarGame(View v){
        Intent intent = new Intent(MainActivity.this, GameActivity.class);
        startActivity(intent);
    }
}

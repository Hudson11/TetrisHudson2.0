package com.example.aluno.tetrishudson.Activity_class;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.aluno.tetrishudson.R;

public class ResultActivity extends AppCompatActivity {

    int rc, cr = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        rc = getIntent().getIntExtra("pontos", 0);
        //Log.i("pontos",""+record);
        TextView pontos = findViewById(R.id.text);
        TextView record = findViewById(R.id.record);
        TextView info = findViewById(R.id.textView5);

        pontos.setText(""+ rc);
        //record.setText(""+ cr);
        if(rc > cr){
            int i = 0;
            info.setVisibility(i);
            cr = rc;
            record.setText(""+ cr);
        }
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

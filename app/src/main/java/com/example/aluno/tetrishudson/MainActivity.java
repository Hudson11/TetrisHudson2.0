package com.example.aluno.tetrishudson;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    //Bundle bundle = new Bundle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void settings(View v){
        Intent intent = new Intent(MainActivity.this, ConfigActivity.class);
        //startActivityForResult(intent, 1);
        startActivity(intent);
    }

    public void IniciarGame(View v){
        Intent intent = new Intent(MainActivity.this, GameActivity.class);
        //intent.putExtras(bundle);
        startActivity(intent);
    }

   /* @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        bundle = data.getExtras();
        Log.i("MAIN", "velocidade: " + bundle.getInt("velocidade") + " nivel: " + bundle.get("nivel"));
    }*/
}

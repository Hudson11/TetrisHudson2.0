package com.example.aluno.tetrishudson;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class ConfigActivity extends AppCompatActivity {

    int selecionado_radio = 0;
    int selecionado_radio1 = 0;

    Bundle bd = new Bundle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        RadioGroup g = findViewById(R.id.radioGroup);
        RadioGroup v = findViewById(R.id.radioGroup1);

        int i = getSelecionado_radio();
        int j = getSelecionado_radio1();

        int selecionado = prefs.getInt("selecionado",i);
        int selecionado1 = prefs.getInt("selecionado1", j);

        if(selecionado == R.id.radioButton1){
            g.check(R.id.radioButton1);
        }else if (selecionado == R.id.radioButton2){
            g.check(R.id.radioButton2);
        }else if (selecionado == R.id.radioButton3){
            g.check(R.id.radioButton3);
        }else if (selecionado == R.id.radioButton4){
            g.check(R.id.radioButton4);
        }else if (selecionado == R.id.radioButton5){
            g.check(R.id.radioButton5);
        }else {
            g.check(R.id.radioButton6);
        }

        if(selecionado1 == R.id.radioButton7){
            v.check(R.id.radioButton7);
        }else if (selecionado1 == R.id.radioButton8){
            v.check(R.id.radioButton8);
        }else {
            v.check(R.id.radioButton9);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();

        RadioGroup g = findViewById(R.id.radioGroup);
        RadioGroup v = findViewById(R.id.radioGroup1);

        //De Inicio precisamos saber quais dos radioButtons de peças foi marcado.
        /*Adicionamos todas as informações através de um Bundle que sera adicionado a Intent que será
            Responsável por levar as informaçoes de configuração até a ConfigActivity.
        */
        if(g.getCheckedRadioButtonId() == R.id.radioButton1){
            selecionado_radio = g.getCheckedRadioButtonId();
            bd.putInt("nivel", 2);
        }else if (g.getCheckedRadioButtonId() == R.id.radioButton2){
            selecionado_radio = g.getCheckedRadioButtonId();
            bd.putInt("nivel", 3);
        }else if (g.getCheckedRadioButtonId() == R.id.radioButton3){
            selecionado_radio = g.getCheckedRadioButtonId();
            bd.putInt("nivel", 4);
        }else if (g.getCheckedRadioButtonId() == R.id.radioButton4){
            selecionado_radio = g.getCheckedRadioButtonId();
            bd.putInt("nivel", 5);
        }else if (g.getCheckedRadioButtonId() == R.id.radioButton5){
            selecionado_radio = g.getCheckedRadioButtonId();
            bd.putInt("nivel", 6);
        }else {
            selecionado_radio = g.getCheckedRadioButtonId();
            bd.putInt("nivel", 7);
        }

        //O mesmo acontece aqui, só q para velocidade
        if(v.getCheckedRadioButtonId() == R.id.radioButton7){
            selecionado_radio1 = v.getCheckedRadioButtonId();
            bd.putInt("velocidade", 400);
        }else if (v.getCheckedRadioButtonId() == R.id.radioButton8){
            selecionado_radio1 = v.getCheckedRadioButtonId();
            bd.putInt("velocidade", 700);
        }else {
            selecionado_radio1 = v.getCheckedRadioButtonId();
            bd.putInt("velocidade", 1000);
        }

        Intent intent = new Intent(ConfigActivity.this, GameActivity.class);
        intent.putExtra("configs", bd);

        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        editor.putBoolean("salvar", true);
        editor.putInt("selecionado", selecionado_radio);
        editor.putInt("selecionado1", selecionado_radio1);
        editor.commit();
    }

    public int getSelecionado_radio(){
        return this.selecionado_radio;
    }

    public int getSelecionado_radio1(){
       return this.selecionado_radio1;
    }
}

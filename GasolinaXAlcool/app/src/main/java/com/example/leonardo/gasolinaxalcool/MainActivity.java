package com.example.leonardo.gasolinaxalcool;

import android.icu.text.DecimalFormat;
import android.os.Build;
import android.support.annotation.FloatRange;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    public void calcular(View v) {

        EditText gas = (EditText) findViewById(R.id.etGas);
        EditText al = (EditText) findViewById(R.id.etAlc);
        DecimalFormat df = new DecimalFormat("0.0");
        float res;
        float num1 = Float.parseFloat(gas.getText().toString());
        float num2 = Float.parseFloat(al.getText().toString());
        AlertDialog.Builder janela = new AlertDialog.Builder(MainActivity.this);

        res = num1 / num2;

        if (res < 0.7) {
            janela.setTitle("ÁLCOOL");
            janela.setMessage( df.format((num2*100)/num1) + "% é o valor do alcool em relação à gasolina");
            janela.setNeutralButton("OK", null);
            janela.show();
        } else {
            janela.setTitle("GASOLINA");
            janela.setMessage(df.format((num2*100)/num1) + "0.% é o valor da gasolina em relação ao alcool");
            janela.setNeutralButton("OK", null);
            janela.show();

        }
    }

}

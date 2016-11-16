package com.example.aluno.imc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnIMC = (Button) findViewById(R.id.BtnIMC);

        btnIMC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText altura_ = (EditText) findViewById(R.id.altura);
                EditText peso_ = (EditText) findViewById(R.id.peso);
                double altura = 0;
                double peso = 0;
                try {
                    altura = Double.parseDouble(altura_.getText().toString());
                }catch(Exception e){
                    Toast.makeText(getBaseContext(),"Altura inválida",Toast.LENGTH_LONG);
                }

                try {
                    peso = Double.parseDouble(peso_.getText().toString());
                }catch (Exception e){
                    Toast.makeText(getBaseContext(),"Peso invalido",Toast.LENGTH_LONG);

                }

                 double resultado = peso / (altura * altura);

                String resultadoPeso = "";

                if (resultado < 18.6){

                     resultadoPeso = "abaixo do peso";

                }

                if (resultado >= 18.6 && resultado < 24.9  ){
                    resultadoPeso = "peso ideal";
                }

                if (resultado >= 25.0 && resultado < 29.9){
                    resultadoPeso = "Levemente acima do peso";

                }

                if (resultado >= 30.0 && resultado < 34.9){
                    resultadoPeso = "Obesidade grau 1";
                }

                if (resultado >= 35.0 && resultado < 39.9 ){
                    resultadoPeso = "Obesidade grau 2 (severa)";
                }

                if (resultado >= 40){
                    resultadoPeso = "Obesidade grau 3 (mórbida)";
                }

                Toast.makeText(getBaseContext(),resultadoPeso,Toast.LENGTH_LONG).show();


            }

        });


    }

}

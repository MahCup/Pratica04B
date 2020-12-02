package com.example.tela2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    private Button calcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //instanciando
        calcular = findViewById(R.id.btnTela2);

    }

    public void calculaEvolta(View view) {
        //buscando o conteúdo da outra tela
        Intent it = getIntent();
        Bundle params = it.getExtras();
        Double taxa;
        String sex = params.getString("sexo");
        String jejum = params.getString("jejum");
        if(jejum.equals("s")) {
            if (sex.equals("f")) {
                taxa = (4.8 * params.getDouble("nCopos")) / (params.getDouble("peso") * 0.6);
            } else {
                taxa = (4.8 * params.getDouble("nCopos")) / (params.getDouble("peso") * 0.7);
            }
        } else {
            taxa = (4.8 * params.getDouble("nCopos")) / (params.getDouble("peso") * 1.1);
        }

        String mensagem;
        if(taxa <= 0.2) {
            mensagem = "Taxa de Alcoolemia: " + taxa + "\nClassificação: Pessoa NÃO alcoolizada";
        } else {
            mensagem = "Taxa de Alcoolemia: " + taxa + "\nClassificação: Pessoa alcoolizada";
        }

        Intent it2 = new Intent();
        it2.putExtra("mensagem", mensagem);
        setResult(RESULT_OK, it2);
        finish();
    }
}
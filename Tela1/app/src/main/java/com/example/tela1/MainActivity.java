package com.example.tela1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private final int REQUEST_CODE = 1;
    private Button enviarDados;
    private EditText peso, sexo, nCopos, jejum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //instanciando os widgets
        enviarDados = findViewById(R.id.enviarDados);
        peso = findViewById(R.id.pesoInput);
        sexo = findViewById(R.id.sexoInput);
        nCopos = findViewById(R.id.nCoposInput);
        jejum = findViewById(R.id.jejumInput);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        System.out.println("entrei aqui");
        // Verfica se o requestCode é o mesmo que foi passado
        if(requestCode==1 && resultCode == RESULT_OK)
        {
            String message = data.getStringExtra("mensagem");

            Toast toast = Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG);
            toast.show();
        }
    }

    public void clickEnviarDados (View view) {
        Double weight = Double.parseDouble(peso.getText().toString().trim());
        String sex = sexo.getText().toString();
        Double nCups = Double.parseDouble(nCopos.getText().toString().trim());
        String fasting = jejum.getText().toString();

        Intent it = new Intent("SUPER_UNIQUE_INTENT_ID");
        Bundle params = new Bundle();
        params.putDouble("peso", weight);
        params.putString("sexo", sex);
        params.putDouble("nCopos", nCups);
        params.putString("jejum", fasting);

        it.putExtras(params);
        startActivityForResult(it, REQUEST_CODE);

    }
}
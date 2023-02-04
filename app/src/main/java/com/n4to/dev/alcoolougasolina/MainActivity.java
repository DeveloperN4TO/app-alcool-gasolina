package com.n4to.dev.alcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText editPrecoAlcool, editPrecoGasolina;
    private TextView textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editPrecoAlcool = findViewById(R.id.editprecoAlcool);
        editPrecoGasolina = findViewById(R.id.editprecoGasolina);
        textResultado = findViewById(R.id.textResultado);

    }

    public void calcularPreco(View view) {
        // recuperar valor digitado

        String precoAlcool = editPrecoAlcool.getText().toString();
        String precoGasolina = editPrecoGasolina.getText().toString();

        //Validar os campos digitados

        boolean camposValidados = validarCampos(precoAlcool, precoGasolina);
        if (camposValidados) {
            // convertendo string para números
            double valorAlcool = Double.parseDouble(precoAlcool);
            double valorGasolina = Double.parseDouble(precoGasolina);

            // calcula o rendimento do álcool em relação à gasolina
            double rendimentoCombustivel = valorAlcool / valorGasolina;

            // exibe ao usuário qual é a melhor opção de acordo com o rendimento
            if (rendimentoCombustivel < 0.7) {
                textResultado.setText("Álcool é a melhor opção");
            } else {
                textResultado.setText("Gasolina é a melhor opção");
            }
        } else {
            textResultado.setText("Preencha os preços primeiro!");
        }
    }

    //Validar os campos digitados

    public boolean validarCampos(String pAlcool, String pGasolina) {


        boolean camposValidados = true;
        String campo = "Preenchido";

        if (pAlcool == null || pAlcool.equals("")) {
            camposValidados = false;


        } else if (pGasolina == null || pGasolina.equals("")) {
            camposValidados = false;

        }
        return camposValidados;
    }
}
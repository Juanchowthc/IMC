package com.example.imc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {

    private EditText pesoEditText, estaturaEditText;
    private RadioGroup generoRadioGroup;
    private Button calcularButton;
    private TextView resultadoTextView;
    RadioGroup radioGroup;
    RadioButton radioButtonMale;
    RadioButton radioButtonFemale;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pesoEditText = findViewById(R.id.Peso);
        estaturaEditText = findViewById(R.id.Estatura);
        generoRadioGroup = findViewById(R.id.radioGroup);
        calcularButton = findViewById(R.id.button);
        resultadoTextView = findViewById(R.id.text001);

        calcularButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularIMC();
            }
        });
    }

    private void calcularIMC() {
        double peso = Double.parseDouble(pesoEditText.getText().toString());
        double estatura = Double.parseDouble(estaturaEditText.getText().toString());
        int generoId = generoRadioGroup.getCheckedRadioButtonId();
        RadioButton generoRadioButton = findViewById(generoId);

        double imc = peso / (estatura * estatura);

        String resultado;

        if (generoRadioButton.getText().toString().equals("Masculino")) {
            if (imc < 20.7) {
                resultado = "Bajo peso";
            } else if (imc < 26.4) {
                resultado = "Peso normal";
            } else if (imc < 27.8) {
                resultado = "Sobrepeso";
            } else if (imc < 31.1) {
                resultado = "Obesidad grado I";
            } else if (imc < 34.9) {
                resultado = "Obesidad grado II";
            } else {
                resultado = "Obesidad grado III";
            }
        } else {
            if (imc < 19.1) {
                resultado = "Bajo peso";
            } else if (imc < 25.8) {
                resultado = "Peso normal";
            } else if (imc < 27.3) {
                resultado = "Sobrepeso";
            } else if (imc < 32.3) {
                resultado = "Obesidad grado I";
            } else if (imc < 37.4) {
                resultado = "Obesidad grado II";
            } else {
                resultado = "Obesidad grado III";
            }
        }

        resultadoTextView.setText("Tu IMC es: " + String.format("%.2f", imc) + "\n" + resultado);
    }
}
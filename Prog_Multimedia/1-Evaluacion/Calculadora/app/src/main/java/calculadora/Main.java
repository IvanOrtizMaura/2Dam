//package com.example.calculadora;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.TextView;
//
//public class MainActivity extends AppCompatActivity {
//
//    private Button btn_suma, btn_resta, btn_division, btn_multiplicaciones;
//    private TextView respuesta;
//    private EditText edit_numero1,edit_numero2;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        respuesta = findViewById(R.id.respuesta);
//
//        edit_numero1 = findViewById(R.id.numero1);
//        edit_numero2 = findViewById(R.id.numero2);
//
//
//        btn_suma = findViewById(R.id.button_suma);
//        btn_suma.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                respuesta.setText(suma(Integer.parseInt(edit_numero1.getText().toString()), Integer.parseInt(edit_numero2.getText().toString())) + "");
//            }
//        });
//
//
//        btn_resta = findViewById(R.id.button_resta);
//        btn_resta.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                respuesta.setText(resta(Integer.parseInt(edit_numero1.getText().toString()), Integer.parseInt(edit_numero2.getText().toString())) + "");
//            }
//        });
//
//
//        btn_multiplicaciones = findViewById(R.id.button_multiplicacion);
//        btn_multiplicaciones.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                respuesta.setText(multiplicacion(Integer.parseInt(edit_numero1.getText().toString()), Integer.parseInt(edit_numero2.getText().toString())) + "");
//            }
//        });
//
//
//        btn_division = findViewById(R.id.button_divisiones);
//        btn_division.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                respuesta.setText(division(Integer.parseInt(edit_numero1.getText().toString()), Integer.parseInt(edit_numero2.getText().toString())) + "");
//            }
//        });
//
//
//    }
//
//    private int suma(int a, int b){
//        return a + b;
//    }
//    private int resta(int a, int b){
//        return a - b;
//    }
//    private int multiplicacion(int a, int b){
//        return a * b;
//    }
//    private int division(int a, int b){
//        return a / b;
//
//    }
//
//}
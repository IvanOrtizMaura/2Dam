package es.cide.examen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class Pantalla2 extends AppCompatActivity {
    TextView numero;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);
        Bundle datos = getIntent().getExtras();

        numero = findViewById(R.id.lblPantalla2);
        numero.setText(datos.getString("num"));
        intent = new Intent(this,MainActivity.class);

    }
    public  void  calcular (View view){
        int num = Integer.parseInt(numero.getText().toString());
        for (int i = 1; i < num; i++) {
            int result = num % num;
            int result1 = num%1;
            if(result == 0 && result1 == 0){
                intent.putExtra("texte2","Ve de pantalla 2, Par SI");
                setResult(Pantalla2.RESULT_OK,intent);
                finish();
            }else{
                intent.putExtra("texte3","Ve de pantalla 2, Par NO");
                setResult(Pantalla2.RESULT_FIRST_USER,intent);
                finish();
            }
        }
    }
    public void cancelar (View view){
        setResult(Pantalla2.RESULT_CANCELED,intent);
        finish();
    }
    public void onBackPressed(){
        EditText txt = findViewById(R.id.txt);
        String linea = txt.getText().toString();
        intent.putExtra("back",linea);
        setResult(2,intent);
        super.onBackPressed();
    }
}
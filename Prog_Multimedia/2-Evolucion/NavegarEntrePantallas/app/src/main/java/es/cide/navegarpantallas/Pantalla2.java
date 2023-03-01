package es.cide.navegarpantallas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Pantalla2 extends AppCompatActivity {
    TextView tv;
    EditText et;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);
        Bundle datos = getIntent().getExtras();
        tv = (TextView) findViewById(R.id.);
        tv.setText(datos.getString("num"));
        et = (EditText) findViewById(R.id.editTextTextPersonName);
        intent = new Intent(this,MainActivity.class);
    }

    public void  aceptar (View view){
        intent.putExtra("text2",et.getText().toString());
        setResult(Pantalla2.RESULT_OK,intent);
        finish();
    }
    public void  cancelar(View view){
        setResult(Pantalla2.RESULT_CANCELED,intent);
        finish();
    }
    @Override
    public void  onBackPressed(){
        intent.putExtra("text3", "hola");
        setResult(2,intent);
        super.onBackPressed();
    }
}
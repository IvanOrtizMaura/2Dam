package es.cide.navegarpantallas;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText et;
    Toast toast1;
    static final int PETICIO_ACTIVITY_2 = 0002;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et = (EditText) findViewById(R.id.txtField);
        toast1 = Toast.makeText(getApplicationContext(),"",Toast.LENGTH_SHORT);
    }
    public void enviar(View view){
        Intent intent = new Intent(this, Pantalla2.class);
        intent.putExtra("num",et.getText().toString());
        startActivityForResult(intent,PETICIO_ACTIVITY_2);
    }
    @Override
    protected  void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == PETICIO_ACTIVITY_2) {
            if (resultCode == RESULT_OK) {
                toast1.setText(data.getExtras().getString("texte2"));
            } else if (resultCode == RESULT_CANCELED) {
                toast1.setText("Cancel");
            }
        }
        toast1.show();
        super.onActivityResult(requestCode,resultCode, data);

    }
}
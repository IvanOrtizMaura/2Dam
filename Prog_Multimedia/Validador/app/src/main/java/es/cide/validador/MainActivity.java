package es.cide.validador;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText editNombre, editApellidos,editDNI,editTelefono,editMail,editUsuario,
            editContraseña,editContraseña2;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editNombre = findViewById(R.id.editNombre);
        editApellidos = findViewById(R.id.editApellidos);
        editDNI = findViewById(R.id.editDNI);
        editTelefono = findViewById(R.id.editTelefono);
        editMail = findViewById(R.id.editMail);
        editUsuario = findViewById(R.id.editUsuario);
        editContraseña = findViewById(R.id.editConstraseña);
        editContraseña2 = findViewById(R.id.editConstraseña2);


    }
    public void OnClick(View view){

    }
    public boolean validarNombre(){

    }
    
}
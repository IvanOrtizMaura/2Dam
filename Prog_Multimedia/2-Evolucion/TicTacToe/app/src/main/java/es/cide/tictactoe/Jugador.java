package es.cide.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Jugador extends AppCompatActivity {
    private EditText jugador1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jugador);

        jugador1 = findViewById(R.id.txtNombre);
    }

    public void enviarNombres(View view) {
        String nombre1 = jugador1.getText().toString();
        Intent intent = new Intent(this, Juego.class);
        intent.putExtra("nombreJugadores", new String[] {nombre1,"CPU"});
        startActivity(intent);
    }
}
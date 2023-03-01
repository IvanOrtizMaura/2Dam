package es.cide.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Juego extends AppCompatActivity {
    private TicTacToe ticTacToe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.juego);

        Button jugar = findViewById(R.id.btnJugar);
        Button home = findViewById(R.id.btnHome);
        TextView lblNombre = findViewById(R.id.lblNombre);

        jugar.setVisibility(View.GONE);
        home.setVisibility(View.GONE);

        String[]nombreJugadores = getIntent().getStringArrayExtra("nombreJugadores");

        if (nombreJugadores != null){
            lblNombre.setText(nombreJugadores[0]);
        }

        ticTacToe = findViewById(R.id.ticTacToe2);
        ticTacToe.setUpGame(jugar,home,lblNombre,nombreJugadores);
    }

    public void jugatBtn(View view) {
        ticTacToe.resetGame();
        ticTacToe.invalidate();
    }

    public void homeBtn(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
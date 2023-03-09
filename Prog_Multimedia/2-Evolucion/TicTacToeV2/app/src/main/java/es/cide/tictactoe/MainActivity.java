package es.cide.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.gridlayout.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    
    private int [][] posibilidades = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8},
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
            {0, 4, 8}, {2, 4, 6}};;

    private EditText txtNombre;
    private TextView lblTurno,lblContador;
    private RadioGroup gpDificultad;
    private RadioButton rFacil;

    private MediaPlayer mediaPlayer;

    private ImageButton boton0;
    private ImageButton boton1;
    private ImageButton boton2;
    private ImageButton boton3;
    private ImageButton boton4;
    private ImageButton boton5;
    private ImageButton boton6;
    private ImageButton boton7;
    private ImageButton boton8;

    private RadioButton rDificil;
    private String nombreJugador ;
    private ImageButton [] botones;
    private Button jugarBtn;
    private GridLayout gl;
    private int [] estadoImageButton = {2,2,2,2,2,2,2,2,2};
    private int jugador = 0;
    private boolean partidaActiva = false;
    private  int trunos = 0;
    private int contadorJugador = 0;
    private int contadorCPU = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNombre = findViewById(R.id.editTextTextPersonName);
        gpDificultad = findViewById(R.id.radioDificultad);
        lblTurno = findViewById(R.id.lblTurno);
        lblContador = findViewById(R.id.lblContador);
        rFacil = findViewById(R.id.radioFacil);
        rDificil = findViewById(R.id.radioDificil);
        jugarBtn = findViewById(R.id.btnJugar);
         boton0 = findViewById(R.id.imageButton);
         boton1 = findViewById(R.id.imageButton2);
         boton2 = findViewById(R.id.imageButton3);
         boton3 = findViewById(R.id.imageButton4);
         boton4 = findViewById(R.id.imageButton5);
         boton5 = findViewById(R.id.imageButton6);
         boton6 = findViewById(R.id.imageButton7);
         boton7 = findViewById(R.id.imageButton8);
         boton8 = findViewById(R.id.imageButton9);
        botones = new ImageButton[]{boton0, boton1, boton2, boton3, boton4, boton5, boton6, boton7, boton8};


        gl = findViewById(R.id.gridLayout);

    }
    public void reiniciar(View view){
        jugarBtn.setVisibility(View.VISIBLE);
        lblContador.setText("");
        estadoImageButton = new int[] {2,2,2,2,2,2,2,2,2};
        jugador = 0;
        trunos = 0;
        contadorJugador = 0;
        contadorCPU = 0;
        // Reiniciar las imágenes de los botones y los colores de fondo
        boton0.setImageResource(0);
        boton1.setImageResource(0);
        boton2.setImageResource(0);
        boton3.setImageResource(0);
        boton4.setImageResource(0);
        boton5.setImageResource(0);
        boton6.setImageResource(0);
        boton7.setImageResource(0);
        boton8.setImageResource(0);
        boton0.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ffffff")));
        boton1.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ffffff")));
        boton2.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ffffff")));
        boton3.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ffffff")));
        boton4.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ffffff")));
        boton5.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ffffff")));
        boton6.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ffffff")));
        boton7.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ffffff")));
        boton8.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ffffff")));
    }
    public void reiniciar(){
        jugarBtn.setVisibility(View.VISIBLE);
        lblContador.setText("");
        estadoImageButton = new int[] {2,2,2,2,2,2,2,2,2};
        jugador = 0;
        trunos = 0;
        contadorJugador = 0;
        contadorCPU = 0;
        // Reiniciar las imágenes de los botones y los colores de fondo
        boton0.setImageResource(0);
        boton1.setImageResource(0);
        boton2.setImageResource(0);
        boton3.setImageResource(0);
        boton4.setImageResource(0);
        boton5.setImageResource(0);
        boton6.setImageResource(0);
        boton7.setImageResource(0);
        boton8.setImageResource(0);
        boton0.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ffffff")));
        boton1.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ffffff")));
        boton2.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ffffff")));
        boton3.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ffffff")));
        boton4.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ffffff")));
        boton5.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ffffff")));
        boton6.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ffffff")));
        boton7.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ffffff")));
        boton8.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ffffff")));
    }
    public void jugar(View view){
        // Reiniciar el estado del juego y el trunos
        estadoImageButton = new int[] {2,2,2,2,2,2,2,2,2};
        jugador = 0;
        trunos = 0;

        // Reiniciar las imágenes de los botones y los colores de fondo
        boton0.setImageResource(0);
        boton1.setImageResource(0);
        boton2.setImageResource(0);
        boton3.setImageResource(0);
        boton4.setImageResource(0);
        boton5.setImageResource(0);
        boton6.setImageResource(0);
        boton7.setImageResource(0);
        boton8.setImageResource(0);
        boton0.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ffffff")));
        boton1.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ffffff")));
        boton2.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ffffff")));
        boton3.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ffffff")));
        boton4.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ffffff")));
        boton5.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ffffff")));
        boton6.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ffffff")));
        boton7.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ffffff")));
        boton8.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ffffff")));

        // Obtener el nombre del jugador y la dificultad del grupo de botones de opciones
        nombreJugador = txtNombre.getText().toString();
        lblContador.setText(nombreJugador+" " + contadorJugador + " vs CPU: " + contadorCPU );

        int dificultad = gpDificultad.getCheckedRadioButtonId();
        System.out.println(dificultad);

        // Validar que se haya ingresado un nombre
        if (nombreJugador.isEmpty()) {
            txtNombre.setError("Ingresa un nombre");
        }

        // Validar que se haya seleccionado una dificultad
        if(dificultad == -1){
            Toast.makeText(MainActivity.this, "Selecciona una dificultad", Toast.LENGTH_SHORT).show();
            return;
        }

        // Iniciar la partida y mostrar el turno del primer jugador
        partidaActiva = true;
        lblTurno.setText("Turno " + nombreJugador + " O");
    }
    public void jugar(){
        // Reiniciar el estado del juego y el trunos
        estadoImageButton = new int[] {2,2,2,2,2,2,2,2,2};
        jugador = 0;
        trunos = 0;

        // Reiniciar las imágenes de los botones y los colores de fondo
        boton0.setImageResource(0);
        boton1.setImageResource(0);
        boton2.setImageResource(0);
        boton3.setImageResource(0);
        boton4.setImageResource(0);
        boton5.setImageResource(0);
        boton6.setImageResource(0);
        boton7.setImageResource(0);
        boton8.setImageResource(0);
        boton0.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ffffff")));
        boton1.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ffffff")));
        boton2.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ffffff")));
        boton3.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ffffff")));
        boton4.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ffffff")));
        boton5.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ffffff")));
        boton6.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ffffff")));
        boton7.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ffffff")));
        boton8.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ffffff")));

        // Obtener el nombre del jugador y la dificultad del grupo de botones de opciones
        nombreJugador = txtNombre.getText().toString();
        lblContador.setText(nombreJugador+" " + contadorJugador + " vs CPU: " + contadorCPU );

        int dificultad = gpDificultad.getCheckedRadioButtonId();
        System.out.println(dificultad);

        // Validar que se haya ingresado un nombre
        if (nombreJugador.isEmpty()) {
            txtNombre.setError("Ingresa un nombre");
        }

        // Validar que se haya seleccionado una dificultad
        if(dificultad == -1){
            Toast.makeText(MainActivity.this, "Selecciona una dificultad", Toast.LENGTH_SHORT).show();
            return;
        }

        // Iniciar la partida y mostrar el turno del primer jugador
        partidaActiva = true;
        lblTurno.setText("Turno " + nombreJugador + " O");
    }

    public void imageButton(View view) {
        // Ocultar el botón de jugar
        jugarBtn.setVisibility(View.GONE);

        // Si es el turno del jugador 2, no hacer nada
        if (jugador == 1) {
            return;
        }

        // Si la partida no está activa, no hacer nada
        if (!partidaActiva) {
            return;
        }

        // Obtener el botón que se ha pulsado
        ImageButton boton = (ImageButton) view;

        // Obtener la casilla que representa el botón
        int casilla = Integer.parseInt(boton.getTag().toString());

        // Si la casilla ya ha sido marcada, no hacer nada
        if (estadoImageButton[casilla] != 2) {
            return;
        }

        // Marcar la casilla con el símbolo correspondiente
        estadoImageButton[casilla] = jugador;
        boton.setImageResource(R.drawable.ic_outline_circle_24);

        // Verificar si el jugador actual ha ganado
        if (verificarGanador()) {
            return;
        }

        // Incrementar el trunos de turnos
        trunos++;

        // Cambiar al siguiente jugador
        jugador = 1;

        // Actualizar la etiqueta de turno para indicar que es el turno de la CPU
        lblTurno.setText("Turno CPU  X ");

        // Crear un Handler para retrasar el movimiento de la CPU
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Si se ha seleccionado la dificultad "Fácil"
                if (rFacil.isChecked()) {
                    // Crear una lista de casillas disponibles
                    ArrayList<Integer> casillasDisponibles = new ArrayList<>();
                    for (int i = 0; i < estadoImageButton.length; i++) {
                        if (estadoImageButton[i] == 2) {
                            casillasDisponibles.add(i);
                        }
                    }
                    // Si hay casillas disponibles
                    if (casillasDisponibles.size() != 0) {
                        // Elegir una casilla al azar de entre las disponibles
                        int casillaElegida = casillasDisponibles.get((int) (Math.random() * casillasDisponibles.size()));
                        // Marcar la casilla con el símbolo correspondiente
                        estadoImageButton[casillaElegida] = jugador;
                        ImageButton botonElegido = (ImageButton) gl.getChildAt(casillaElegida);
                        botonElegido.setImageResource(R.drawable.x_cpu);
                        // Actualizar la etiqueta de turno para indicar que es el turno del jugador 1
                        lblTurno.setText("Turno " + nombreJugador + " O");
                        // Verificar si el jugador 1 ha ganado
                        if (verificarGanador()) {
                            return;
                        }
                        // Incrementar el trunos de turnos
                        trunos++;
                        // Cambiar al siguiente jugador
                        jugador = 0;
                    }
                }
                // Si se ha seleccionado la dificultad "Difícil"
                if (rDificil.isChecked()) {
                    // Mostrar el botón de jugar de nuevo
                    jugarBtn.setVisibility(View.VISIBLE);
                }
            }
        }, 1000);

        // Si se han realizado 9 movimientos y no hay ganador, es un empate
        if (trunos == 9) {
            lblTurno.setText("Empate");
            partidaActiva = false;
            boton0.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#0000ff")));
            boton1.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#0000ff")));
            boton2.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#0000ff")));
            boton3.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#0000ff")));
            boton4.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#0000ff")));
            boton5.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#0000ff")));
            boton6.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#0000ff")));
            boton7.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#0000ff")));
            boton8.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#0000ff")));
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    jugar();
                }
            },1000);
        }


    }


    private Boolean verificarGanador() {
        final Handler handler = new Handler();
        for (int[] winPosition : posibilidades) {
            if (estadoImageButton[winPosition[0]] == estadoImageButton[winPosition[1]] &&
                    estadoImageButton[winPosition[1]] == estadoImageButton[winPosition[2]] &&
                    estadoImageButton[winPosition[0]] != 2) {



                partidaActiva = false;
                if (estadoImageButton[winPosition[0]] == 0) {
                    mediaPlayer = MediaPlayer.create(this, R.raw.victoria);
                    mediaPlayer.start();
                   lblTurno.setText("Gana " + nombreJugador);
                   contadorJugador += 1;

                    botones[winPosition[0]].setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#00ff00")));
                    botones[winPosition[1]].setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#00ff00")));
                    botones[winPosition[2]].setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#00ff00")));
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            jugar();
                        }
                    },2000);
                    verificarPartida();
                } else {
                    mediaPlayer = MediaPlayer.create(this,R.raw.abucheo);
                    mediaPlayer.start();
                   lblTurno.setText("Gana CPU");
                   contadorCPU += 1;
                    botones[winPosition[0]].setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ff0000")));
                    botones[winPosition[1]].setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ff0000")));
                    botones[winPosition[2]].setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ff0000")));
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            jugar();
                        }
                    },2000);
                    verificarPartida();

                }



                return true;
            }
        }
        return false;

    }
    public void verificarPartida(){
       int partidas = contadorCPU + contadorJugador;
        int ganadorJugador = contadorJugador - contadorCPU;
        int ganadorCPU = contadorCPU - contadorJugador;
        final Handler handler  = new Handler();
        if (partidas >= 3){
            if (ganadorJugador >= 2){
                lblContador.setText("Ha ganado " + nombreJugador);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        partidaActiva = false;
                        reiniciar();
                    }
                },1500);

            }else if (ganadorCPU >= 2){
                lblContador.setText("Ha ganado CPU");
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        partidaActiva = false;
                        reiniciar();
                    }
                },1500);

            }else{
                return;
            }
        }else{
            return;
        }

    }

}
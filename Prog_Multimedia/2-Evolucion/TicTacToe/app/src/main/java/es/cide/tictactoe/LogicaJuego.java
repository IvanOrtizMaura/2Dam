package es.cide.tictactoe;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LogicaJuego {
    private int [][] platilla;
    private String [] names = {"Jugadro1", "Jugador2"};
    private int  jugador = 1;
    private Button jugarBtn, homeBtn;
    private TextView lblNombre;

    // El constructor crea una matriz vacía de 3x3 que representa el tablero del juego.
    LogicaJuego() {
        platilla = new int[3][3];
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                platilla[r][c] = 0; // inicialmente, todas las celdas están vacías
            }
        }
    }

    // Este método actualiza la matriz de plantilla con el movimiento del jugador actual.
// Devuelve verdadero si la actualización es exitosa, falso si la celda ya está ocupada.
    public boolean actializarPlantilla(int row, int col) {
        // Verifica si la celda está vacía
        if (platilla[row - 1][col - 1] == 0) {
            // actualiza la celda con el número de jugador actual
            platilla[row - 1][col - 1] = jugador;

            if (jugador == 1){
                lblNombre.setText((names[1]+ "turno") );
            }else{
                lblNombre.setText((names[0]+"turno ") );

            }

            return true; // devuelve verdadero si la actualización es exitosa
        } else {
            return false; // devuelve falso si la celda ya está ocupada
        }

    }
    public  void setHomeBtn(Button homeBtn){
        this.homeBtn = homeBtn;
    }
    public  void setJugarBtn(Button jugarBtn){
        this.jugarBtn = jugarBtn;
    }
    public  void setLblTunor(TextView lblNombre ){
        this.lblNombre = lblNombre;
    }


    // Este método devuelve la matriz de plantilla actual.
    public int[][] getPlantilla() {
        return platilla;

    }

    // Este método establece el número del jugador actual.
    public void setJugador(int juagador) {
        this.jugador = juagador;
    }
    public void setNames(String [] name){
        this.names = name;
    }


    // Este método devuelve el número del jugador actual.
    public int getJugador() {
        return jugador;
    }

    public boolean verificarGanador(){
        boolean ganador = false;
        for (int r = 0; r < 3; r++) {
            if (platilla[r][0] == platilla[r][1] && platilla[r][0] == platilla[r][2] && platilla[r][0] != 0) {
                ganador = true;
            }
        }
        for (int c  = 0;c < 3; c++) {
            if (platilla[0][c] == platilla[1][c] && platilla[2][c] == platilla[0][c] && platilla[0][c] != 0) {
                ganador = true;
            }
        }
        if (platilla[0][0] == platilla[1][1] && platilla[0][0] == platilla[2][2] && platilla[0][0] != 0) {
            ganador = true;
        }
        if (platilla[2][0] == platilla[1][1] && platilla[2][0] == platilla[0][2] && platilla[2][0] != 0) {
            ganador = true;
        }

        int boardFilled = 0 ;

        for (int r = 0; r <3; r++) {
            for (int c = 0; c < 3; c++) {
                if(platilla[r][c] != 0){
                    boardFilled+=1;

                }
            }
        }

        if (ganador) {
            jugarBtn.setVisibility(View.VISIBLE);
            homeBtn.setVisibility(View.VISIBLE);
            lblNombre.setText((names[jugador-1] + " Ganador!!!"));
            return true;
        }
        else if (boardFilled == 9){
            jugarBtn.setVisibility(View.VISIBLE);
            homeBtn.setVisibility(View.VISIBLE);
            lblNombre.setText("Empate");
            return true;
        }else{
            return false;
        }


    }

    public void resetGame(){
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                platilla[r][c] = 0;
            }
        }
        jugador = 1;

        jugarBtn.setVisibility(View.GONE);
        homeBtn.setVisibility(View.GONE);

        lblNombre.setText(names[0] + " Tuno");
    }


}

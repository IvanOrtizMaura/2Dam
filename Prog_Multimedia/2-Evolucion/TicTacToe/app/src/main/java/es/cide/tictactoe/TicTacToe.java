package es.cide.tictactoe;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class TicTacToe extends View {

    // Constantes para los colores del juego
    private final int boardColor, XColor, OColor, WinnerLineColor;

    // Objeto Paint para dibujar los elementos del juego
    private final Paint paint = new Paint();

    // Objeto que representa la lógica del juego
    private final LogicaJuego game;

    // Tamaño de cada celda del tablero
    private int cellSize = getWidth() / 3;

    private Boolean lineaGanadora = false;

    // Constructor de la clase
    public TicTacToe(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        // Inicializar la lógica del juego
        game = new LogicaJuego();

        // Obtener los valores de los atributos personalizados del juego
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.TicTacToe, 0, 0);
        try {
            boardColor = a.getInteger(R.styleable.TicTacToe_boartColor, 0);
            XColor = a.getInteger(R.styleable.TicTacToe_XColor, 0);
            OColor = a.getInteger(R.styleable.TicTacToe_OColor, 0);
            WinnerLineColor = a.getInteger(R.styleable.TicTacToe_winnerLineColor, 0);
        } finally {
            a.recycle();
        }
    }

    // Método para medir y establecer las dimensiones de la vista
    @Override
    protected void onMeasure(int width, int height) {
        super.onMeasure(width, height);

        // Obtener el tamaño mínimo entre el ancho y el alto de la vista
        int dimensiones = Math.min(getMeasuredWidth(), getMeasuredHeight());

        // Establecer el tamaño de cada celda del tablero
        cellSize = dimensiones / 3;

        // Establecer las dimensiones finales de la vista
        setMeasuredDimension(dimensiones, dimensiones);
    }

    // Método para dibujar los elementos del juego
    @Override
    protected void onDraw(Canvas canvas) {
        // Establecer el estilo y la suavidad de los bordes del dibujo
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);

        // Dibujar el tablero del juego
        drawGameBoard(canvas);

        // Dibujar las marcas de los jugadores en el tablero
        drawMarkers(canvas);
    }

    // Método para manejar el evento de toque en la vista
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // Obtener la posición del toque y el tipo de acción realizada
        float x = event.getX();
        float y = event.getY();
        int action = event.getAction();

        // Si el toque es de tipo DOWN
        if (action == MotionEvent.ACTION_DOWN) {
//             Obtener la fila y la columna correspondiente al toque
            int row = (int) Math.ceil(y / cellSize);
            int col = (int) Math.ceil(x / cellSize);
            if(!lineaGanadora){

                // Actualizar la plantilla del juego con el movimiento del jugador
                if (game.actializarPlantilla(row, col)) {
                    // Invalidar la vista para actualizar la pantalla
                    invalidate();

                    if(game.verificarGanador()){
                        lineaGanadora = true;
                        invalidate();
                    }

                    // Actualizar el turno del juego
                    if (game.getJugador() % 2 == 0) {
                        game.setJugador(game.getJugador() - 1);
                    } else {
                        game.setJugador(game.getJugador() + 1);
                    }
                }
            }

            return true;
        }
        return false;


    }

    private void drawGameBoard(Canvas canvas) {
        paint.setColor(boardColor);
        // Define el ancho del trazo de la línea del tablero
        paint.setStrokeWidth(12);
        // Dibuja las líneas verticales del tablero
        for (int c = 1; c < 3; c++) {
            canvas.drawLine(cellSize * c, 0, cellSize * c, canvas.getWidth(), paint);
        }

        // Dibuja las líneas horizontales del tablero
        for (int r = 1; r < 3; r++) {
            canvas.drawLine(0, cellSize * r, canvas.getWidth(), cellSize * r, paint);
        }

    }

    private void drawMarkers(Canvas canvas) {

        // Itera sobre la matriz de juego para dibujar los marcadores
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (game.getPlantilla()[r][c] != 0) {
                    // Si la casilla no está vacía, dibuja un marcador
                    if (game.getPlantilla()[r][c] == 1) {
                        drawX(canvas, r, c);
                    } else {
                        drawO(canvas);
                    }
                }
            }
        }
    }

    private void drawX(Canvas canvas, int row, int col) {
        paint.setColor(XColor);
        // Dibuja las dos líneas que forman la X
        canvas.drawLine((float) ((col + 1) * cellSize - cellSize * 0.2),
                (float) (row * cellSize + cellSize * 0.2),
                (float) (col * cellSize + cellSize * 0.2),
                (float) ((row + 1) * cellSize - cellSize * 0.2),
                paint);
        canvas.drawLine((float) ((col) * cellSize + cellSize * 0.2),
                (float) (row * cellSize + cellSize * 0.2),
                (float) ((col + 1) * cellSize - cellSize * 0.2),
                (float) ((row + 1) * cellSize - cellSize * 0.2),
                paint);

    }

    private void drawO(Canvas canvas) {
        int row = (int) (Math.random() * 3);
        int col = (int) (Math.random() * 3);
        paint.setColor(OColor);

        canvas.drawOval((float) ((col) * cellSize + cellSize * 0.2),
                (float) (row * cellSize + cellSize * 0.2),
                (float) ((col + 1) * cellSize - cellSize * 0.2),
                (float) ((row + 1) * cellSize - cellSize * 0.2),
                paint);
    }
    public void setUpGame(Button jugar, Button home, TextView labelJugador, String[]name){
        game.setJugarBtn(jugar);
        game.setHomeBtn(home);
        game.setLblTunor(labelJugador);
        game.setNames(name);
    }
    public void resetGame(){
        game.resetGame();
        lineaGanadora = false;
    }

}

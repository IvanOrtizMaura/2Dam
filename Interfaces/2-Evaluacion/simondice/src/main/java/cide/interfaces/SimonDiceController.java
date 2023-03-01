package cide.interfaces;

import java.util.ArrayList;
import java.util.Random;
import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;

public class SimonDiceController {

    @FXML
    private Button verde;

    @FXML
    private Button rojo;

    @FXML
    private Button azul;

    @FXML
    private Button amarillo;

    // Declaración de variables
    private ArrayList<Button> sequence; // Secuencia de botones
    private int sequenceIndex; // Índice de la secuencia actual
    private Random random; // Generador de números aleatorios

    // Método para inicializar la clase
    public void initialize() {
        sequence = new ArrayList<>();
        sequenceIndex = 0;
        random = new Random();
    }

    // Evento que se ejecuta al hacer clic en el botón "start"
    @FXML
    void start() {
        sequence.clear(); // Borra la secuencia anterior
        for (int i = 0; i < 10; i++) { // Genera una nueva secuencia de 10 botones aleatorios
            int colorIndex = random.nextInt(4);
            switch (colorIndex) {
                case 0:
                    sequence.add(verde);
                    break;
                case 1:
                    sequence.add(rojo);
                    break;
                case 2:
                    sequence.add(azul);
                    break;
                case 3:
                    sequence.add(amarillo);
                    break;
            }
        }
        sequenceIndex = 0; // Reinicia el índice de la secuencia actual
        playSequence(); // Inicia la reproducción de la secuencia
    }

    // Método que reproduce la secuencia actual de botones
    private void playSequence() {
        Button colorButton = sequence.get(sequenceIndex); // Obtiene el botón actual de la secuencia
        PauseTransition pause1 = new PauseTransition(javafx.util.Duration.seconds(1)); // Pausa de 1 segundo
        PauseTransition pause2 = new PauseTransition(javafx.util.Duration.seconds(0.5)); // Pausa de 0.5 segundos
        pause1.setOnFinished(event -> {
            colorButton.setStyle("-fx-background-color: white;"); // Cambia el color del botón a blanco
            pause2.play(); // Inicia la segunda pausa
        });
        pause2.setOnFinished(event -> {
            colorButton.setStyle("-fx-background-color: " + getButtonColor(colorButton) + ";"); // Cambia el color del botón a su color original
            sequenceIndex++; // Incrementa el índice de la secuencia actual
            if (sequenceIndex < sequence.size()) {
                playSequence(); // Si no se ha terminado la secuencia, inicia la reproducción del siguiente botón
            }
        });
        colorButton.setStyle("-fx-background-color: " + getButtonColor(colorButton) + ";"); // Cambia el color del botón a su color original
        pause1.play(); // Inicia la primera pausa
    }

    // Método que devuelve el color correspondiente a un botón
    private String getButtonColor(Button button) {
        if (button == verde) {
            return "green";
        } else if (button == rojo) {
            return "red";
        } else if (button == azul) {
            return "blue";
        } else if (button == amarillo) {
            return "yellow";
        } else {
            return "";
        }
    }

    public void instrucciones() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Instrucciones del juego Simon Dice");
        alert.setHeaderText(null);
        alert.setContentText("El juego consiste en repetir una secuencia de colores y sonidos que se van incrementando en complejidad. Cada vez que el usuario acierta la secuencia completa, se agrega un nuevo color y sonido a la secuencia a repetir. Si el usuario se equivoca, pierde la partida.");
    
        alert.showAndWait();
    }
}

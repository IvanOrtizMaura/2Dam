package es.cide.multiplatarforma;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textOperacion;
    TextView textResultado;
    String numero1 = "";
    String operador = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textOperacion = findViewById(R.id.textOperacion);
        textResultado = findViewById(R.id.textResultado);
    }

    public void escribirNumero(View view) {
        Button button = (Button) view;
//        Añadimos lo que hay dentro del View dentro de una variable
        numero1 = (String) textOperacion.getText();
//        Si es tiene cero añadimos lo que pulsamos en un boton
        if (numero1 == "0") {
            textOperacion.setText(button.getText());
//      Sino lo concatenamos
        } else {
            textOperacion.setText((textOperacion.getText()) + (String) (button.getText()));

        }
    }

    public void escribirOperaciones(View view) {
        Button button = (Button) view;
//      Cogemos solo el operador del textView
        operador = button.getText().toString();
        textOperacion.setText((textOperacion.getText()) + (String) (button.getText()));

    }

    public void escribirResultado(View view) {
        String operacion = (String) textOperacion.getText();
//        Comprobamos que el usuario haya insertado al menos un operador
        if (!(operador.equals("+") || operador.contains("-") || operador.contains("÷") || operador.contains("×") || operador.contains("%"))) {
            textOperacion.setText("Inserte un operador");
            return;
        }
//        Comprobamos que haya puesto solo un operador
        if ((operacion.contains("++") || operacion.contains("--") || operacion.contains("÷÷") || operacion.contains("××") || operacion.contains("%%"))) {
            textOperacion.setText("Solo un operador");
        } else {
//            textOperacion.setText("Inserte un operador");
//            Memos la operacion dentro de una array y separamos en dos cuando vemos un operador
            String[] lista = operacion.split("[-+×÷%]+");
//          Comprobamos que no se divida en mas de dos, que no haya dos simbolos
            if (lista.length > 2) {
                textOperacion.setText("Synx Err");
//                Sino lo metemos en una variable y segun el operador hacemos una operacion u otra
            } else {
                int operador1 = Integer.parseInt(lista[0]);
                int operador2 = Integer.parseInt(lista[1]);
                int resulta;
                if (operador.equals("+")) {
                    resulta = operador1 + operador2;
                    textOperacion.setText(String.valueOf(resulta));
                    textResultado.setText(String.valueOf(resulta));
                } else if (operador.equals("-")) {
                    resulta = operador1 - operador2;
                    if (resulta < 0) {
                        textOperacion.setText("Resultado negativo");
                    } else {
                        textResultado.setText(String.valueOf(resulta));
                        textOperacion.setText(String.valueOf(resulta));
                    }
                } else if (operador.equals("÷")) {
//                    Comprobamos que el usuario no lo divida entre 0 para que no de error
                    if (operador2 != 0) {
                        resulta = operador1 / operador2;
                        textResultado.setText(String.valueOf(resulta));
                    } else {
                        textOperacion.setText("Synt Err");
                    }

                } else if (operador.equals("×")) {
                    resulta = operador1 * operador2;
                    textResultado.setText(String.valueOf(resulta));
                } else if (operador.equals("%")) {
                    resulta = operador1 % operador2;
                    textResultado.setText(String.valueOf(resulta));
//                    Sino ha introducido un operador le decimos que lo introduzca
                } else {
                    textOperacion.setText("Introduce un operador");
                }
            }


        }
    }

    public void limpiarCalculadora(View view) {
        textOperacion.setText("0");
    }

}
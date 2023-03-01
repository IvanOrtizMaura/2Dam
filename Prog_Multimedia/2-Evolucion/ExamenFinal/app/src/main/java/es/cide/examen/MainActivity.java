package es.cide.examen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    RadioGroup radioGroup;
    TextView label;
    EditText numeros;
    Intent intent;
    static final int PETICIO_ACTIVITY_2 = 0002;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radioGroup = findViewById(R.id.radioGroup);
        label = findViewById(R.id.lbl);
        numeros = findViewById(R.id.txtNumero);
        numeros.setFilters(new InputFilter[]{ new MinMaxFilter( "1" , "50" )});

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton =group.findViewById(checkedId);
                String opcion = radioButton.getText().toString();
                String num = numeros.getText().toString();
                if (opcion.equalsIgnoreCase("copia el número")) {
                    label.setText(num);
                }else {
                    enviar();
                }

            }
        });


    }

    public void enviar() {
        intent = new Intent(this,Pantalla2.class);
        intent.putExtra("num",numeros.getText().toString());
        startActivityForResult(intent,PETICIO_ACTIVITY_2);
    }
    @Override
    protected  void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == PETICIO_ACTIVITY_2) {
            if (resultCode == RESULT_OK) {
                label.setText(data.getExtras().getString("texte2"));
            } else if (resultCode == RESULT_CANCELED) {
                label.setText("No ho han calculat");
            }else if(resultCode == RESULT_FIRST_USER){
                label.setText(data.getExtras().getString("texte3"));


            }else{
                label.setText(data.getExtras().getString("back"));
            }
        }
        super.onActivityResult(requestCode,resultCode, data);

    }

    private class MinMaxFilter implements InputFilter {
        private int mIntMin , mIntMax ;
        public MinMaxFilter ( int minValue , int maxValue) {
            this . mIntMin = minValue ;
            this . mIntMax = maxValue ;
        }
        public MinMaxFilter (String minValue , String maxValue) {
            this . mIntMin = Integer. parseInt (minValue) ;
            this . mIntMax = Integer. parseInt (maxValue) ;
        }
        @Override
        public CharSequence filter (CharSequence source , int start , int end , Spanned dest , int dstart , int dend) {
            try {
                int input = Integer. parseInt (dest.toString() + source.toString()) ;
                if (isInRange( mIntMin , mIntMax , input))
                    return null;
            } catch (NumberFormatException e) {
                e.printStackTrace() ;
            }
            return "" ;
        }
        private boolean isInRange ( int a , int b , int c) {
            return b > a ? c >= a && c <= b : c >= b && c <= a ;
        }
    }
}
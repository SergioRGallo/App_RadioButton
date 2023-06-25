package edu.utec.app_radiobutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText et1;
    private EditText et2;
    private TextView tv_resultado;
    private RadioButton rb_sumar;
    private RadioButton rb_restar;
    private RadioButton rb_multiplicar;
    private RadioButton rb_dividir;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText) findViewById(R.id.et_num1);
        et2 = (EditText) findViewById(R.id.et_num2);
        tv_resultado = (TextView) findViewById(R.id.tv_resultado);
        rb_sumar = (RadioButton) findViewById(R.id.rb_sumar);
        rb_restar = (RadioButton) findViewById(R.id.rb_restar);
        rb_multiplicar = (RadioButton) findViewById(R.id.rb_multiplicar);
        rb_dividir = (RadioButton) findViewById(R.id.rb_dividir);
    }

    //método para el botón calcular
    public void Calcular(View Vista){

        // recupero los valores y los convierto a String
        String valor1_String = et1.getText().toString();
        String valor2_String = et2.getText().toString();

        // convertir los datos a entero para poder realizar las operaciones
        int valor1_Int = Integer.parseInt(valor1_String);
        int valor2_Int = Integer.parseInt(valor2_String);

        // programamos la logica de nuestra app
        if(rb_sumar.isChecked() == true){             // si el rb_sumar esta seleccionado
            int suma = valor1_Int + valor2_Int;
            String resultado = String.valueOf(suma);  // paso el resultado de la operacion a String
            tv_resultado.setText(resultado);          // le asigno al TextView el resultado
        } else if (rb_restar.isChecked() == true) {
            int resta = valor1_Int - valor2_Int;
            String resultado = String.valueOf(resta);
            tv_resultado.setText(resultado);
        } else if (rb_multiplicar.isChecked() == true) {
            int multiplicar = valor1_Int * valor2_Int;
            String resultado = String.valueOf(multiplicar);
            tv_resultado.setText(resultado);
        } else if (rb_dividir.isChecked() == true) {
            if(valor2_Int != 0){
                int dividir = valor1_Int / valor2_Int;
                String resultado = String.valueOf(dividir);
                tv_resultado.setText(resultado);
            }else {
                Toast.makeText(this, "El seg[undo valor debe ser distinto de 0", Toast.LENGTH_LONG).show();
                tv_resultado.setText("" +
                        "");
            }

        }else {

            // utilizo toast para el indicar un mensaje
            Toast.makeText(this, "Ingrese la operacion a realizar", Toast.LENGTH_LONG).show();
            // context this: indicamos que se ejecute en esta activit
            // text: indicamos el mensaje que queremos
            // toast.length...: indicamos la duracion del mensaje
        }
    }

    // Metodo para limpiar la pantalla
    public void Limpiar(View Vista){
        et1.setText("");
        et2.setText("");
        rb_sumar.setChecked(false);
        rb_restar.setChecked(false);
        rb_multiplicar.setChecked(false);
        rb_dividir.setChecked(false);
        tv_resultado.setText("Resultado:");

    }


}
package co.edu.sena.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText txtOperador1;
    EditText txtOperador2;
    Spinner cboOperador;
    Button btnCalcular;
    TextView lblResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //asociacion de elementos

        txtOperador1=findViewById(R.id.txtOperador1);
        txtOperador2=findViewById(R.id.txtOperador2);
        cboOperador=findViewById(R.id.cboOperador);
        lblResultado=findViewById(R.id.lblResultado);
        btnCalcular=findViewById(R.id.btnCalcular);

        btnCalcular.setOnClickListener(this);
        cargarSpinner();
    }

    private void cargarSpinner() {
        String [] operadores={"Suma","Resta","Multilplicacion","Divisíon"};
        cboOperador.setAdapter(new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,operadores));

    }

    @Override
    public void onClick(View view) {
    switch (view.getId()){
        case R.id.btnCalcular:
            calcular();
            break;
    }
    }

    private void calcular() {
        Double operador1=Double.parseDouble(txtOperador1.getText().toString());
        Double operador2=Double.parseDouble(txtOperador2.getText().toString());
        Double resultado=0.0;
        switch (cboOperador.getSelectedItem().toString()){
            case "Suma":
                resultado=operador1+operador2;
                break;
            case "Resta":
                resultado=operador1-operador2;
                break;
            case "Multilplicacion":
                resultado=operador1*operador2;
                break;
            case "Divisíon":
                resultado=operador1/operador2;
                break;


        }
        lblResultado.setText(resultado.toString());

    }
}
package pe.edu.unc.appcilindror;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText txtRadio, txtAltura;
    TextView txtVolumen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //Inicializar los objetos(visuales)
        txtRadio = findViewById(R.id.txtRadio);
        txtAltura = findViewById(R.id.txtAltura);
        txtVolumen = findViewById(R.id.lbVolumen);
        txtVolumen.setText("");


    }

    public void calcularvolumen(View boton){
        if(validar())//si validar retorno true, entonces el metodo calcular termina
            return;
        //leer los datos de Edittext y convertirlos a double
        double radio = Double.valueOf(txtRadio.getText().toString());
        double altura = Double.valueOf(txtAltura.getText().toString());
        double volumen = Math.PI * Math.pow(radio, 2) * altura;
        txtVolumen.setText(String.valueOf(volumen));
    }

    private boolean validar() {
        if (txtRadio.getText().toString().trim().isEmpty()) {
            txtRadio.setError("Ingrese el radio");
            txtRadio.requestFocus();
            return true;
        }
        if (txtAltura.getText().toString().trim().isEmpty()) {
            txtAltura.setError("Ingrese la altura");
            txtAltura.requestFocus();
            return true;
        }
        return false;
    }
}
package rmr.java.mouredev22;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Esta clase nos permite saber si un número es primo,
 * así como ver la lista de números primos del 1 al 100
 *
 * @author Rafa M.
 * @version 1.0
 * @since 1.0
 */
public class MainActivity extends AppCompatActivity {
    private TextView tvPrimoList;
    private EditText etPrimoInput;
    private Button btPrimo, btPrimoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.tvPrimoList = findViewById(R.id.tvPrimoList);
        this.etPrimoInput = findViewById(R.id.etPrimoInput);
        this.btPrimo = findViewById(R.id.btPrimo);
        this.btPrimoList = findViewById(R.id.btPrimoList);
        btPrimo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isPrimo(Integer.valueOf(etPrimoInput.getText().toString()))) {
                    Toast.makeText(MainActivity.this, "Es primo!", Toast.LENGTH_SHORT).show();
                } else
                    Toast.makeText(MainActivity.this, "No es primo", Toast.LENGTH_SHORT).show();
            }
        });
        btPrimoList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvPrimoList.setText(getPrimoList());
            }
        });

    }

    /**
     * Método que permite saber si un número es o no primo
     * un número primo es aquel que solo es divisible entre 1 y sí mismo
     *
     * @param inputNumber ==> número a comprobar
     * @return ==> devuelve un booleano con la respuesta a si es o no primo
     * @version 1.0
     * @since 1.0
     */
    private boolean isPrimo(int inputNumber) {
        boolean isPrimo = false;
        int contador = 0;
        if (inputNumber == 1) {
            isPrimo = true;
        } else {
            for (int i = 1; i < inputNumber; i++) {
                if (inputNumber % i == 0) {
                    isPrimo = true;
                    contador++;
                } else {
                    isPrimo = false;
                }
            }
        }
        if (contador > 2) {
            isPrimo = false;
        } else {
            isPrimo = true;
        }
        return isPrimo;
    }

    /**
     * Método que devuelve la lista de números primos del 1 al 100
     *
     * @return==> lista de primos del 1 al 100
     * @version 1.0
     * @since 1.0
     */
    private String getPrimoList() {
        String primoList = "";
        for (int i = 1; i < 100; i++) {
            if (isPrimo(i)) {
                primoList += " " + i;
            }
        }
        return primoList;
    }
}
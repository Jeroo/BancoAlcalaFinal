package trabajofinal.alcala.salvador.com.bancoalcala;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import Models.Cuentas;
import Models.FirebaseReferences;
import Models.Usuarios;

public class AltaCuentasActivity extends AppCompatActivity {

    Button registrar;
    EditText nombre;
    EditText apellidos;
    EditText txtpin;
    EditText txtnumeroCuenta;
    TextView regresarLogin;
    SharedPreferences sp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alta_cuentas);

        registrar = (Button) findViewById(R.id.btn_registrar);
        nombre = (EditText) findViewById(R.id.registro_nombre);
        apellidos = (EditText) findViewById(R.id.registro_apellidos);
        txtpin = (EditText) findViewById(R.id.PIN);
        txtnumeroCuenta = (EditText) findViewById(R.id.numeroCuenta);
        regresarLogin = (TextView) findViewById(R.id.regresoLogin);


        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference bancoAlcalaRef = database.getReference(FirebaseReferences.BANCO_ALCALA_REFERENCE);

        txtnumeroCuenta.setVisibility(View.INVISIBLE);
        txtpin.setVisibility(View.INVISIBLE);

        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                int pin = generarPIN();
                int numeroCuenta = generarNumeroCuenta();

                txtpin.setVisibility(View.VISIBLE);
                txtnumeroCuenta.setVisibility(View.VISIBLE);
                txtpin.setText("PIN Generado: "+String.valueOf(pin));
                txtnumeroCuenta.setText("Numero de Cuenta: "+String.valueOf(numeroCuenta));

                txtnumeroCuenta.setEnabled(false);
                txtpin.setEnabled(false);
                nombre.setEnabled(false);
                apellidos.setEnabled(false);
                registrar.setVisibility(View.INVISIBLE);

                Toast toast1 = Toast.makeText(getApplicationContext(), "cuenta dada de alta correctamente su numero de cuenta es:  "+pin+" y su número de cuenta es: "+numeroCuenta+" para iniciar session debe indicar el numero de cuenta mas el pin ambos de 4 digitos, debe guardar sus datos", Toast.LENGTH_LONG);
                toast1.setGravity(Gravity.CENTER,0, 0);
                toast1.show();

                Cuentas cuenta = new Cuentas(pin,numeroCuenta,500.00);
                Usuarios usuario = new Usuarios(pin,nombre.getText().toString(),apellidos.getText().toString());

                bancoAlcalaRef.child(FirebaseReferences.CUENTA_REFERENCE).push().setValue(cuenta);
                bancoAlcalaRef.child(FirebaseReferences.USUARIOS_REFERENCE).push().setValue(usuario);




            }
        });
    }

    private int generarPIN() {

        String pin = "";
        int numeroPinAleatorio;
        for(int i=0;i<4;i++){
            numeroPinAleatorio = (int) (Math.random() * 4) + 1;
            pin+= numeroPinAleatorio;
        }

        return Integer.parseInt(pin);
    }

    private int generarNumeroCuenta() {

        String cuenta = "";
        int numeroCuentaAleatorio;
        for(int i=0;i<4;i++){
            numeroCuentaAleatorio = (int) (Math.random() * 4) + 1;
            cuenta+= numeroCuentaAleatorio;
        }

        return Integer.parseInt(cuenta);
    }

    public void onClick(View v) {
        Intent i = new Intent(this,LogonActivity.class);
        startActivity(i);
    }

}

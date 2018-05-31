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

public class IngresosActivity extends AppCompatActivity {

    Button ingresar;
    EditText txtingreso;
    TextView regresoIngresar;
    SharedPreferences sp;


    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference bancoAlcalaRef = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingresos);


        ingresar = (Button) findViewById(R.id.btn_ingresarMonto);
        txtingreso = (EditText) findViewById(R.id.txtingreso);
        regresoIngresar = (TextView) findViewById(R.id.regresoIngresar);


        ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sp = getSharedPreferences("login", Context.MODE_PRIVATE);
                int numerocuenta = sp.getInt("numerocuenta",0);
                if(ingresar(Integer.parseInt(txtingreso.getText().toString()),numerocuenta)){

                    Toast toast1 = Toast.makeText(getApplicationContext(), "Transaccion realizada con exito correctamente", Toast.LENGTH_SHORT);
                    toast1.setGravity(Gravity.CENTER,0, 0);
                    toast1.show();
                    txtingreso.setText("");

                }else {

                    Toast toast1 = Toast.makeText(getApplicationContext(), "Hubo un error en la transaccion", Toast.LENGTH_SHORT);
                    toast1.setGravity(Gravity.CENTER,0, 0);
                    toast1.show();

                }
            }
        });



    }

    public boolean ingresar(double nuevoMonto,int numeroCuenta){

        try {

            bancoAlcalaRef = database.getReference(FirebaseReferences.BANCO_ALCALA_REFERENCE);

          //  FirebaseReferences objRef = bancoAlcalaRef.child(FirebaseReferences.CUENTA_REFERENCE);

            //DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("cuentas").child(String.valueOf(numeroCuenta));

            Cuentas cuentas = new Cuentas(numeroCuenta,nuevoMonto);

            bancoAlcalaRef.child(FirebaseReferences.CUENTA_REFERENCE).child("numeroCuenta").child(String.valueOf(numeroCuenta)).setValue(cuentas);

            ///databaseReference.setValue(cuentas);

            return true;

        }catch (Exception e){

            return false;
        }



    }

    public void onClick(View v) {
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }
}

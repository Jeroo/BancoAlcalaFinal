package trabajofinal.alcala.salvador.com.bancoalcala;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import Models.Cuentas;
import Models.FirebaseReferences;
import Models.Usuarios;

public class LogonActivity extends AppCompatActivity {

    Button login;
    EditText txtcuenta;
    EditText txtpin;
    TextView registrarse;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logon);

        login = (Button) findViewById(R.id.btnLogin);
        txtcuenta = (EditText) findViewById(R.id.txtCuenta);
        txtpin = (EditText) findViewById(R.id.txtPIN);
        registrarse = (TextView) findViewById(R.id.txtRegistrarse);

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference bancoAlcalaRef = database.getReference(FirebaseReferences.BANCO_ALCALA_REFERENCE);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                bancoAlcalaRef.child(FirebaseReferences.CUENTA_REFERENCE).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        boolean logeado = false;
                        for (DataSnapshot snapshot:
                                dataSnapshot.getChildren()
                             ) {

                            Cuentas cuentas = snapshot.getValue(Cuentas.class);

                            Log.d("getNumeroCuenta",cuentas.getNumeroCuenta()+"");

                            if (String.valueOf(cuentas.getNumeroCuenta()).equals(txtcuenta.getText().toString()) &&
                                    String.valueOf(cuentas.getPin()).equals(txtpin.getText().toString())){



                                Toast toast1 = Toast.makeText(getApplicationContext(), "Usuario logeado correctamente", Toast.LENGTH_SHORT);
                                toast1.setGravity(Gravity.CENTER,0, 0);
                                toast1.show();
                                sp = getSharedPreferences("login", Context.MODE_PRIVATE);
                                sp.edit().putInt("numerocuenta",cuentas.getNumeroCuenta()).apply();
                                logeado = true;
                                goToMainActivity();

                                break;

                            }

                        }


                        if (!logeado){

                            Toast toast1 = Toast.makeText(getApplicationContext(), "Cuenta o numero de PIN incorrectos", Toast.LENGTH_SHORT);
                            toast1.setGravity(Gravity.CENTER,0, 0);
                            toast1.show();
                        }


                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        Toast toast1 = Toast.makeText(getApplicationContext(), "Hubo un error", Toast.LENGTH_SHORT);
                        toast1.setGravity(Gravity.CENTER,0, 0);
                        toast1.show();
                    }
                });

            }
        });
    }


    public void onClick(View v) {
        Intent i = new Intent(this,AltaCuentasActivity.class);
        startActivity(i);
    }


    public void goToMainActivity(){

        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }
}

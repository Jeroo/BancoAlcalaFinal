package trabajofinal.alcala.salvador.com.bancoalcala;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import Models.Cuentas;
import Models.FirebaseReferences;

public class MainActivity extends AppCompatActivity {

    Button ingresar;
    Button retirar;
    Button transferir;
    Button recarga;
    Button movimientos;
    Button saldos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ingresar = (Button) findViewById(R.id.btnIngreso);
        retirar = (Button) findViewById(R.id.btnRetirar);
        transferir = (Button) findViewById(R.id.btnTransferencia);
        recarga = (Button) findViewById(R.id.btnRecargaTelefonica);
        movimientos = (Button) findViewById(R.id.btnMovimientos);
        saldos = (Button) findViewById(R.id.btnSaldo);

        ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,IngresosActivity.class);
                startActivity(i);
            }
        });

        retirar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, RetirarActivity.class);
                startActivity(i);
            }
        });

        transferir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,TransferirActivity.class);
                startActivity(i);
            }
        });

        recarga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,RecargarActivity.class);
                startActivity(i);
            }
        });

        movimientos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,MovimientosActivity.class);
                startActivity(i);
            }
        });

        saldos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,SaldoActivity.class);
                startActivity(i);
            }
        });

    }

}

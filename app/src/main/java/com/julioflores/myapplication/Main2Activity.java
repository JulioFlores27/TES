package com.julioflores.myapplication;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.firebase.client.Firebase;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener{

    EditText nompad2, apellidos2, numerotelefonico2, email2, contrasena2, nombreescuela2, nombrestudiante2;
    private Button nr2, cancelar2;
    Firebase firebase;
    FirebaseAuth.AuthStateListener nauthlisten;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Firebase.setAndroidContext(this);
        firebase = new Firebase("https://tes-app-5d2c0.firebaseio.com/");
        nr2 = (Button) findViewById(R.id.r2);
        nompad2 = (EditText) findViewById(R.id.nombredelpadre);
        apellidos2 = (EditText) findViewById(R.id.apellidos);
        numerotelefonico2 = (EditText) findViewById(R.id.numerotelefonico);
        email2 = (EditText) findViewById(R.id.email);
        contrasena2 = (EditText) findViewById(R.id.contrasena);
        nombreescuela2 = (EditText) findViewById(R.id.nombreescuela);
        nombrestudiante2 = (EditText) findViewById(R.id.nombrestudiante);
        cancelar2 = (Button) findViewById(R.id.regresar2);
        nauthlisten = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null){
                }else{
                }
            }
        };
        nr2.setOnClickListener(this);
        cancelar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentar = new Intent(Main2Activity.this, MainActivity.class);
                startActivity(intentar);
                finish();
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.r2:
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                final DatabaseReference usuarioref = database.getReference(BasedeDatos.USUARIO_REFERENCE);
                final String valor1 = nompad2.getText().toString();
                final String valor2 = apellidos2.getText().toString();
                final String valor3 = numerotelefonico2.getText().toString();
                final String valor4 = email2.getText().toString();
                final String valor5 = contrasena2.getText().toString();
                final String valor6 = nombreescuela2.getText().toString();
                final String valor7 = nombrestudiante2.getText().toString();
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(valor4, valor5).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            BDUsuario usuario = new BDUsuario(""+valor1, ""+valor7, ""+valor2,
                                    ""+valor4, ""+valor5, "52 ("+valor3+")", ""+valor6);
                            usuarioref.push().setValue(usuario);
                            Toast toast1 = Toast.makeText(getApplicationContext(), "Correo Registrado Exitosamente", Toast.LENGTH_SHORT);
                            toast1.setGravity(Gravity.CENTER, 0, 0);
                            toast1.show();
                            Intent intentar = new Intent(Main2Activity.this, Main3Activity.class);
                            startActivity(intentar);
                            finish();
                        }else {
                            Toast toast1 = Toast.makeText(getApplicationContext(), "Correo No Se Pudo Registrar o Su Cuenta Ya Está Registrado", Toast.LENGTH_LONG);
                            toast1.setGravity(Gravity.CENTER, 0, 0);
                            toast1.show();
                        }
                    }
                });
                break;
        }
    }
}

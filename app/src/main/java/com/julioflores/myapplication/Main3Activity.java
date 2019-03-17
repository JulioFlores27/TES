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

public class Main3Activity extends AppCompatActivity implements View.OnClickListener{

    EditText nc3, np3;
    Button nr3;
    Firebase firebase3;
    FirebaseAuth.AuthStateListener nal3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Firebase.setAndroidContext(this);
        firebase3 = new Firebase("https://tes-app-5d2c0.firebaseio.com/");
        nc3 = (EditText) findViewById(R.id.c3);
        np3 = (EditText) findViewById(R.id.p3);
        nr3 = (Button) findViewById(R.id.r3);
        nal3 = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                } else {
                }
            }
        };
        nr3.setOnClickListener(this);
    }

    private void iniciarsesion3(String correo, String contraseña) {
        FirebaseAuth.getInstance().signInWithEmailAndPassword(correo, contraseña).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Intent intentar3 = new Intent(Main3Activity.this, Main4Activity.class);
                    startActivity(intentar3);
                    finish();
                } else {
                    Toast toast1 = Toast.makeText(getApplicationContext(), "Correo o Contraseña Incorrecta", Toast.LENGTH_LONG);
                    toast1.setGravity(Gravity.CENTER, 0, 0);
                    toast1.show();
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.r3:
                String correoini = nc3.getText().toString();
                String contraseñaini = np3.getText().toString();
                iniciarsesion3(correoini, contraseñaini);
                break;
        }
    }
}
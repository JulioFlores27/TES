package com.julioflores.myapplication;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Main4Activity extends AppCompatActivity {
    Button mostrarNotificacion;
    NotificationCompat.Builder notificacion;
    private static final int idUnica = 51623;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        mostrarNotificacion = (Button)findViewById(R.id.btnMostrarNotificacion);
        notificacion = new NotificationCompat.Builder(this);
        notificacion.setAutoCancel(true);

        mostrarNotificacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notificacion.setSmallIcon(R.mipmap.ic_launcher);
                notificacion.setTicker("Nueva notificacion");
                notificacion.setPriority(Notification.PRIORITY_HIGH);
                notificacion.setWhen(System.currentTimeMillis());
                notificacion.setContentTitle("Titulo");
                notificacion.setContentText("Tutorial Antut Notificaciones");

                Intent intent = new Intent(Main4Activity.this,Main4Activity.class);

                PendingIntent pendingIntent = PendingIntent.getActivity(Main4Activity.this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
                notificacion.setContentIntent(pendingIntent);

                NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                nm.notify(idUnica,notificacion.build());
            }
        });
    }
}

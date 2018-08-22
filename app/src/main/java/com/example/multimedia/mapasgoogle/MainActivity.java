package com.example.multimedia.mapasgoogle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnMarcadores, btnTipoMapas, btnMiUbicacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMarcadores = (Button) findViewById(R.id.btn_marcadores);
        btnTipoMapas = (Button) findViewById(R.id.btn_tipo_mapas);
        btnMiUbicacion = (Button) findViewById(R.id.btn_mi_ubicacion);

        btnMarcadores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MapsActivity.class);
                startActivity(intent);
            }
        });

        btnTipoMapas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MapsActivity2.class);
                startActivity(intent);
            }
        });

        btnMiUbicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MapsActivity3.class);
                startActivity(intent);
            }
        });
    }
}

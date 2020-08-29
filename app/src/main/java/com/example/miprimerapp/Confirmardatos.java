package com.example.miprimerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Confirmardatos extends AppCompatActivity implements View.OnClickListener {

    TextView nombre,fecha,telefono,email,descripcion;
    Button editardatos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmardatos);

        nombre=(TextView) findViewById(R.id.tvNombre);
        fecha=(TextView) findViewById(R.id.tvFechaNacimiento);
        telefono=(TextView) findViewById(R.id.tvTelefono);
        email=(TextView) findViewById(R.id.tvEmail);
        descripcion=(TextView) findViewById(R.id.tvDescripcion);
        editardatos=(Button) findViewById(R.id.ButtonEditar);

        Bundle Parametros= getIntent().getExtras();
        nombre.setText("Nombre: "+Parametros.getString("Nombre"));
        fecha.setText("Fecha de nacimiento: "+Parametros.getString("Fecha"));
        telefono.setText("Telefono: "+Parametros.getString("Telefono"));
        email.setText("Email: "+Parametros.getString("Email"));
        descripcion.setText("Descripcion: "+Parametros.getString("Descripcion"));

        editardatos.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

       finish();
    }
}



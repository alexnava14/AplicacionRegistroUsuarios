package com.example.miprimerapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageButton;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    AppCompatImageButton imgFecha;
    TextInputEditText tietFecha,nombre,telefono,email,descripcion;

    Button siguiente;
    private int dia,mes,ano;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgFecha=(AppCompatImageButton) findViewById(R.id.imgFecha);
        tietFecha=(TextInputEditText) findViewById(R.id.tietFecha);
        siguiente=(Button) findViewById(R.id.Buttonsiguiente);
        nombre=(TextInputEditText) findViewById(R.id.tilNombre);
        telefono=(TextInputEditText) findViewById(R.id.tiettelefono);
        email=(TextInputEditText) findViewById(R.id.tietemail);
        descripcion=(TextInputEditText) findViewById(R.id.tietdescripcion);
        /*

*/
        imgFecha.setOnClickListener(this);
        tietFecha.setOnClickListener(this);
        siguiente.setOnClickListener(this);


    }
/*
    @Override
    protected void onRestart() {
        super.onRestart();
        Bundle DatosPre= getIntent().getExtras();
        nombre.setText(DatosPre.getString("Nombre"));
        tietFecha.setText(DatosPre.getString("Fecha"));
        telefono.setText(DatosPre.getString("Telefono"));
        email.setText(DatosPre.getString("Email"));
        descripcion.setText(DatosPre.getString("Descripcion"));
    }*/

    private boolean ValidarEmail(){
        String Email=email.getText().toString().trim();

        if (Email.isEmpty()) {
            email.setError("No puede estar vacio");
            return false;
        }
        else{
            email.setError(null);
            return true;
        }

    }
    private boolean ValidarNombre(){
        String Nombre=nombre.getText().toString().trim();

        if (Nombre.isEmpty()) {
            nombre.setError("No puede estar vacio");
            return false;
        }
        else{
            nombre.setError(null);
            return true;
        }
    }
    private boolean ValidarTelefono(){
        String Telefono=telefono.getText().toString().trim();

        if (Telefono.isEmpty()) {
            telefono.setError("No puede estar vacio");
            return false;
        }
        else{
            telefono.setError(null);
            return true;
        }
    }
    private boolean ValidarFecha(){
        String Fecha=tietFecha.getText().toString().trim();

        if (Fecha.isEmpty()) {
            tietFecha.setError("No puede estar vacio");
            return false;
        }
        else{
            tietFecha.setError(null);
            return true;
        }
    }
    private boolean ValidarDescripcion(){
        String Descripcion=descripcion.getText().toString().trim();

        if (Descripcion.isEmpty()) {
            descripcion.setError("No puede estar vacio");
            return false;
        }
        else{
            descripcion.setError(null);
            return true;
        }
    }

    @Override
    public void onClick(View view) {
        if (view == imgFecha || view == tietFecha) {
            final Calendar ca = Calendar.getInstance();
            dia = ca.get(Calendar.DAY_OF_MONTH);
            mes = ca.get(Calendar.MONTH);
            ano = ca.get(Calendar.YEAR);

            DatePickerDialog dpd = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker View, int i, int i1, int i2) {
                    tietFecha.setText(i2 + "/" + (i1+1) + "/" + i);
                }
            }
            ,dia,mes,ano);

            dpd.show();
        }
        else if(view==siguiente){
            if(ValidarEmail() && ValidarNombre() && ValidarDescripcion() && ValidarFecha() && ValidarTelefono()) {
                Intent intent = new Intent(MainActivity.this, Confirmardatos.class);
                intent.putExtra("Nombre", nombre.getText().toString().trim());
                intent.putExtra("Fecha",tietFecha.getText().toString().trim());
                intent.putExtra("Telefono",telefono.getText().toString().trim());
                intent.putExtra("Email",email.getText().toString().trim());
                intent.putExtra("Descripcion",descripcion.getText().toString().trim());
                startActivity(intent);
            }
        }
    }
}
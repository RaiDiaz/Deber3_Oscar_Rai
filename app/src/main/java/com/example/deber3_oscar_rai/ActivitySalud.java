package com.example.deber3_oscar_rai;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;

import android.widget.EditText;

import android.widget.Toast;


public class ActivitySalud extends AppCompatActivity {

    private ItemList listaSalud;
    private EditText descripcion;
    private EditText valor;

    public ActivitySalud() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salud);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        listaSalud=new ItemList();
        descripcion= findViewById(R.id.edit_descripcion);
        valor= findViewById(R.id.edit_valor);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        startActivity(new Intent(ActivitySalud.this,MainActivity.class));
        return super.onOptionsItemSelected(item);
    }

    public void addItem(View v){
        if(TextUtils.isEmpty(descripcion.getText().toString())||TextUtils.isEmpty(valor.getText().toString())){
            Toast toast = Toast.makeText(this, "Por favor llene todos los campos",
                    Toast.LENGTH_SHORT);
            toast.show();
        }
        else{
            listaSalud.addItem(descripcion.getText().toString(),Double.parseDouble(valor.getText().toString()));
        }
    }


}
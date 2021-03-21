package com.example.deber3_oscar_rai;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityComida extends AppCompatActivity {

    private ItemList listaComida;
    private EditText descripcion;
    private EditText valor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comida);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        listaComida=new ItemList();
        descripcion=(EditText) findViewById(R.id.edit_descripcion);
        valor=(EditText) findViewById(R.id.edit_valor);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        startActivity(new Intent(ActivityComida.this,MainActivity.class));
        return super.onOptionsItemSelected(item);
    }

    public void startEditItem(View v) {
        Intent intent = new Intent(ActivityComida.this, EditItemActivity.class);
        startActivity(intent);
    }

    public void addItem(){
        if(TextUtils.isEmpty(descripcion.getText().toString())||TextUtils.isEmpty(descripcion.getText().toString())){
            Toast toast = Toast.makeText(this, "Por favor llene todos los campos",
                    Toast.LENGTH_SHORT);
            toast.show();
        }
        else{
            listaComida.addItem(descripcion.getText().toString(),Double.parseDouble(valor.getText().toString()));
        }
    }



}
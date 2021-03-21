package com.example.deber3_oscar_rai;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;

import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class ActivitySalud extends AppCompatActivity {

    private ItemList listaSalud;
    private ArrayAdapter<Item> adaptador1;
    private EditText descripcion;
    private EditText valor;
    private ListView lv1;
    private ModeloItemLists mItemLists = ModeloItemLists.getInstance();
    private int intValue;

    public ActivitySalud() {

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salud);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        intValue = getIntent().getIntExtra("indexLista", 0);
        listaSalud = mItemLists.getListaDeItems(intValue);
        TextView titulo=(TextView) findViewById(R.id.titulo_Item);
        titulo.setText(listaSalud.getNombreLista());
        adaptador1=new ArrayAdapter<Item>(this,R.layout.row,listaSalud);
        lv1=findViewById(R.id.list_items);
        lv1.setAdapter(adaptador1);
        descripcion = findViewById(R.id.edit_descripcion);
        valor = findViewById(R.id.edit_valor);
        // descripcion=(EditText) findViewById(R.id.edit_descripcion);
        // valor=(EditText) findViewById(R.id.edit_valor);

        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                final int posicion=i;

                Intent intent = new Intent(ActivitySalud.this, EditItemActivity.class);
                ArrayList datos=new ArrayList<>(Arrays. asList(intValue,posicion,adaptador1));
                intent.putExtra("Datos", datos);
                startActivity(intent);


            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        startActivity(new Intent(ActivitySalud.this,MainActivity.class));
        return super.onOptionsItemSelected(item);
    }

        @RequiresApi(api = Build.VERSION_CODES.O)
        public void addItem(View v){
        Toast toast;
        if(TextUtils.isEmpty(descripcion.getText().toString())||TextUtils.isEmpty(valor.getText().toString())){
            toast = Toast.makeText(this, "Por favor llene todos los campos",
                    Toast.LENGTH_SHORT);
            toast.show();
        }
        else{
            listaSalud.addItem(descripcion.getText().toString(),Double.parseDouble(valor.getText().toString()));
            adaptador1.notifyDataSetChanged();
            descripcion.setText("");
            valor.setText("");
            toast = Toast.makeText(this, "Item agregado exitosamente"+listaSalud.size(),
                    Toast.LENGTH_SHORT);
            toast.show();

        }
    }


}
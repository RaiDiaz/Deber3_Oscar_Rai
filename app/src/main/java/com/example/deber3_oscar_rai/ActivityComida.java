package com.example.deber3_oscar_rai;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Movie;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ActivityComida extends AppCompatActivity {

    private ModeloItemLists mItemLists = ModeloItemLists.getInstance();
    private ItemList listaItems;
    private EditText descripcion;
    private EditText valor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comida);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        Intent mIntent = getIntent();
        int intValue = mIntent.getIntExtra("indexLista", 0);
        listaItems=mItemLists.getListaDeItems(intValue);
        descripcion=(EditText) findViewById(R.id.edit_descripcion);
        valor=(EditText) findViewById(R.id.edit_valor);
        TextView titulo=(TextView) findViewById(R.id.titulo_Item);
        titulo.setText(listaItems.getNombreLista());
        TableLayout tablaDatos=(TableLayout) findViewById(R.id.tabla_Datos);
        TableRow row=new TableRow(this);
        TextView t1=new TextView(this);
        TextView t2=new TextView(this);
        TextView t3=new TextView(this);
        TextView t4=new TextView(this);
        t1.setText("valor");
        t2.setText("valor");
        t3.setText("valor");
        t4.setText("Edit");
        row.addView(t1);
        row.addView(t2);
        row.addView(t3);
        row.addView(t4);
        tablaDatos.addView(row);

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

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void addItem(View v){
        if(TextUtils.isEmpty(descripcion.getText().toString())||TextUtils.isEmpty(valor.getText().toString())){
            Toast toast = Toast.makeText(this, "Por favor llene todos los campos",
                    Toast.LENGTH_SHORT);
            toast.show();
        }
        else{
            listaItems.addItem(descripcion.getText().toString(),Double.parseDouble(valor.getText().toString()));
            Toast toast1 = Toast.makeText(this, "Item agregado exitosamente: "+listaItems.size(),
                    Toast.LENGTH_SHORT);
            toast1.show();
        }
    }

    public void startEditItemActivity(View v) {
        Intent intent = new Intent(ActivityComida.this, EditItemActivity.class);
        startActivity(intent);
    }

}
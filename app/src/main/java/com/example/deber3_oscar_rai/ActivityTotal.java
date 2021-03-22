package com.example.deber3_oscar_rai;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

//actividad que despliega los totales de los items
public class ActivityTotal extends AppCompatActivity {

    private ModeloItemLists mItemLists = ModeloItemLists.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_total);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        TextView total_comida, total_educacion, total_salud, total_general;

        total_comida = findViewById(R.id.total_comida);
        total_salud = findViewById(R.id.total_salud);
        total_educacion = findViewById(R.id.total_educacion);
        total_general = findViewById(R.id.total_general);

        total_comida.setText(String.format("%,.2f", mItemLists.getListaDeItems(0).getTotal()));
        total_salud.setText(String.format("%,.2f", mItemLists.getListaDeItems(1).getTotal()));
        total_educacion.setText(String.format("%,.2f", mItemLists.getListaDeItems(2).getTotal()));
        total_general.setText(String.format("%,.2f", mItemLists.totalListas()));

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        startActivity(new Intent(ActivityTotal.this,MainActivity.class));
        return super.onOptionsItemSelected(item);
    }
}

package com.example.deber3_oscar_rai;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private ModeloItemLists mItemLists = ModeloItemLists.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startActivityComida(View v) {
        Intent intent = new Intent(MainActivity.this, ActivityComida.class);
        intent.putExtra("indexLista",0);
        startActivity(intent);
    }

    public void startActivitySalud(View v) {
        Intent intent = new Intent(MainActivity.this, ActivitySalud.class);
        intent.putExtra("indexLista",1);
        startActivity(intent);
    }

    public void startActivityEducacion(View v) {
        Intent intent = new Intent(MainActivity.this, ActivityComida.class);
        intent.putExtra("indexLista",2);
        startActivity(intent);
    }

}
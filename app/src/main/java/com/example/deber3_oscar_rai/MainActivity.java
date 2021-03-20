package com.example.deber3_oscar_rai;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startActivityComida(View v) {
        Intent intent = new Intent(MainActivity.this, ActivityComida.class);
        startActivity(intent);
    }

    public void startActivitySalud(View v) {
        Intent intent = new Intent(MainActivity.this, ActivitySalud.class);
        startActivity(intent);
    }

    public void startActivityEducacion(View v) {
        Intent intent = new Intent(MainActivity.this, ActivityEducacion.class);
        startActivity(intent);
    }
}
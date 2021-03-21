package com.example.deber3_oscar_rai;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.RequiresApi;

public class EditItemActivity extends Activity {

    private ModeloItemLists mItemLists = ModeloItemLists.getInstance();
    private ItemList listaItems;
    private int[] intValue;
    private EditText descripcion;
    private EditText valor;
    private ListView lv1;
    private Item editItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_edit_item);
        intValue = getIntent().getIntArrayExtra("Datos");
        listaItems = mItemLists.getListaDeItems(intValue[0]);
        descripcion = findViewById(R.id.edit_descripcion);
        valor = findViewById(R.id.edit_valor);
        editItem=listaItems.get(intValue[1]);
        descripcion.setText(editItem.getDescripcion());
        valor.setText(String.valueOf(editItem.getValor()));
        lv1=findViewById(R.id.list_items);
    }

    public void finishDialog(View v) {
        EditItemActivity.this.finish();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void actualizar_item(View v){
        editItem.setDescripcion(descripcion.getText().toString());
        editItem.setValor(Double.valueOf(valor.getText().toString()));
        editItem.setFechaYHora();
        finishDialog(v);
    }

    public void eliminar_item(View v){
        listaItems.removeItem(editItem);
        finishDialog(v);
    }
    public void cancelar(View v){
        finishDialog(v);

    }
}
package com.example.deber3_oscar_rai;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class EditItemActivity extends Activity {

    private ModeloItemLists mItemLists = ModeloItemLists.getInstance();
    private ArrayAdapter<Item> adaptador1;
    private ItemList listaItems;
    private int[] intValue;
    private EditText descripcion;
    private EditText valor;
    private ListView lv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_edit_item);
        intValue = getIntent().getIntArrayExtra("Datos");
        listaItems = mItemLists.getListaDeItems(intValue[0]);
        descripcion = findViewById(R.id.edit_descripcion);
        valor = findViewById(R.id.edit_valor);
        descripcion.setText(listaItems.get(intValue[1]).getDescripcion());
        valor.setText(String.valueOf(listaItems.get(intValue[1]).getValor()));
        lv1=findViewById(R.id.list_items);
        adaptador1 = lv1.getAdapter();

    }

    public void finishDialog(View v) {
        EditItemActivity.this.finish();
    }

    public void actualizar_item(View v){

        finishDialog(v);

    }
    public void eliminar_item(View v){

        finishDialog(v);

    }
    public void cancelar(View v){

        finishDialog(v);

    }
}
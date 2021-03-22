package com.example.deber3_oscar_rai;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.EditText;

import android.widget.Toast;

import androidx.annotation.RequiresApi;

//actividad para actualizar y eliminar items
public class EditItemActivity extends Activity {

    //datos miembro de la clase
    private ModeloItemLists mItemLists = ModeloItemLists.getInstance();
    private ItemList listaItems;
    private int[] intValue;
    private EditText descripcion;
    private EditText valor;
    private Item editItem;
    private Toast toast;

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
    }

    public void finishDialog(View v) {
        EditItemActivity.this.finish();
    }

    //funciones para actualizar y eliminar items a traves de la lista
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void actualizar_item(View v){
        if(TextUtils.isEmpty(descripcion.getText().toString())||TextUtils.isEmpty(valor.getText().toString())){
            toast = Toast.makeText(this, "Por favor llene todos los campos",
                    Toast.LENGTH_SHORT);
            toast.show();
        }
        else{
            listaItems.actualizarItem(intValue[1],descripcion.getText().toString(),Double.valueOf(valor.getText().toString()));
            toast = Toast.makeText(this, "Item actualizado exitosamente",
                    Toast.LENGTH_SHORT);
            toast.show();
            setResult(RESULT_OK);
            finishDialog(v);
        }
    }

    public void eliminar_item(View v){
        listaItems.removeItem(editItem);
        toast = Toast.makeText(this, "Item eliminado exitosamente: "+listaItems.size(),
                Toast.LENGTH_SHORT);
        toast.show();
        setResult(RESULT_OK);
        finishDialog(v);
    }

    //funcion para cancelar edicion de items
    public void cancelar(View v){
        toast = Toast.makeText(this, "Edición cancelada",
                Toast.LENGTH_SHORT);
        toast.show();
        finishDialog(v);

    }
}
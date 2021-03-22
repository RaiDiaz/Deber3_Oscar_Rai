package com.example.deber3_oscar_rai;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

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


//actividad para agregar y ver items
public class ActivityItems extends AppCompatActivity {

    public static final int REQUEST = 1;

    private ItemList listItem;
    private ArrayAdapter<Item> adaptador1; //adaptador que permite transformar un objeto de ArrayList a un View para cargar contenido de un ListView
    private EditText descripcion;
    private EditText valor;
    private TextView total_item;
    private ListView lv1;
    private ModeloItemLists mItemLists = ModeloItemLists.getInstance();
    private int intValue;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        intValue = getIntent().getIntExtra("indexLista", 0);
        listItem = mItemLists.getListaDeItems(intValue);
        TextView titulo=(TextView) findViewById(R.id.titulo_Item);
        titulo.setText(listItem.getNombreLista());
        total_item=(TextView) findViewById(R.id.total_item);
        total_item.setText(String.format("%,.2f",listItem.getTotal()));
        adaptador1=new ArrayAdapter<Item>(this,R.layout.row,listItem);
        lv1=findViewById(R.id.list_items);
        lv1.setAdapter(adaptador1);
        descripcion = findViewById(R.id.edit_descripcion);
        valor = findViewById(R.id.edit_valor);

        //Listener onClick que inicia EditItemActivity
        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                final int posicion=i;

                Intent intent = new Intent(ActivityItems.this, EditItemActivity.class);
                int[] datos = new int[]{intValue, posicion};
                intent.putExtra("Datos", datos);//se envia informacion del item seleccionado y la lista de items
                startActivityForResult(intent,REQUEST);
            }
        });
    }

    //Override de onActivityResult. Cuando se edita o se elimina un item, se actualiza los datos mostrados en ActivityItems
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Test for the right intent reply.
        if (requestCode == REQUEST) {
            // Test to make sure the intent reply result was good.
            if (resultCode == RESULT_OK) {
                total_item.setText(String.format("%,.2f",listItem.getTotal()));
                adaptador1.notifyDataSetChanged();
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        startActivity(new Intent(ActivityItems.this,MainActivity.class));
        return super.onOptionsItemSelected(item);
    }

    //Metodo para agregar items
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void addItem(View v){
        Toast toast;
        if(TextUtils.isEmpty(descripcion.getText().toString())||TextUtils.isEmpty(valor.getText().toString())){
            toast = Toast.makeText(this, "Por favor llene todos los campos",
                    Toast.LENGTH_SHORT);
            toast.show();
        }
        else{
            listItem.addItem(descripcion.getText().toString(),Double.parseDouble(valor.getText().toString()));
            adaptador1.notifyDataSetChanged();
            descripcion.setText("");
            valor.setText("");
            total_item.setText(String.format("%,.2f",listItem.getTotal()));
            toast = Toast.makeText(this, "Item agregado exitosamente"+listItem.size(),
                    Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}
package com.example.deber3_oscar_rai;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

public class EditItemActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_edit_item);
    }

    public void finishDialog(View v) {
        EditItemActivity.this.finish();
    }
}

package com.example;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.Toast;

import com.example.EditNameDialog.EditNameDialogListener;

public class FragmentDialogDemo extends FragmentActivity implements EditNameDialogListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        showEditDialog();
    }

    private void showEditDialog() {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(new EditNameDialog(), "dlg_edit_name");
        ft.addToBackStack(null);
        ft.commit();
    }

    @Override
    public void onFinishEditDialog(String inputText) {
        FragmentManager fm = getSupportFragmentManager();
        fm.popBackStack();
        Toast.makeText(this, "Hi, " + inputText, Toast.LENGTH_SHORT).show();
    }

}

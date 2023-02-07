package com.example.mytoastdialogaplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private Button editButton;
    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        textView.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
        editButton =findViewById(R.id.editButton);
        dialog = new Dialog(MainActivity.this);
    }
    public  void btnClick(View view){
        switch (view.getId()) {
            case R.id.editButton: {
                showCustomDialog();
                break;
            }
            case R.id.showButton: {
                Toast toast = Toast.makeText(this, textView.getText(),Toast.LENGTH_LONG);
                toast.show();
                break;
            }
        }
    }
    private void showCustomDialog() {
        dialog.setContentView(R.layout.custom_dialog_loyout);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setCancelable(true);

        Button save = dialog.findViewById(R.id.ok);
        EditText editText;
        editText = dialog.findViewById(R.id.editText);
        editText.setText(textView.getText());
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(editText.getText());
                dialog.cancel();
            }
        }) ;
        dialog.show();
    }

}
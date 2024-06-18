package com.example.alertdialog;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomsheet.BottomSheetDialog;

public class MainActivity extends AppCompatActivity {
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        btn=findViewById(R.id.alert);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                showAlertBox();
                showBottomSheetDialog();
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void showBottomSheetDialog() {
        BottomSheetDialog bottomSheetDialog=new BottomSheetDialog(this);
        View bottomSheetView= LayoutInflater.from(getApplicationContext()).inflate(R.layout.bottom_sheet,null);

        EditText phone=bottomSheetView.findViewById(R.id.edit_text_phone_number);
        Button button=bottomSheetView.findViewById(R.id.button_submit);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number=phone.getText().toString();
                Toast.makeText(MainActivity.this, ""+number, Toast.LENGTH_SHORT).show();
            }
        });

        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();
    }

    private void showAlertBox() {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Hello");
        builder.setMessage("Continue working hard dont tire");

        builder.setPositiveButton("Continue", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        AlertDialog dialog=builder.create();
        dialog.show();
    }
}